package org.layz.hx.core.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateUtil {
	private static final Logger LOGGER = LoggerFactory.getLogger(DateUtil.class);
	
	private DateUtil() {
		LOGGER.debug("private init");
	}
	
	public static Date parse(String source, String pattern) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.parse(source);
	}
}
