package com.github.hadasbro.jlogger.testClasses;

import com.github.hadasbro.jlogger.tagInterfaces.LoggableResponse;

@SuppressWarnings({"unused", "weakerAccess"})
public
class TestResponse implements LoggableResponse {

    private Integer status;
    private String message;

    TestResponse(Integer status, String message) {
        this.status  = status;
        this.message  = message;
    }
    public String toString(){
        return "status:" + status + ", message: " + message;
    }
}