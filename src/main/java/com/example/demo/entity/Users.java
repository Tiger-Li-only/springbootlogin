package com.example.demo.entity;/**
 * Created by Administrator on 2017-10-30 0030.
 */

import java.io.Serializable;

/**学生实体类
 * @author
 * @create 2017-10-30 11:43
 **/

public class Users implements Serializable

    {
        private static final long serialVersionUID = 2120869894112984147L;
        private int id;
        private String username;
        private String password;
        private int age;

        public static long getSerialVersionUID() {
            return serialVersionUID;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
