package com.github.hadasbro.jlogger.testClasses;

import com.github.hadasbro.jlogger.Logger;

@SuppressWarnings("unused")
public
class TestMyController {

//    @Logger(
////            logResponseDurationTime = true,
////            logRequestTime = true,
////            includeStackTrace = true,
////            filterStackTraceToPackage = "com.github.hadasbro.jlogger",
////            logTypes = Logger.TYPE.ALL,
////            loggerHandler = TestOwnHandler.class
//
//    )

    @Logger
    public static TestResponse create(TestUserDto user) {
        return new TestResponse(1, "OK");
    }

    @Logger
    public TestResponse create2(TestUserDto user) {
        return new TestResponse(1, "OK");
    }
}