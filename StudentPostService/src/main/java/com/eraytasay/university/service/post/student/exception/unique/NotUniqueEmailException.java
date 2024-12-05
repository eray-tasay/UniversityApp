package com.eraytasay.university.service.post.student.exception.unique;

public class NotUniqueEmailException extends RuntimeException {
    public NotUniqueEmailException(String message)
    {
        super(message);
    }

    public NotUniqueEmailException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
