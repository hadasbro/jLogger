package com.github.hadasbro.jlogger;

import com.github.hadasbro.jlogger.testClasses.TestMyController;
import com.github.hadasbro.jlogger.testClasses.TestResponse;
import com.github.hadasbro.jlogger.testClasses.TestUserDto;
import org.junit.Test;

public class MainTest {

    @Test
    public void main() {

        System.out.println("Test start 2...");

        TestUserDto user = new TestUserDto(1, "Test user");

        TestResponse res = TestMyController.create(user);

        TestMyController contr = new TestMyController();
        TestResponse res2 = contr.create2(user);


        System.out.println("Test end...");

        System.out.println(res);

    }
}