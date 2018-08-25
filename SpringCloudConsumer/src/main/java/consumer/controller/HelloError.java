package consumer.controller;

import consumer.remote.HelloRemote;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.stereotype.Component;

@Component
public class HelloError implements HelloRemote {
    @Override
    public String hello(String name) {
        return "hello  ,"+name+"!  sorry ,error !";
    }
}
