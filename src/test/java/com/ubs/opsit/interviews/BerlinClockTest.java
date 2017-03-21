package com.ubs.opsit.interviews;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BerlinClockTest {

	public  BerlinClock berlinClock = new BerlinClock();

	@Test
	public void berlinClockShouldBeConvertedIntoCorrectSecondsHoursAndMinutesWhenTimeIs16_37_16() {
		assertEquals("Y\r\nRRRO\r\nROOO\r\nYYRYYRYOOOO\r\nYYOO", berlinClock.convertTime("16:37:16"));
	}
	
	@Test
	public void berlinClockShouldBeConvertedIntoCorrectSecondsHoursAndMinutesWhenTimeIs00_00_00() {
		assertEquals("Y\r\nOOOO\r\nOOOO\r\nOOOOOOOOOOO\r\nOOOO", berlinClock.convertTime("00:00:00"));
	}
	
	@Test
	public void berlinClockShouldBeConvertedIntoCorrectSecondsHoursAndMinutesWhenTimeIs13_17_01() {
		assertEquals("O\r\nRROO\r\nRRRO\r\nYYROOOOOOOO\r\nYYOO", berlinClock.convertTime("13:17:01"));;
	}
	
	@Test
	public void berlinClockShouldBeConvertedIntoCorrectSecondsHoursAndMinutesWhenTimeIs23_59_59() {
		assertEquals("O\r\nRRRR\r\nRRRO\r\nYYRYYRYYRYY\r\nYYYY", berlinClock.convertTime("23:59:59"));
	}
	
	@Test
	public void berlinClockShouldBeConvertedIntoCorrectSecondsHoursAndMinutesWhenTimeIs24_00_00() {
		assertEquals("Y\r\nRRRR\r\nRRRR\r\nOOOOOOOOOOO\r\nOOOO", berlinClock.convertTime("24:00:00"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConvertTimeShouldThrowExceptionWhenHourIsMoreThan24() {
		berlinClock.convertTime("25:37:16");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConvertTimeShouldThrowExceptionWhenMinuteIsMoreThan60() {
		berlinClock.convertTime("22:61:16");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConvertTimeShouldThrowExceptionWhenSecondIsMoreThan60() {
		berlinClock.convertTime("22:59:61");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConvertTimeShouldThrowExceptionWhenMinuteHasNonNumericCharacter() {
		berlinClock.convertTime("23:a3:16");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConvertTimeShouldThrowExceptionWhenSecondHasNonNumericCharacter() {
		berlinClock.convertTime("23:23:a6");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConvertTimeShouldThrowExceptionWhenHourHasNonNumericCharacter() {
		berlinClock.convertTime("a3:23:16");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConvertTimeShouldThrowExceptionWhenSecondHasMoreThan2Chars() {
		berlinClock.convertTime("23:37:166");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConvertTimeShouldThrowExceptionWhenMinuteHasMoreThan2Chars() {
		berlinClock.convertTime("23:377:16");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConvertTimeShouldThrowExceptionWhenHourHasMoreThan2Chars() {
		berlinClock.convertTime("223:37:16");
	}
	

}
