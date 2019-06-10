package com.forezp.web;

import com.netflix.discovery.DiscoveryManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by forezp on 2017/6/9.
 */
@RestController
public class HiController {

    @Value("${server.port}")
    String port;

    @GetMapping("/hi")
    public String home(@RequestParam String name) {
        System.out.println(port);
        return "hi "+name+",i am from port:" +port;
    }

    @GetMapping("/st")//服务下线
    public void st(@RequestParam(name="aa") String st){
        System.out.println("st="+st);
        DiscoveryManager.getInstance().shutdownComponent();
    }

}
