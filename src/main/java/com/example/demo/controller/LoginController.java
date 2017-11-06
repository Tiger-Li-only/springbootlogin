package com.example.demo.controller;/**
 * Created by Administrator on 2017-11-03 0003.
 */

import com.example.demo.entity.Users;
import com.example.demo.services.IUserService;
import com.example.demo.utils.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;
import java.io.IOException;

/**
 * @author
 * @create 2017-11-03 15:13
 **/
@Controller
@SpringBootApplication
@RequestMapping("/")
public class LoginController {
@Autowired
public IUserService userService;
    /**
     * 登录页面
     * @return
     */
    @RequestMapping("/login")
    public String toLogin(){
        return "/publicPages/login";
    }

    /**
     * 注册页面
     * @return
     */
    @RequestMapping("/toRegister")
    public String toRegister(){

        return "/publicPages/register";
    }

    /**
     * 点击登录
     * @return
     */
    @RequestMapping("/userLogin")
    public String userLogin(Users users, ModelMap modelMap , HttpServletResponse response, HttpServletRequest request) throws IOException{
       String resultCode = userService.userLogin(users);
       if ("0".equals(resultCode)){
           request.getSession().setAttribute("username", users.getUsername());
           return "redirect:/home/toHome";
       }else{
           modelMap.addAttribute("resultMsg", ResultEnum.getByCode(resultCode).getMsg());
           if ("1001".equals(resultCode)){
               modelMap.addAttribute("username", users.getUsername());
           }
           return "/publicPages/login";
       }

    }


}
