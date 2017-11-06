package com.example.demo.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@SpringBootApplication
@RequestMapping("/home")
public class HomeContrller {

    /**
     * 跳转到主页
     * @return
     */
    @RequestMapping("/toHome")
    public String toHome(HttpServletRequest request, ModelMap modelMap){
        modelMap.put("username",request.getSession().getAttribute("username"));
        return "/privatePages/home/home";
    }
}
