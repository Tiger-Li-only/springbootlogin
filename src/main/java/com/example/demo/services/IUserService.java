package com.example.demo.services;
import com.example.demo.entity.Users;

import java.util.List;

/**
 * Created by Administrator on 2017-10-30 0030.
 */
public interface IUserService {
    public Users getUserByName(Users users);

    public String userLogin(Users users);

    public List<Users> getAllUsers();

    public int addUser(Users users);

    public String updateUser(Users users);

    public int deleteUser(int id);
}
