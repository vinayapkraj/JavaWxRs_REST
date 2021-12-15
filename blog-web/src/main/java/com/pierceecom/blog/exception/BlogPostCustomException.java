package com.pierceecom.blog.exception;

public class BlogPostCustomException extends RuntimeException {
    /**
     * TODO Use these Custom Exceptions to throw Known Errors
     */
    private static final long serialVersionUID = 1L;

    public BlogPostCustomException() {
        super();
    }

    public BlogPostCustomException(String message) {
        super(message);
    }

    public BlogPostCustomException(String message, Throwable cause) {
        super(message, cause);
    }

}