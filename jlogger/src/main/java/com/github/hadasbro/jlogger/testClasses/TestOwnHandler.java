package com.github.hadasbro.jlogger.testClasses;

import com.github.hadasbro.jlogger.classes.LoggerDetails;
import com.github.hadasbro.jlogger.classes.Utils;
import com.github.hadasbro.jlogger.loggerHandlers.LoggerHandler;
import com.github.hadasbro.jlogger.tagInterfaces.LoggableRequest;
import com.github.hadasbro.jlogger.tagInterfaces.LoggableResponse;

import static java.lang.System.out;

@SuppressWarnings("unused")
class TestOwnHandler implements LoggerHandler {

    private static String JOIN_SEPARATOR = " | ";

    private StringBuilder logResult = new StringBuilder();

    @Override
    public void init() {
        out.println("init");
    }

    @Override
    public void end() {
        out.println("end");
        out.println(Utils.trim(logResult.toString(), JOIN_SEPARATOR));
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