package com.ubs.opsit.interviews;

import java.util.stream.Stream;

public class TimeComponents {
	
	private int hour;
	
	private int minute;
	
	private int second;	

	private TimeComponents(int hour, int minute, int second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}

	public int getHour() {
		return hour;
	}

	public int getMinute() {
		return minute;
	}

	public int getSecond() {
		return second;
	}

	
	public static TimeComponents getTimeComponents(String aTime){
		int[] timeComponentsArray= Stream.of(aTime.split(":")).mapToInt(Integer::parseInt).toArray();		 
		return new TimeComponents(timeComponentsArray[0],timeComponentsArray[1],timeComponentsArray[2]);
	}


}
