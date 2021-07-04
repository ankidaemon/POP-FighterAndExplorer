package com.pop.logger;

import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class LoggingFormatter extends Formatter {
	private static final String FILLER = "::";

	@Override
	public String format(LogRecord record) {
		return new StringBuilder()
				.append(record.getThreadID()).append( FILLER )
				.append(record.getSourceClassName()).append(FILLER)
				.append(record.getSourceMethodName()).append(FILLER)
				.append(new Date(record.getMillis())).append( FILLER )
				.append(record.getMessage()).toString();
	}
}