package org.osanchezh.keepnotes.persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class LoggingTest {
	private static final Logger LOGGER =  LoggerFactory.getLogger(LoggingTest.class);
	public static void main(String[] args) {
		LOGGER.debug("TEST");
		
		MDC.put("logFileName", "proc-01");
		 
		LOGGER.debug("hello");
	 
		MDC.remove("logFileName");
		
	}

}
