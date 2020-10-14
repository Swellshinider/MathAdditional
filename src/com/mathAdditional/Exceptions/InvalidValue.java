package com.mathAdditional.Exceptions;

/**
 * The class {@code InvalidValue} and its subclasses are a form of
 * {@code MAExceptions} that indicates conditions that a reasonable
 * application might want to catch.
 *
 * @author Eduardo Ribeiro Leal
 * @version 1.0.0
 * @see com.mathAdditional.Exceptions
 */
public class InvalidValue extends MAExceptions{
    /**
     * Docs are the same as {@link #Exception} class.
     * Constructs a new exception with {@code null} as its detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     */
    public InvalidValue(){
        super("The value sent is invalid");
    }

    /**
     * Docs are the same as {@link #Exception} class.
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param   message   the detail message. The detail message is saved for
     *          later retrieval by the {@link #getMessage()} method.
     */
    public InvalidValue(String message){
        super(message);
    }
}
