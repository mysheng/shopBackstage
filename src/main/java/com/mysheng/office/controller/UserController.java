package com.mysheng.office.controller;

import com.mysheng.office.model.Result;
import com.mysheng.office.model.User;
import com.mysheng.office.service.UserService;
import com.mysheng.office.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/user")
public class UserController {
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
    @GetMapping(value = "/byId")
    public Result findById(@RequestParam("id") Integer id){
        User user=userService.queryUserById(id);
        if(user!=null){
            return ResultUtil.success(1,"查询成功",user);
        }else{
            return ResultUtil.success(0,"没找到对应的用户");
        }

    }
    @PostMapping(value = "/addUser")
    public Result addUser(@RequestBody User user){
        int num=userService.insertUser(user);
        if(num>0){
            return ResultUtil.success(1,"注册成功");
        }
       return ResultUtil.success(0,"注册失败");
    }
    @PostMapping(value = "/update")
    public Result updateUser(@RequestBody User user){
        int num=userService.updateUser(user);
        if(num>0){
            return ResultUtil.success(1,"修改用户信息成功");
        }
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
    @PostMapping(value = "/loginInfo")
    public Result loginInfo(@RequestBody Map<String,Object> params){
        String phone = params.get("phone").toString();
        String password = params.get("userPassword").toString();
        int num=userService.loginInfo(phone,password);
        if (num==1){
            return ResultUtil.success(1,"登陆成功");
        }
        return ResultUtil.success(0,"密码或手机号不正确");
    }
    @GetMapping(value = "/delete")
    public Result deleteUser(Integer id){
        int num=userService.deleteUser(id);
        if (num==1){
            return ResultUtil.success(1,"删除用户成功");
        }
        return ResultUtil.success(0,"删除用户失败");
    }
}
