package com.squid.rocketmq.controller;

import com.squid.rocketmq.service.ProducerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value = "/mq")
public class MqController {


    @Autowired
    private ProducerServiceImpl producer;



    @RequestMapping(value = "/push",method = RequestMethod.GET)
    @ResponseBody
    public String test(){

        producer.send("TopicTest", "push", "测试消息");

        return "MqController ok!";
    }
}