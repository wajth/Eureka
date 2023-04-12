package com.example.consumer_server_12000.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.example.consumer_server_12000.po.CommonResult;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/getUserById/{userId}")
    public CommonResult getUserById(@PathVariable("userId") Integer userId){

        //通过服务提供者名（provider-server）获取Eureka Server上的元数据
        List<ServiceInstance> instanceList =
                discoveryClient.getInstances("provider-server");
        //现在，元数据集合中只有一个服务信息
        ServiceInstance instance = instanceList.get(0);

        //使用DiscoveryClient获取元数据，主机地址与端口就可以不硬编码了
        CommonResult result = restTemplate.getForObject("http://"+instance.getHost()+":"+
                instance.getPort()+"/user/getUserById/"+userId, CommonResult.class);
        return result;
    }
}