package com.github.hadasbro.jlogger;

import com.github.hadasbro.jlogger.testClasses.TestMyController;
import com.github.hadasbro.jlogger.testClasses.TestOwnHandler;
import com.github.hadasbro.jlogger.testClasses.TestResponse;
import com.github.hadasbro.jlogger.testClasses.TestUserDto;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void main() {

        TestUserDto user = new TestUserDto(1, "Test user");

        TestResponse res = TestMyController.create(user);

        assertEquals(TestOwnHandler.ACUMULATED_LOG,
                "<init> request: id: 1, nameTest user |  " +
                        "response: status:1, message: OK | <end>"
        );

    }
}