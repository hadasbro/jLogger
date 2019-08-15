package com.github.hadasbro.jlogger.testClasses;

import com.github.hadasbro.jlogger.Logger;

@SuppressWarnings("unused")
public
class TestMyController {

    @Logger(
            logResponseDurationTime = true,
            logRequestTime = true,
            includeStackTrace = false,
            logTypes = Logger.TYPE.ALL,
            loggerHandler = TestOwnHandler.class
    )
    public static TestResponse create(TestUserDto user) {
        return new TestResponse(1, "OK");
    }

}