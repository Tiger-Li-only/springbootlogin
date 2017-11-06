package com.example.demo.entity;

import java.util.List;

public class AjaxResponseBody {

    String msg;
    List<Users> result;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<Users> getResult() {
        return result;
    }

    public void setResult(List<Users> result) {
        this.result = result;
    }
}