package com.ubs.opsit.interviews;

public interface GenericClock extends TimeConverter {
	
	public String getSecond(int num);
	
	public String getHour(int num);
	
	public String getMinute(int num);
	
	public boolean validate(String inputTime);

}
