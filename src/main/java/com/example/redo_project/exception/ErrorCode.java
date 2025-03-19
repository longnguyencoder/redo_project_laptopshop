package com.example.redo_project.exception;

public enum ErrorCode {
    AUTHENTICARIZE(9999, "authenticarize_error"),

    USER_EXISTS(1001, "user existed"),
    USERNAME_INVALID(1002, "username phải có ừ 2 kí tự"),
    PASSWORD_INVALID(1003, "password phải có tối thiểu 8 kí tự"),
    INVALID_KEY(1004, "Invalid message Key"),
    USER_NOT_EXITS(1005, "Invalid message Key"),
    UNAUTHENTICATED(1006, "UNAUTHENTICATED"),;

    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
