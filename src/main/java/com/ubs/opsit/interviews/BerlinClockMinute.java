package com.ubs.opsit.interviews;

public class BerlinClockMinute {

	private static final String RED_LIGHT = "R";
	private static final String YELLOW_LIGHT = "Y";
	private static final String ALL_FOUR_LIGHTS_OFF = "OOOO";
	private static final String ALL_ELEVEN_LIGHTS_OFF = "OOOOOOOOOOO";
	private static final String SEPERATOR = "\r\n";

	private String getTopMinutes(int numOfLampsToBeOn) {
		StringBuffer outPutLamps = new StringBuffer(ALL_ELEVEN_LIGHTS_OFF);
		for (int i = 0; i < numOfLampsToBeOn; i++) {
			if (0 == (i + 1) % 3) {
				outPutLamps.replace(i, i + 1, RED_LIGHT);
			} else {
				outPutLamps.replace(i, i + 1, YELLOW_LIGHT);
			}
		}
		return outPutLamps.toString();
	}

	private String getBottomMinutes(int numOfLampsToBeOn) {
		StringBuffer outPutLamps = new StringBuffer(ALL_FOUR_LIGHTS_OFF);
		for (int i = 0; i < numOfLampsToBeOn; i++) {
			outPutLamps.replace(i, i + 1, YELLOW_LIGHT);
		}
		return outPutLamps.toString();
	}

	public String getLamps(int minutes) {
		int minuteDivided = minutes / 5;
		int minuteModule = minutes % 5;
		return getTopMinutes(minuteDivided) + SEPERATOR + getBottomMinutes(minuteModule);
	}

}
