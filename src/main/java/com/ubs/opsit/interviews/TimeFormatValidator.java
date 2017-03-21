package com.ubs.opsit.interviews;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeFormatValidator {
	
	private static final Pattern pattern = Pattern.compile("^(?:[01]\\d|2[0-4])(?::[0-5]\\d){2}$");
	
	public static boolean validate(String inputTime){
		if (inputTime == null || "".equals(inputTime)) {
			return false;
		}
		
		Matcher matcher = pattern.matcher(inputTime);
		
		if (matcher.matches()) {
			return isTimeMoreThan24Hours(inputTime);
		}
		return false;
	}
	
	public static boolean isTimeMoreThan24Hours(String inputTime){
		TimeComponents timeComponents =  TimeComponents.getTimeComponents(inputTime);
		if (timeComponents.getHour() == 24 && (timeComponents.getMinute() != 0 || timeComponents.getSecond() != 0)) {
			return false;
		}
		return true;
	}

}
