package com.example.ribbonconsumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Author langzf
 * @Date 2018/7/12 15:16
 * className：
 * description：
 */
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFallback")
    public String helloService(){
        long start = System.currentTimeMillis();
        String result = restTemplate.getForEntity("http://eureka-client/hello",String.class).getBody();
        long end = System.currentTimeMillis();
        System.out.println("Spend time =" + (end-start)+"ms");
        return result;
    }

    public String helloFallback(){
        return "error";
    }

}
