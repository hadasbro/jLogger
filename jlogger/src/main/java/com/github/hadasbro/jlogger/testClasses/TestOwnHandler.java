package com.github.hadasbro.jlogger.testClasses;

import com.github.hadasbro.jlogger.classes.LoggerDetails;
import com.github.hadasbro.jlogger.loggerHandlers.LoggerHandler;
import com.github.hadasbro.jlogger.tagInterfaces.LoggableRequest;
import com.github.hadasbro.jlogger.tagInterfaces.LoggableResponse;

@SuppressWarnings("unused")
public class TestOwnHandler implements LoggerHandler {

    private static String JOIN_SEPARATOR = " | ";
    public static String ACUMULATED_LOG = "";

    public StringBuilder getLogResult() {
        return logResult;
    }

    private StringBuilder logResult = new StringBuilder();

    @Override
    public void init() {
        ACUMULATED_LOG = "";
        logResult.append("<init>");
    }

    @Override
    public void end() {
        logResult.append("<end>");
        ACUMULATED_LOG = logResult.toString();
    }

    @Override
    public void logRequest(LoggableRequest request, LoggerDetails loggerDetails) {
        logResult
                .append(" request: ")
                .append(request)
                .append(JOIN_SEPARATOR);
    }

    @Override
    public void logResponse(LoggableResponse response, LoggerDetails loggerDetails) {
        logResult
                .append(" response: ")
                .append(response)
                .append(JOIN_SEPARATOR);
    }
}