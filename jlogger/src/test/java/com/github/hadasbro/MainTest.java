package com.github.hadasbro;

import com.github.hadasbro.classes.MyController;
import com.github.hadasbro.classes.Response;
import com.github.hadasbro.classes.UserDto;
import org.junit.Test;

import static java.lang.System.out;

public class MainTest {

    @Test
    public void main() {

        out.println("Test start 2...");

        UserDto user = new UserDto(1, "Test user");

        Response res = MyController.create(user);

        MyController contr = new MyController();
        Response res2 = contr.create2(user);


        out.println("Test end...");

        out.println(res);

    }
}