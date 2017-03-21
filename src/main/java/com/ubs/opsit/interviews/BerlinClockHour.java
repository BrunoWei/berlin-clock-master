package com.ubs.opsit.interviews;

public class BerlinClockHour {

	private static final String ALL_LIGHTS_OFF = "OOOO";
	private static final String RED_LIGHT = "R";
	private static final int MULTIPLE_OF_FIVE = 5;
	private static final String SEPERATOR = "\r\n";

	private String getTopHours(int hours) {
		StringBuffer outPutLamps = new StringBuffer(ALL_LIGHTS_OFF);
		int numOfLampsToBeOn = hours / MULTIPLE_OF_FIVE;
		for (int i = 0; i < numOfLampsToBeOn; i++) {
			outPutLamps.replace(i, i + 1, RED_LIGHT);
		}
		return outPutLamps.toString();
	}

	private String getBottomHours(int hours) {
		StringBuffer outPutLamps = new StringBuffer(ALL_LIGHTS_OFF);
		int numOfLampsToBeOn = hours % MULTIPLE_OF_FIVE;
		for (int i = 0; i < numOfLampsToBeOn; i++) {
			outPutLamps.replace(i, i + 1, RED_LIGHT);
		}
		return outPutLamps.toString();
	}

	public String getLamps(int hours) {
		return getTopHours(hours) + SEPERATOR + getBottomHours(hours);
	}

}
