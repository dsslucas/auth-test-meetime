package com.example.api.exceptions;

import lombok.Getter;

@Getter
public class ForbiddenException extends RuntimeException {
	private Object reason;
	
	public ForbiddenException (String message) {
		 super(message);
	}
	
    public ForbiddenException (String message, Object reason) {
        super(message);
        this.reason = reason;
    }
}
