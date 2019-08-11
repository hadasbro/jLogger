package com.github.hadasbro.jlogger.LoggerHandlers;

import com.github.hadasbro.jlogger.classes.LoggerDetails;
import com.github.hadasbro.jlogger.tagInterfaces.LoggableRequest;
import com.github.hadasbro.jlogger.tagInterfaces.LoggableResponse;

@SuppressWarnings("unused")
public interface LoggerHandler {
    void init();
    void end();
    <S extends LoggableRequest> void logRequest(S request, LoggerDetails loggerDetails);
    <T extends LoggableResponse> void logResponse(T response, LoggerDetails loggerDetails);
}
