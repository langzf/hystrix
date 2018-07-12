package com.example.eurekaclient.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @Author langzf
 * @Date 2018/7/12 14:43
 * className：
 * description：
 */
@RestController
public class ClientController {

    @GetMapping("/hello")
    public String hello() throws InterruptedException {
        //让处理线程等待几秒钟
        int sleepTime = new Random().nextInt(3000);
        System.out.println("线程休眠："+ sleepTime +"ms");
        Thread.sleep(sleepTime);
        System.out.println("hello!this is clientController");
        return "hello!this is clientController";
    }

}
