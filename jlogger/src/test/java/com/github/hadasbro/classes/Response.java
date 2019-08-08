package com.github.hadasbro.classes;

import com.github.hadasbro.tagInterfaces.LoggableResponse;

@SuppressWarnings({"unused", "weakerAccess"})
public
class Response implements LoggableResponse {

    private Integer status;
    private String message;

    Response(Integer status, String message) {
        this.status  = status;
        this.message  = message;
    }
    public String toString(){
        return "status:" + status + ", message: " + message;
    }
}