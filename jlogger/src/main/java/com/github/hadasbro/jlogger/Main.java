package com.github.hadasbro.jlogger;

import com.github.hadasbro.jlogger.testClasses.TestMyController;
import com.github.hadasbro.jlogger.testClasses.TestResponse;
import com.github.hadasbro.jlogger.testClasses.TestUserDto;

import static java.lang.System.out;

@SuppressWarnings("unused")
public class Main {
    public static void main(String[] args) {
        out.println("Test start 2...");

        TestUserDto user = new TestUserDto(1, "Test user");

        TestResponse res = TestMyController.create(user);

        TestMyController contr = new TestMyController();
        TestResponse res2 = contr.create2(user);


        out.println("Test end...");

        out.println(res);
    }
}


