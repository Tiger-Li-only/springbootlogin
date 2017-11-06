package com.example.demo.mapper;

import java.util.List;
import com.example.demo.entity.Users;
import org.apache.ibatis.annotations.*;


/**
 * @author tiger
 */
@Mapper
public interface UserMapper {

    @Select(value = { "select * from users where username = #{username}" })
    public Users getUserByName(Users users);

    @Select(value = { "select * from users" })
    @Results({ @Result(column = "username", property = "username"), @Result(column = "password", property = "password"), @Result(column = "age", property = "age")})
    public List<Users> getAllUsers();

    @Insert(value = "insert into users(username,password,age) values(#{username},#{password},#{age})")
    public int addUser(Users users);

    @Update(value = "update users set username = #{username},password = #{password}, age = #{age} where id = #{id}")
    public int updateUser(Users users);

    @Delete(value = "delete from users where id = #{id}")
    public int deleteUser(int id);
}