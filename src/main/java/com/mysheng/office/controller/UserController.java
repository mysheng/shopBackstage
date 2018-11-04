package com.mysheng.office.controller;

import com.github.pagehelper.StringUtil;
import com.mysheng.office.base.BaseControllor;
import com.mysheng.office.base.Errors;
import com.mysheng.office.base.Results;
import com.mysheng.office.base.SystemCache;
import com.mysheng.office.model.Result;
import com.mysheng.office.model.User;
import com.mysheng.office.service.UserService;
import com.mysheng.office.util.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/user")
public class UserController extends BaseControllor{
    protected Logger logger = LoggerFactory.getLogger(getClass());
    @Value("UPLOAD_FILE_DIR")
    private static String uploadDir;
    @Value("UPLOAD_FILE_HOST")
    private static String uploadHost;
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public Result<User> findAllUser(){
        List<User>list=userService.queryUsers();
        if(list.size()>0){
            return ResultUtil.success(1,"查询成功",userService.queryUsers());
        }
        return ResultUtil.success(1,"没有查到用户");
    }
    @GetMapping(value = "/getUserInfo")
    public Result findById(@RequestParam("id") Integer id){
        User user=userService.queryUserById(id);
        if(user!=null){
            return ResultUtil.success(1,"查询成功",user);
        }else{
            return ResultUtil.success(0,"没找到对应的用户");
        }

    }
    @PostMapping(value = "/register")
    public Result addUser(User user){
        logger.info("调用用户注册接口开始!");
        int num=userService.insertUser(user);
        if(num>0){
            logger.info("调用用户注册接口结束!");
            return ResultUtil.success(1,"注册成功");
        }
        logger.info("调用用户注册接口结束!");
       return ResultUtil.success(0,"注册失败");
    }
    @PostMapping(value = "/update")
    public Result updateUser(@RequestBody User user)throws Exception{
        logger.info("调用用户完善个人信息接口开始!");
        boolean flag = true;
        try {
            MultipartHttpServletRequest re = (MultipartHttpServletRequest) request();
        } catch (Exception e) {
            flag = false;
        }
        if (flag) {
            UpLoadFile upLoadFile = FileUtils.upLoadFileByName(uploadDir,uploadHost, "image", request());
            if (StringUtils.isNotEmpty(upLoadFile.getUrl())) {
                user.setHeadImage(upLoadFile.getUrl());
            }
        }

        int num=userService.updateUser(user);
        if(num>0){
            logger.info("调用用户完善个人信息接口结束!");
            return ResultUtil.success(1,"修改用户信息成功");
        }
        logger.info("调用用户完善个人信息接口结束!");
        return ResultUtil.success(0,"修改用户信息失败");

    }
    @PostMapping(value = "/updatePw")
    public Result updateUserPassword(@RequestBody Map<String,Object> params){
        String userPassword = params.get("userPassword").toString();
        String oldPassword = params.get("oldPassword").toString();
        Integer userId = (Integer) params.get("userId");
        int num=userService.updateUserPassword(oldPassword,userPassword,userId);
        if (num==1){
            return ResultUtil.success(1,"修改用户密码成功");
        }
        return ResultUtil.success(0,"愿密码不正确");
    }
   /* @PostMapping(value = "/login")
    public Result loginInfo(@RequestBody Map<String,Object> params){
        String phone = params.get("phone").toString();
        String password = params.get("userPassword").toString();
        int num=userService.loginInfo(phone,password);
        if (num==1){
            return ResultUtil.success(1,"登陆成功");
        }
        return ResultUtil.success(0,"密码或手机号不正确");
    }*/
    @PostMapping(value = "/login")
    public void login(@RequestBody User userEx) {
        logger.info("调用用户登录接口开始!");
        String mobile = userEx.getPhone();
        String password = userEx.getPassword();

        if (StringUtils.isEmpty(mobile)) {
            logger.info("调用用户登录接口结束!");
            returnJson(Results.failure(Errors._200201, "手机号"));
            return;
        }

        if (!mobile.matches("^1[3-8]\\d{9}$")) {
            logger.info("调用用户登录接口结束!");
            returnJson(Results.failure(Errors._200209, "手机号"));
            return;
        }



        User temp = new User();
        temp.setPhone(mobile);
        List<User> userList = userService.queryList(temp);
        if (null != userList && userList.size() > 0) {
            User user = userList.get(0);
            if (user.getPassword().equals(MD5.convertToMD5(password))) {
                // 保存用户登录 信息
                Map<String, Object> map = new HashMap<String, Object>();
                map = setUserCach(user);
                logger.info("调用用户登录接口结束!");
                returnJson(Results.success(map));
                return;

            } else {
                logger.info("调用用户登录接口结束!");
                returnJson(Results.failure(Errors._300106));
                return;
            }
        } else {
            logger.info("调用用户登录接口结束!");
            returnJson(Results.failure(Errors._300105, "用户"));
            return;
        }

    }
    // 用户登录信息缓存设置
    private Map<String, Object> setUserCach(User user) {
        // 保存用户登录 信息
        Map<String, Object> map = new HashMap<String, Object>();
        String userId = user.getUserId().toString();
        String userIdNew = userId + "-2";
        String token = "";
        try {
            token = Aes.Encrypt(userIdNew + System.currentTimeMillis());
        } catch (Exception e) {
            logger.info("调用用户登录接口结束!");
            e.printStackTrace();
            returnJson(Results.failure(Errors._100101, "出现异常"));
        }
        String string = SystemCache.USER_MAP.get(userIdNew);
        if (null != string && !"".equals(string)) {
            SystemCache.USER_TOKEN_MAP.remove(string);
        }
        SystemCache.USER_MAP.put(userIdNew, token);
        SystemCache.USER_TOKEN_MAP.put(token, userId);
        map.put("token", token);
        map.put("user", user);
        return map;
    }

    @GetMapping(value = "/delete")
    public Result deleteUser(Integer id){
        int num=userService.deleteUser(id);
        if (num==1){
            return ResultUtil.success(1,"删除用户成功");
        }
        return ResultUtil.success(0,"删除用户失败");
    }

    @ResponseBody
    @RequestMapping(value="getHello")
    public String getHello(){
        return "hello";
    }
}
