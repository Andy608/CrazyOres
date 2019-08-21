package com.crazyores.util;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import com.crazyores.CrazyOres;


public class LoggerUtil 
{
	public static final Marker LOGGER_TAG = MarkerManager.getMarker(CrazyOres.MOD_ID);
	
	public static void info(final String message)
	{
		Logger logger = LogManager.getLogger();
		logger.log(Level.INFO, LOGGER_TAG, message);
	}
	
	public static void debug(final Throwable throwable, final String message, final Object... params)
	{
		Logger logger = LogManager.getLogger();
		logger.log(Level.DEBUG, LOGGER_TAG, logger.getMessageFactory().newMessage(message, params), throwable);
	}
	
	public static void error(final Throwable throwable, final String message, final Object... params)
	{
		Logger logger = LogManager.getLogger();
		logger.error(logger.getMessageFactory().newMessage(message, params), throwable);
	}
}
