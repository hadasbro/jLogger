package com.github.hadasbro.classes;

import com.github.hadasbro.LoggerHandlers.LoggerHandler;
import com.github.hadasbro.tagInterfaces.LoggableRequest;
import com.github.hadasbro.tagInterfaces.LoggableResponse;

import static java.lang.System.out;

@SuppressWarnings("unused")
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