package com.pop.constants;

import java.util.logging.Level;

public class Message {

	public String errorAlphanumericNumericCode;

	public String errorMesssage;

	public Level errorType;

	public String originatorClass;

	public Message(String errorAlphanumericNumericCode, String errorMesssage, String originatorClass) {
		this(errorAlphanumericNumericCode, errorMesssage, originatorClass, Level.INFO);
	}

	public Message(String errorAlphanumericNumericCode, String errorMesssage, String originatorClass, Level errorType) {
		super();
		this.errorAlphanumericNumericCode = errorAlphanumericNumericCode;
		this.errorMesssage = errorMesssage;
		this.originatorClass = originatorClass;
		this.errorType = errorType;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Message [errorAlphanumericNumericCode=").append(errorAlphanumericNumericCode)
				.append(", errorMesssage=").append(errorMesssage).append(", errorType=").append(errorType)
				.append(", originatorClass=").append(originatorClass).append("]");
		return builder.toString();
	}

}
