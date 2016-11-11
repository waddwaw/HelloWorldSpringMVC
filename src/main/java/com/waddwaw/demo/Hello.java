package com.waddwaw.demo;

import com.waddwaw.demo.shiro.security.PermissionSign;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
//        StudentsEntity studentsEntity = studentsMapper.findByName(name).get(0);
        model.addAttribute("message","hello world");

        return "/hello.ftl";
    }

    @RequiresPermissions(value = PermissionSign.USER_CREATE)
    @RequestMapping("/hello2")
    @ResponseBody
    public String printPermission(){

        return "RequiresPermissions" ;
    }


    @RequestMapping("/err401")
    @ResponseBody
    public String errTest(){

        return "401 没有权限" ;
    }
}
