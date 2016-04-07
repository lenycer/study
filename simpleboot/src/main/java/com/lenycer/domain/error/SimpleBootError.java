package com.lenycer.domain.error;

import lombok.Data;

@Data
public class SimpleBootError {

	private int status;
	private String reasonPhrase;
	private String errorMessage;
}
