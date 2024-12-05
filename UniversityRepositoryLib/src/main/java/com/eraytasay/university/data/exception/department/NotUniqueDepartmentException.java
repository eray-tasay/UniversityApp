package com.eraytasay.university.data.exception.department;

public class NotUniqueDepartmentException extends RuntimeException {
    public NotUniqueDepartmentException(String message)
    {
        super(message);
    }

    public NotUniqueDepartmentException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
