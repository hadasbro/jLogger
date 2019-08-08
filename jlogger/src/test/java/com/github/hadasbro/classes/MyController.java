package com.github.hadasbro.classes;

import com.github.hadasbro.Logger;

@SuppressWarnings("unused")
public
class MyController {

//    @Logger(
////            logResponseDurationTime = true,
////            logRequestTime = true,
////            includeStackTrace = true,
////            filterStackTraceToPackage = "org.bitbucket.slawekhaa",
////            logTypes = Logger.TYPE.ALL,
////            loggerHandler = MyOwnhandler.class
//
//    )

    @Logger
    public static Response create(UserDto user) {
        return new Response(1, "OK");
    }

    @Logger
    public Response create2(UserDto user) {
        return new Response(1, "OK");
    }
}