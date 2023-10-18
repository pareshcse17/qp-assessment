package com.example.demo.exception;

import java.io.IOException;

public class CustomException extends Exception {

    private int errorCode;
    private String errorMessage;

    public CustomException(int errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public CustomException(int errorCode, String errorMessage, Throwable cause) {
        super(errorMessage, cause);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public CustomException(String errorString) {
        super(errorString);
        String[] parts = errorString.split(":");
        if (parts.length == 2) {
            try {
                this.errorCode = Integer.parseInt(parts[0].trim());
                this.errorMessage = parts[1].trim();
            } catch (NumberFormatException e) {
                this.errorCode = 0; // Default code for invalid format
                this.errorMessage = errorString;
            }
        } else {
            this.errorCode = 0; // Default code for invalid format
            this.errorMessage = errorString;
        }
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}

