package com.mysheng.office.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.StringUtil;
import com.mysheng.office.model.Result;
import com.mysheng.office.model.TokenModel;
import com.mysheng.office.model.UserModel;
import com.mysheng.office.service.RedisService;
import com.mysheng.office.service.TokenService;
import com.mysheng.office.service.UserModelService;
import com.mysheng.office.util.HttpRequestUtils;
import com.mysheng.office.util.PageBean;
import com.mysheng.office.util.ResultUtil;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    protected Logger logger = LoggerFactory.getLogger(getClass());
    @Value("UPLOAD_FILE_DIR")
    private static String uploadDir;
    @Value("UPLOAD_FILE_HOST")
    private static String uploadHost;
    @Value("${wx.appid}")
    private String appid;
    @Value("${wx.secret}")
    private String secret;

    @Autowired
    private UserModelService userModelService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public Result<UserModel> findAllUser(){
        Page page=PageHelper.startPage(1,3);
        List<UserModel>list=userModelService.queryUsers();
        PageBean<UserModel> pageBean=new PageBean<UserModel>(1,3,page.getTotal());
        pageBean.setItems(list);

        if(list.size()>0){

            return ResultUtil.success(0,"查询成功",pageBean);
        }
        return ResultUtil.success(1,"没有查到用户");
    }

    /**
     * PC端获取用户信息
     * @param request
     * @return
     */
    @PostMapping(value = "/getUserInfo")
    public Result getUserInfo(HttpServletRequest request){
        String token=request.getHeader("token");
        if (StringUtil.isEmpty(token)){
            return ResultUtil.success(401,"您没有登录");
        }
        TokenModel model=null;
        if(redisService.get("token"+token)!=null){
            model= (TokenModel) redisService.get("token"+token);
            return ResultUtil.success(0,"缓存读取成功",model);
        }else{
            String userId= (String) redisService.get(token);
            model= tokenService.queryTokenById(userId);
            if(model!=null){
                redisService.set("token"+token,model);
                redisService.set(model.getToken(),model.getUserId());
                return ResultUtil.success(0,"查询成功",model);
            }

        }
        return ResultUtil.success(402,"登录信息过期");
    }

    /**
     * 小程序获取用户信息
     * @param request
     * @param params
     * @return
     */
    @PostMapping(value = "/getToken")
    public Result getUserToken(HttpServletRequest request,@RequestBody Map<String,String> params){
        String code = params.get("code");
        String token=request.getHeader("token");
        String openId=params.get("openId");
        if(StringUtils.isEmpty(openId)) {
            String wxUrl = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appid + "&secret=" + secret + "&js_code=" + code + "&grant_type=authorization_code";
            String wxJson = HttpRequestUtils.sendGet(wxUrl);
            JSONObject wxObj = JSON.parseObject(wxJson);
            openId = wxObj.getString("openid");
        }
        TokenModel model=null;
        if(redisService.get(openId)!=null){
            model= (TokenModel) redisService.get(openId);
            return ResultUtil.success(0,"缓存读取成功",model);
        }else{
            model= tokenService.queryTokenByOpenid(openId);
            if(model!=null){
                redisService.set(openId,model,60*60L);
                redisService.set(model.getToken(),model.getUserId());//在缓存端用token换取userId;
                return ResultUtil.success(0,"查询成功",model);
            }

        }
        return ResultUtil.success(402,"登录信息已过期");
    }
    @PostMapping(value = "/reg")
    public Result addUser(@RequestBody UserModel user){
        String openid="";
        if(StringUtils.isNotEmpty(user.getCode())){
            String wxUrl="https://api.weixin.qq.com/sns/jscode2session?appid="+appid+"&secret="+secret+"&js_code="+user.getCode()+"&grant_type=authorization_code";
            String wxJson=HttpRequestUtils.sendGet(wxUrl);
            JSONObject wxObj = JSON.parseObject(wxJson);
            openid=wxObj.getString("openid");
            if(StringUtils.isNotEmpty(openid)){
                user.setOpenId(openid);
                user.setSessionKey(wxObj.getString("session_key"));
            }
        }

        if(StringUtils.isEmpty(user.getPhoneNum())){
            return   ResultUtil.success(1,"手机号不能为空");
        }
        if(StringUtils.isEmpty(user.getPassword())){
            return   ResultUtil.success(1,"密码不能为空");
        }
        UserModel userModel=userModelService.queryUserByPhone(user.getPhoneNum());
        if(userModel!=null){
            if (openid.equals(userModel.getOpenId())){
                TokenModel model= tokenService.queryTokenByOpenid(userModel.getOpenId());
                return ResultUtil.success(0,"查询成功",model);

            }else{
                return ResultUtil.success(1,"该手机号已注册");
            }
        }else{
            TokenModel tokenModel=userModelService.insertUser(user);
            redisService.set("token"+tokenModel.getToken(),tokenModel,60*60L);
            redisService.set(tokenModel.getToken(),tokenModel.getUserId());
            return ResultUtil.success(0,"注册成功",tokenModel);
        }

    }

    @PostMapping(value = "/updatePw")
    public Result updateUserPassword(@RequestBody Map<String,String> params){
        String userPassword = params.get("userPassword");
        String oldPassword = params.get("oldPassword");
        String phoneNum = params.get("phoneNum");
        int num=userModelService.updateUserPassword(oldPassword,userPassword,phoneNum);
        if (num==1){
            return ResultUtil.success(0,"修改用户密码成功");
        }
        return ResultUtil.success(1,"原密码不正确");
    }
    @PostMapping(value = "/login")
    public Result loginInfo(@RequestBody Map<String,String> params){
        String phone = params.get("phone");
        String password = params.get("password");
        TokenModel model=userModelService.loginInfo(phone,password);
        if (model!=null){
            redisService.set(model.getOpenId(),model,60*60L);
            redisService.set(model.getToken(),model.getUserId());
            redisService.set("token"+model.getToken(),model);
            return ResultUtil.success(0,"登陆成功",model);
        }
        return ResultUtil.success(1,"密码或手机号不正确");
    }



    @GetMapping(value = "/delete")
    public Result deleteUser(String id){
        int num=userModelService.deleteUser(id);
        if (num==1){
            return ResultUtil.success(0,"删除用户成功");
        }
        return ResultUtil.success(1,"删除用户失败");
    }

}
