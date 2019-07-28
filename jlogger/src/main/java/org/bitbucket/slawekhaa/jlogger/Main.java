package org.bitbucket.slawekhaa.jlogger;

import org.apache.commons.lang3.StringUtils;
import org.bitbucket.slawekhaa.jlogger.LoggerHandlers.LoggerHandler;
import org.bitbucket.slawekhaa.jlogger.classes.LoggerDetails;
import org.bitbucket.slawekhaa.jlogger.tagInterfaces.LoggableRequest;
import org.bitbucket.slawekhaa.jlogger.tagInterfaces.LoggableResponse;

import static java.lang.System.out;

@SuppressWarnings("unused")
public class Main {
    public static void main(String[] args) {

        out.println("Test start 2...");

        UserDto user = new UserDto(1, "Test user");

        Response res = MyController.create(user);

        out.println("Test end...");

        out.println(res);

    }
}



/*
    ----------- some test classes ----------
 */
class MyOwnhandler implements LoggerHandler {

    private static String JOIN_SEPARATOR = " | ";

    private StringBuilder logResult = new StringBuilder();

    @Override
    public void init() {
        out.println("init");
    }

    @Override
    public void end() {
        out.println("end");
        out.println(StringUtils.strip(logResult.toString(), JOIN_SEPARATOR));
    }

    @Override
    public void logRequest(LoggableRequest request, LoggerDetails loggerDetails) {
        logResult.append(" request: ").append(request).append(JOIN_SEPARATOR);
    }

    @Override
    public void logResponse(LoggableResponse response, LoggerDetails loggerDetails) {

        logResult.append(" response: ").append(response).append(JOIN_SEPARATOR);

        if(!loggerDetails.getStackTrace().equals("")) {
            logResult.append(" trace: ").append(loggerDetails.getStackTrace());
        }
    }
}

class UserDto {

    public Integer id;
    public String name;

    public UserDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString(){
        return "id: " + id + ", name" + name;
    }
}

class Response {

    public Integer status;
    public String message;

    Response(Integer status, String message) {
        this.status  = status;
        this.message  = message;
    }
    public String toString(){
        return "status:" + status + ", message: " + message;
    }
}


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

}