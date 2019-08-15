package com.github.hadasbro.jlogger;

import com.github.hadasbro.jlogger.testClasses.TestMyController;
import com.github.hadasbro.jlogger.testClasses.TestOwnHandler;
import com.github.hadasbro.jlogger.testClasses.TestResponse;
import com.github.hadasbro.jlogger.testClasses.TestUserDto;

@SuppressWarnings("unused")
public class Main {
    public static void main(String[] args) {

        TestUserDto user = new TestUserDto(1, "Test user");

        TestResponse res = TestMyController.create(user);

        System.out.println(TestOwnHandler.ACUMULATED_LOG);
    }
}


