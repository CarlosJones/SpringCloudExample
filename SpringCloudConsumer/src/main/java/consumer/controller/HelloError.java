package consumer.controller;

import consumer.remote.HelloRemote;
import org.springframework.stereotype.Component;

@Component
public class HelloError implements HelloRemote {
    @Override
    public String hello(String name) {
        return "hello  ,"+name+"!  sorry ,error !";
    }
}
