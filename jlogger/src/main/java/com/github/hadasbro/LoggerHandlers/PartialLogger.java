package com.github.hadasbro.LoggerHandlers;

import com.github.hadasbro.classes.LoggerDetails;
import com.github.hadasbro.tagInterfaces.LoggableRequest;
import com.github.hadasbro.tagInterfaces.LoggableResponse;

import java.util.logging.Logger;

/**
 * PartialLogger
 */
@SuppressWarnings("unused")
public class PartialLogger implements LoggerHandler {

    private static final Logger LOGGER = Logger.getLogger(PartialLogger.class.getName());

    @Override
    public void init() {}

    @Override
    public void end() {}

    @Override
    public void logRequest(LoggableRequest request, LoggerDetails loggerDetails) {
        LOGGER.info("request: " + request.toString() + " | " + loggerDetails);
    }

    @Override
    public void logResponse(LoggableResponse response, LoggerDetails loggerDetails) {
        LOGGER.info("response: " + response.toString() + " | " + loggerDetails);
    }

}
