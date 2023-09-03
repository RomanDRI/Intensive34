package ru.aston.druzhinin_ri.task2.exception;


public class CustomException extends Exception{
    private String message;
    private int code;
    public CustomException(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return "Exception code: " + code + " \nException message: " + message;
    }
}
