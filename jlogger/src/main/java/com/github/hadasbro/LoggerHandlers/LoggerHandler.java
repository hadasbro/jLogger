package com.github.hadasbro.LoggerHandlers;

import com.github.hadasbro.classes.LoggerDetails;
import com.github.hadasbro.tagInterfaces.LoggableRequest;
import com.github.hadasbro.tagInterfaces.LoggableResponse;

@SuppressWarnings("unused")
public interface LoggerHandler {
    void init();
    void end();
    <S extends LoggableRequest> void logRequest(S request, LoggerDetails loggerDetails);
    <T extends LoggableResponse> void logResponse(T response, LoggerDetails loggerDetails);
}
