package com.eraytasay.university.data.exception.department;

public class NoSuchDepartmentException extends RuntimeException {
    public NoSuchDepartmentException(String message)
    {
        super(message);
    }

    public NoSuchDepartmentException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
