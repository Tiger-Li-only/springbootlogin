package com.example.demo.services.Impl;/**
 * Created by Administrator on 2017-10-30 0030.
 */

import com.example.demo.entity.Users;
import com.example.demo.mapper.UserMapper;
import com.example.demo.services.IUserService;
import com.example.demo.utils.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author
 * @create 2017-10-30 14:05
 **/
@Component
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public Users getUserByName(Users users) {
        Users user= userMapper.getUserByName(users);
        return user;
    }

    @Override
    public String userLogin(Users users) {
        Users user = userMapper.getUserByName(users);
        if (user == null){
            return ResultEnum.USER_LOGIN_ERROR_NO_USER.getCode();
        }else if (user.getPassword().equals(users.getPassword())){
            return ResultEnum.RESULT_SUCCESS.getCode();
        }else{
            return ResultEnum.USER_LOGIN_ERROR_PASSWORD.getCode();
        }
    }

    @Override
    public List<Users> getAllUsers() {
        List userList = userMapper.getAllUsers();
        return userList;
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    @Override
    public int addUser(Users users) {
        userMapper.addUser(users);
        return 1;
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    @Override
    public String updateUser(Users users) {
        userMapper.updateUser(users);
        return "ok";
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    @Override
    public int deleteUser(int id) {
        userMapper.deleteUser(id);
        return 1;
    }
}
