package com.online.videostreaming.classrooms.onlineclassrooms.captcha;

import com.online.videostreaming.classrooms.onlineclassrooms.captcha.exception.ErrorCode;

public class CaptchaResponse <T> {

    private int code;
    private String msg;
    private T data;

    public CaptchaResponse(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public CaptchaResponse(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
    }

    public CaptchaResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public CaptchaResponse(T data) {
        this.code = ErrorCode.SUCCESS.getCode();
        this.msg = ErrorCode.SUCCESS.getMsg();
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
