package com.github.hadasbro.jlogger.classes;

import java.time.LocalTime;

public class LoggerDetails {

    /**
     * duration
     */
    private long duration = 0;

    /**
     * requestTime
     */
    private LocalTime requestTime = null;

    /**
     * stackTrace
     */
    private String stackTrace = "";

    /**
     * toString
     *
     * @return String
     */
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        if(requestTime != null){
            sb.append(requestTime).append(", ");
        }

        if(duration > 0){
            sb.append(" duration: ").append(duration).append(" ms, ");
        }

        if(!stackTrace.equals("")){
            sb.append(" stackTrace: ").append(stackTrace).append(", ");
        }

        return Utils.trim(sb.toString(), ", ");

    }

    /**
     * getDuration
     *
     * @return long
     */
    public long getDuration() {
        return duration;
    }

    /**
     * setDuration
     *
     * @param duration -
     */
    public void setDuration(long duration) {
        this.duration = duration;
    }

    /**
     * getRequestTime
     *
     * @return LocalTime
     */
    public LocalTime getRequestTime() {
        return requestTime;
    }

    /**
     * setRequestTime
     *
     * @param requestTime -
     */
    public void setRequestTime(LocalTime requestTime) {
        this.requestTime = requestTime;
    }

    /**
     * getStackTrace
     *
     * @return String
     */
    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }
}
