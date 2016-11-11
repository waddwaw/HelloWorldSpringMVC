package com.waddwaw.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by arvin on 2016/11/10.
 */
@Controller
public class Hello {

    @Autowired
    StudentsMapper studentsMapper;

    @RequestMapping("/hello")
    public String printWelcome(String name,ModelMap model) {

        if(StringUtils.isEmpty(name)) {
            name = "";
        }
        StudentsEntity studentsEntity = studentsMapper.findByName(name).get(0);
        model.addAttribute("message",studentsEntity.getName());

        return "/hello.ftl";
    }
}
