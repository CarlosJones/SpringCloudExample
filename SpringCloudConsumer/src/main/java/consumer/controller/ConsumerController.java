package consumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import consumer.remote.HelloRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    private HelloRemote HelloRemote;
	
    @RequestMapping("/hello")
    @HystrixCommand(fallbackMethod = "helloError")
    public String index(String name) {
        return HelloRemote.hello(name)+" :feign";
    }
}