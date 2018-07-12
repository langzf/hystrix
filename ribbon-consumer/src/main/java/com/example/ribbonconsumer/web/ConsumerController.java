package com.example.ribbonconsumer.web;

import com.example.ribbonconsumer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author langzf
 * @Date 2018/7/12 14:46
 * className：
 * description：
 */
@RestController
public class ConsumerController {

   /*@Autowired
    RestTemplate restTemplate;

    @GetMapping("/ribbon-consumer")
    public String consumer(){
       return restTemplate.getForEntity("http://eureka-client/hello",String.class).getBody();
    }*/

    @Autowired
    HelloService helloService;

    @RequestMapping(value="/ribbon-consumer",method = RequestMethod.GET)
    public String helloConsumer(){
        return  helloService.helloService();
    }
}
