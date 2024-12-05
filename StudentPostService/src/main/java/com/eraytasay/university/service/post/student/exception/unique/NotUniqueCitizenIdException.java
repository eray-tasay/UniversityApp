package com.eraytasay.university.service.post.student.exception.unique;

public class NotUniqueCitizenIdException extends RuntimeException {
    public NotUniqueCitizenIdException(String message)
    {
        super(message);
    }

    public NotUniqueCitizenIdException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
