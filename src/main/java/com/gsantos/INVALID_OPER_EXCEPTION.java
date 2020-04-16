package com.gsantos;

public class INVALID_OPER_EXCEPTION extends Exception{
    private static final long serialVersionUID = 1149241039409861914L;

    public INVALID_OPER_EXCEPTION(String msg){
        super(msg);
    }

    public INVALID_OPER_EXCEPTION(String msg, Throwable cause){
        super(msg, cause);
    }
}
