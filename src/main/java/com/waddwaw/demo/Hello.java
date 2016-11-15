package com.waddwaw.demo;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.waddwaw.demo.shiro.dao.UserMapper;
import com.waddwaw.demo.shiro.model.User;
import com.waddwaw.demo.shiro.security.PermissionSign;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by arvin on 2016/11/10.
 */
@Controller
public class Hello {

    @Autowired
    StudentsMapper studentsMapper;

    @Autowired
    UserMapper userMapper;

    @RequestMapping("/hello")  //127.0.0.1:8080/hello?peage=1
    public String printWelcome(String name,Integer peage,ModelMap model) {

        if(StringUtils.isEmpty(name)) {
            name = "admin";
        }
        if(StringUtils.isEmpty(peage)) {
            peage = 1;
        }
        PageHelper.startPage(1, peage);
        List<User> users = userMapper.byListUserName(name);
        long total  = ((Page) users).getTotal();
        Subject subject = SecurityUtils.getSubject();
        model.addAttribute("message", "hello world " + total + "--" + users.size() + "==" + ((User)subject.getPrincipal()).getUsername());

        return "/hello.ftl";
    }

    @RequestMapping(value = "/loginPost", method= RequestMethod.POST)
    public String loginPost(User user) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),user.getPassword());
        token.setRememberMe(true);
        try {
            subject.login(token);
            SecurityUtils.getSubject().getSession().setTimeout(1000 * 10);
            return "redirect:/hello2";
        }catch (AuthenticationException e) {
            token.clear();
            return "redirect:/login";
        }

    }

    @RequestMapping("/login")
    public String login() {

        return "/login.ftl";
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
