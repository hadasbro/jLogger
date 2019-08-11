package com.github.hadasbro.jlogger.classes;

import com.github.hadasbro.jlogger.tagInterfaces.LoggableRequest;

@SuppressWarnings("unused")
public
class UserDto implements LoggableRequest {

    private Integer id;
    private String name;
    public String name222 = "name222 xx";

    public UserDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString(){
        return "id: " + id + ", name" + name;
    }
}