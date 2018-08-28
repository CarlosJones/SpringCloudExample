package configClient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by CarloJones on 2018/8/28.
 */
@RestController
@RefreshScope
public class HelloController {
    @Value("${neo-config}")
    String dev;

    @RequestMapping("/dev")
    public String dev() {
        return this.dev;
    }
}
