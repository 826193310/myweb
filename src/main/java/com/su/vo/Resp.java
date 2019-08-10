package com.su.vo;

import java.util.List;

public class Resp<T> {
    private T obj;
    private List<T> list;

    private int errorCode = 0;
    private String msg = "success";

    public Resp(){}

    public Resp( T t) {
        this.obj = t;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
