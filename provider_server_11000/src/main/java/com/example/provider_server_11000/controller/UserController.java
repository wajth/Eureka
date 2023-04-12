package com.example.provider_server_11000.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.provider_server_11000.po.CommonResult;
import com.example.provider_server_11000.po.User;

@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("/getUserById/{userId}")
    public CommonResult<User> getUserById(@PathVariable("userId") Integer userId){
        //模拟返回业务数据
        return new CommonResult(200,"success",new User(userId,"张三","123"));
    }
}
