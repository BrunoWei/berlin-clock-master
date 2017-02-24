package com.ubs.opsit.interviews;

public interface GenericClock extends TimeConverter {
	
	public String getSecond(int timeComponent);
	
	public String getHour(int timeComponent);
	
	public String getMinute(int timeComponent);
	
	public boolean validate(String inputTime);

}
