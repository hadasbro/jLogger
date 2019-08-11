package com.github.hadasbro.jlogger.loggerHandlers;

import com.github.hadasbro.jlogger.classes.LoggerDetails;
import com.github.hadasbro.jlogger.classes.Utils;
import com.github.hadasbro.jlogger.tagInterfaces.LoggableRequest;
import com.github.hadasbro.jlogger.tagInterfaces.LoggableResponse;

import java.util.logging.Logger;

/**
 * DefaultLogger
 *
 * This is another logger example, this logger compose request, response
 * log into one final String value and then save this value to log
 */
@SuppressWarnings("unused")
public class DefaultLogger implements LoggerHandler {

    private static final Logger LOGGER = Logger.getLogger(DefaultLogger.class.getName());

    private static String JOIN_SEPARATOR = " | ";

    private StringBuilder logResult = new StringBuilder();

    @Override
    public void init() {
    }

    @Override
    public void end() {
        LOGGER.info(Utils.trim(logResult.toString(), JOIN_SEPARATOR));
    }

    @Override
    public void logRequest(LoggableRequest request, LoggerDetails loggerDetails) {

        if(loggerDetails.getRequestTime() != null) {
            logResult.append(loggerDetails.getRequestTime().toString());
        }

        logResult.append(" request: ").append(request).append(JOIN_SEPARATOR);
    }

    @Override
    public void logResponse(LoggableResponse response, LoggerDetails loggerDetails) {

        logResult.append(" response: ").append(response).append(" | ");

        if(loggerDetails.getDuration() != 0) {
            logResult.append(" duration: ").append(loggerDetails.getDuration()).append("ms").append(JOIN_SEPARATOR);
        }

        if(!loggerDetails.getStackTrace().equals("")) {
            logResult.append(" trace: ").append(loggerDetails.getStackTrace());
        }

    }

}
