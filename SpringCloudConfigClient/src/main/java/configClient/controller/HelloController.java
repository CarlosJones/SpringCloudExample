package configClient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by CarloJones on 2018/8/28.
 */
@RestController
public class HelloController {
    //相当于引用了properties文件中的 dev配置
    //如果没有获取到dev 的值，就会默认读取 :后面的值，相当于一个默认值了
    @Value("${spring.cloud.config.profile}")
    String dev;

    @RequestMapping("/dev")
    public String dev() {
        return this.dev;
    }
}
