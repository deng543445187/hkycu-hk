package com.huike.ycu.mybatis.result;

import org.springframework.util.ObjectUtils;

public class Result <T>{
  //返回code
    private int code;
    //返回消息
    private  String  msg;
    //返回数据
    private  T data;
    public Result(T data){
        this.code = CodeMsg.SUCESS.getCode();
        this.msg = CodeMsg.SUCESS.getMsg();
        this.data = data;
    }
    private Result(int code ,String msg){
        this.code = code;
        this.msg = msg;
    }
    private Result(CodeMsg codeMsg){
        if(!ObjectUtils.isEmpty(codeMsg)){
            this.code = codeMsg.getCode();
            this.msg = codeMsg.getMsg();
        }

    }
    /*返回结果是否成功*/
    public boolean isSuccess(){

        return this.code == CodeMsg.SUCESS.getCode();
    }
    /*成功返回消息及数据*/
    public  static  <T> Result<T> success(T data){
        return  new Result<T>(data);

    }
    /*s失败返回消息*/
    public static <T> Result<T> error(CodeMsg codeMsg) {
        return new Result<>(codeMsg);
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
