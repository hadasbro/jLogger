package com.github.hadasbro.jlogger.testClasses;

import com.github.hadasbro.jlogger.Logger;
import com.github.hadasbro.jlogger.tagInterfaces.LoggableRequest;

@SuppressWarnings("unused")
public
class TestUserDto implements LoggableRequest {

    private Integer id;
    private String name;
    public String name222 = "name222 xx";

    @Logger
    public TestUserDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString(){
        return "id: " + id + ", name" + name;
    }
}