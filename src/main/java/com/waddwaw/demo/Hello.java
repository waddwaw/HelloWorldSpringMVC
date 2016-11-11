package com.waddwaw.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by arvin on 2016/11/10.
 */
@Controller
public class Hello {
    @RequestMapping("/hello")
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Hello world!");
        return "/hello.ftl";
    }
}
