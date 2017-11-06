package com.example.demo.controller;
/**
 * Created by Administrator on 2017-10-30 0030.
 */

import com.example.demo.entity.AjaxResponseBody;
import com.example.demo.entity.Users;
import com.example.demo.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

/**
 * @author
 * @create 2017-10-30 14:09
 **/
@Controller
@SpringBootApplication
@RequestMapping("/user")
public class UsersController {
    @Autowired
    public IUserService userService;

    @RequestMapping("/findUserByUsername")
    @ResponseBody
    public ResponseEntity findUserByUsername( Users users){
        Users user = userService.getUserByName(users);
        AjaxResponseBody result = new AjaxResponseBody();
        if (user == null) {
            result.setMsg("ok");
        } else {
            result.setMsg("found");
        }
        return ResponseEntity.ok(result);
    }



    @RequestMapping("/getAllUsers")
    @ResponseBody
    public List getAllUsers(ModelMap modelMap) {
        List userList = userService.getAllUsers();
        modelMap.put("userList", userList);
        return userList;
    }
    @RequestMapping("/add")
    public String addUser(Users user){
        userService.addUser(user);
       return "/login";
    }

    @RequestMapping("/update")
    @ResponseBody
    public String updateUser(@RequestParam int id){
        Users users = new Users();
        users.setId(id);
        users.setUsername("李思");
        users.setPassword("1222");
        users.setAge(44);
        userService.updateUser(users);
        return "修改成功!";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String deleteUser(@RequestParam int id){
        userService.deleteUser(id);
        return "删除成功!";
    }

}
