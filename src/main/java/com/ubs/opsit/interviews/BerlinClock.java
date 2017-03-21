package com.ubs.opsit.interviews;

public class BerlinClock implements TimeConverter {
	
	private BerlinClockHour hour;	
	private BerlinClockMinute minute;	
	private BerlinClockSecond second;
	
	private static final String SEPERATOR = "\r\n";
	
	public BerlinClock(){
		hour = new BerlinClockHour();
		minute = new BerlinClockMinute();
		second = new BerlinClockSecond();
	}

	@Override
	public String convertTime(String aTime) {
		if (!(TimeFormatValidator.validate(aTime))) {
			throw new IllegalArgumentException("Invalid time : " + aTime);
		}
		
		TimeComponents timeComponents = TimeComponents.getTimeComponents(aTime);
		StringBuilder timeString = new StringBuilder();
		timeString.append(second.getLamps(timeComponents.getSecond()));
		timeString.append(SEPERATOR);
		timeString.append(hour.getLamps(timeComponents.getHour()));
		timeString.append(SEPERATOR);
		timeString.append(minute.getLamps(timeComponents.getMinute()));
		
		return timeString.toString();
	}

}
