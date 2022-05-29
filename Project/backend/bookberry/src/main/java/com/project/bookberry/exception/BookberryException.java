package com.project.bookberry.exception;

public class BookberryException extends RuntimeException{
    public BookberryException() {
        super();
    }

    public BookberryException(String message) {
        super(message);
    }
}
