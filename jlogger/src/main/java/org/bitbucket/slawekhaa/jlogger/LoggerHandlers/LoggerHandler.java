package org.bitbucket.slawekhaa.jlogger.LoggerHandlers;

import org.bitbucket.slawekhaa.jlogger.classes.LoggerDetails;
import org.bitbucket.slawekhaa.jlogger.tagInterfaces.LoggableRequest;
import org.bitbucket.slawekhaa.jlogger.tagInterfaces.LoggableResponse;

@SuppressWarnings("unused")
public interface LoggerHandler {
    void init();
    void end();
    <S extends LoggableRequest> void logRequest(S request, LoggerDetails loggerDetails);
    <T extends LoggableResponse> void logResponse(T response, LoggerDetails loggerDetails);
}
