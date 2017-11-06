package com.example.demo.utils;

import org.apache.commons.lang.StringUtils;

public enum ResultEnum {
    SUCCESS("200", "成功"),
    SERVER_ERROR("500", "系统异常"),


    RESULT_SUCCESS("0", "成功"),
    RESULT_ERROR("1", "有误"),

    /*******************************用户登录错误***********************************/
    USER_LOGIN_ERROR_NO_USER("1000","用户登录失败，该用户不存在!"),
    USER_LOGIN_ERROR_PASSWORD("1001","用户登录失败，密码错误!");

    /*******************************用户登录错误***********************************/
    private ResultEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private String code;

    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getIntCode() {
        return Integer.parseInt(code);
    }
    /**
     * 根据枚举码获取枚举
     * @param code 枚举码
     * @return 枚举
     */
    public static final ResultEnum getByCode(String code) {
        if (StringUtils.isBlank(code)) {
            return null;
        }
        for (ResultEnum item : ResultEnum.values()) {
            if (StringUtils.equals(item.getCode(), code)) {
                return item;
            }
        }
        return null;
    }

}
