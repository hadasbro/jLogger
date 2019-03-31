package org.bitbucket.slawekhaa.jlogger.LoggerHandlers;

import lombok.extern.java.Log;
import org.apache.commons.lang3.StringUtils;
import org.bitbucket.slawekhaa.jlogger.classes.LoggerDetails;
import org.bitbucket.slawekhaa.jlogger.tagInterfaces.LoggableRequest;
import org.bitbucket.slawekhaa.jlogger.tagInterfaces.LoggableResponse;

/**
 * DefaultLogger
 *
 * This is another logger example, this logger compose request, response
 * log into one final String value and then save this value to log
 */
@Log
@SuppressWarnings("unused")
public class DefaultLogger implements LoggerHandler {

    private static String JOIN_SEPARATOR = " | ";

    private StringBuilder logResult = new StringBuilder();

    @Override
    public void init() {
    }

    @Override
    public void end() {
        log.info(StringUtils.strip(logResult.toString(), JOIN_SEPARATOR));
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
