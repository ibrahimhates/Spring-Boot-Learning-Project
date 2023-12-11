package com.demolesson.learning.exception;

public class ErrorResponse {
    private String errorMessage;
    private int statusCode;
    private long timeStamp;

    public ErrorResponse(){ }

    public ErrorResponse(String errorMessage, int statusCode, long timeStamp) {
        this.errorMessage = errorMessage;
        this.statusCode = statusCode;
        this.timeStamp = timeStamp;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
