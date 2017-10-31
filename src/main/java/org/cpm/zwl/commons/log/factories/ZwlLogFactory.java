package org.cpm.zwl.commons.log.factories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZwlLogFactory {

	public static Logger getLogger(Class<?> clazz) {
		return LoggerFactory.getLogger(clazz.getName());
	}
	
	public static Logger getLogger(String logName) {
		return LoggerFactory.getLogger(logName);
	}
}
