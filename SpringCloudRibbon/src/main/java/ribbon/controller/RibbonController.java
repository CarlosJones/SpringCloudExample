package ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RibbonController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name){
        String result=restTemplate.getForObject("http://SPRINGCLOUDPRODUCER/hello?name="+name,String.class);
        return result;
    }
}