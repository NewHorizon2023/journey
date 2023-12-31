package ie.nci.journey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * IndexController
 *
 * @Author: Xiangnan Liu
 * @CreateTime: 2023-12-29
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/booking")
    public String booking() {
        return "page/booking";
    }

    @GetMapping("/qa")
    public String qa(){
        return "page/qa";
    }
}
