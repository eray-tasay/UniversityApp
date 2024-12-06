package com.eraytasay.university.data.exception.department;

public class NoSuchCourseException extends RuntimeException {
    public NoSuchCourseException(String message)
    {
        super(message);
    }

    public NoSuchCourseException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
