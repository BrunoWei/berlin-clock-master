package com.ubs.opsit.interviews;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class BerlinClockTimeConverter implements GenericClock {

	private static final String SIGN_YELLOW = "Y";

	private static final String SIGN_RED = "R";

	private static final String SIGN_OFF = "O";

	private static final String SEPERATOR = "\r\n";

	@Override
	public String getHour(int num) {
		return getOnOffSigns(4, getTopRowOnSigns(num), SIGN_RED) + SEPERATOR + getOnOffSigns(4, getBottomRowOnSigns(num), SIGN_RED);
	}

	@Override
	public String getMinute(int num) {
		return getOnOffSigns(11, getTopRowOnSigns(num), SIGN_YELLOW).replaceAll("YYY", "YYR") + SEPERATOR + getOnOffSigns(4, getBottomRowOnSigns(num), SIGN_YELLOW);
	}

	@Override
	public String getSecond(int num) {
		if (num % 2 == 0) {
			return SIGN_YELLOW;
		} else {
			return SIGN_OFF;
		}
	}

	@Override
	public String convertTime(String aTime) {
		if (!(validate(aTime))) {
			throw new IllegalArgumentException("Invalid time : " + aTime);
		}
		int[] parts = Stream.of(aTime.split(":")).mapToInt(Integer::parseInt).toArray();
		StringBuilder sb = new StringBuilder();
		sb.append(getSecond(parts[2]));
		sb.append(SEPERATOR);
		sb.append(getHour(parts[0]));
		sb.append(SEPERATOR);
		sb.append(getMinute(parts[1]));
		return sb.toString();
	}

	protected String getOnOffSigns(int lampsInClockRow, int onSigns, String onSign) {
		String onOffSigns = "";
		for (int i = 0; i < onSigns; i++) {
			onOffSigns += onSign;
		}
		for (int i = 0; i < lampsInClockRow - onSigns; i++) {
			onOffSigns += SIGN_OFF;
		}
		return onOffSigns;
	}

	private int getTopRowOnSigns(int timeComponent) {
		return (timeComponent - (timeComponent % 5)) / 5;
	}

	private int getBottomRowOnSigns(int timeComponent) {
		return timeComponent % 5;
	}

	@Override
	public boolean validate(String inputTime) {
		if(inputTime == null || "".equals(inputTime)){
			return false;
		}
		Pattern pattern;
		Matcher matcher;
		pattern = Pattern.compile("^(?:[01]\\d|2[0-4])(?::[0-5]\\d){2}$");
		matcher = pattern.matcher(inputTime);
		if (matcher.matches()) {
			int[] timeComponents = Stream.of(inputTime.split(":")).mapToInt(Integer::parseInt).toArray();
			if (timeComponents[0] == 24 && (timeComponents[1] != 0 || timeComponents[2] != 0)) {
				return false;
			}
		}
		return matcher.matches();
	}
	


}
