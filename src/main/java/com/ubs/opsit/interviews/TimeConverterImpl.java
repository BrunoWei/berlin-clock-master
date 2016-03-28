package com.ubs.opsit.interviews;

import java.util.stream.Stream;

/**
 * @author Bruno_Wei
 *
 */
public class TimeConverterImpl implements TimeConverter {

	private static final String SIGN_YELLOW = "Y";// The sign for the YELLOW lamp.

	private static final String SIGN_RED = "R";// The sign for the RED lamp.

	private static final String SIGN_OFF = "O";// The sign for the OFF lamp.

	private static final String SPLITER = "\r\n";// The separator

	private static final int ROW235_LAMPS_NUM = 4;// The number of lamps for each of the two hour rows and the second minute row.

	private static final int ROW4_LAMPS_NUM = 11;// The number of the lamps for the first minute row.

	/**
	 * This method returns the  Berlin time of a given time string.
	 * 
	 * @param aTime
	 * @return
	 */
	@Override
	public String convertTime(String aTime) {
		int[] parts = Stream.of(aTime.split(":")).mapToInt(Integer::parseInt).toArray();
		StringBuilder sb = new StringBuilder();
		sb.append(getSecondOnOff(parts[2]));
		sb.append(SPLITER);
		sb.append(getFirstRowHours(parts[0]));
		sb.append(SPLITER);
		sb.append(getSecondRowHours(parts[0]));
		sb.append(SPLITER);
		sb.append(getFirstRowMins(parts[1]));
		sb.append(SPLITER);
		sb.append(getSecondRowMins(parts[1]));
		return sb.toString();
	}

	/**
	 * This method returns the on and off sign for the first row. Y is returned
	 * when num is an even number and O is returned when num is an odd number.
	 * 
	 * @param num
	 * @return
	 */
	protected String getSecondOnOff(int num) {
		if (num % 2 == 0) {
			return SIGN_YELLOW;
		} else {
			return SIGN_OFF;
		}
	}

	/**
	 * This method returns the on and off signs for the first hour row. At 5
	 * hours past, ROOO is returned. At 10 hours past, RROO is returned. At 15
	 * hours past, RRRO is returned. At 23 hours past, RRRR is returned.
	 * 
	 * @param num
	 * @return
	 */
	protected String getFirstRowHours(int num) {
		return getOnOffSigns(ROW235_LAMPS_NUM, getTopOnNum(num), SIGN_RED);
	}

	/**
	 * This method returns the on and off signs for the second hour row. When it
	 * is 1 hour past, ROOO is returned. When it is 2 hours past, RROO is
	 * returned. When it is 5 hours past, OOOO is returned.
	 * 
	 * @param num
	 * @return
	 */
	protected String getSecondRowHours(int num) {
		return getOnOffSigns(ROW235_LAMPS_NUM, getBottomOnNum(num), SIGN_RED);
	}

	/**
	 * This method returns the on and off signs for the first minute row. At 5
	 * past the minute, YOOOOOOOOOO is returned. At 15 past the minute,
	 * YYROOOOOOOOOO is returned. At 55 past the minute, YYRYYRYYRYY is
	 * returned.
	 * 
	 * @param num
	 * @return
	 */
	protected String getFirstRowMins(int num) {
		return getOnOffSigns(ROW4_LAMPS_NUM, getTopOnNum(num), SIGN_YELLOW).replaceAll("YYY", "YYR");
	}

	/**
	 * This method returns the on and off signs for the second minute row. When
	 * it is 1 minute past the hour, YOOO is returned. When it is 2 minutes past
	 * the hour, YYOO is returned. When it is 5 minutes past the hour, OOOO is
	 * returned.
	 * 
	 * @param num
	 * @return
	 */
	protected String getSecondRowMins(int num) {
		return getOnOffSigns(ROW235_LAMPS_NUM, getBottomOnNum(num), SIGN_YELLOW);
	}

	/**
	 * This method returns the on and off signs for a given row.
	 * 
	 * @param lamps
	 * @param onSigns
	 * @param onSign
	 * @return
	 */
	protected String getOnOffSigns(int lamps, int onSigns, String onSign) {
		String onOffSigns = "";
		for (int i = 0; i < onSigns; i++) {
			onOffSigns += onSign;
		}
		for (int i = 0; i < lamps - onSigns; i++) {
			onOffSigns += SIGN_OFF;
		}
		return onOffSigns;
	}

	/**
	 * This method returns the number of the on signs for the first hour row and
	 * the first minute row.
	 * 
	 * @param num
	 * @return
	 */
	private int getTopOnNum(int num) {
		return (num - (num % 5)) / 5;
	}

	/**
	 * This method returns the number of the on signs for the second hour row
	 * and the second minute row.
	 * 
	 * @param num
	 * @return
	 */
	private int getBottomOnNum(int num) {
		return num % 5;
	}

}
