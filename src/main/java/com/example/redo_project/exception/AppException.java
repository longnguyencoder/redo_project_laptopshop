package com.example.redo_project.exception;

public class AppException extends RuntimeException {
    private ErrorCode errorcode;

    public AppException(ErrorCode errorcode) {
        super(errorcode.getMessage());
        this.errorcode = errorcode;
    }

    public ErrorCode getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(ErrorCode errorcode) {
        this.errorcode = errorcode;
    }

}
