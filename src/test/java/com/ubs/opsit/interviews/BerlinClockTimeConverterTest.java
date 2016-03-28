package com.ubs.opsit.interviews;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BerlinClockTimeConverterTest {

	BerlinClockTimeConverter berlinClockTimeConverter = new BerlinClockTimeConverter();
	
	@Test
	public void evenSecondsShouldTurnOn() {
		assertEquals("Y", berlinClockTimeConverter.getSecond(0));
		assertEquals("Y", berlinClockTimeConverter.getSecond(2));
	}

	@Test
	public void oddSecondsShouldTurnOff() {
		assertEquals("O", berlinClockTimeConverter.getSecond(1));
		assertEquals("O", berlinClockTimeConverter.getSecond(59));
	}

	@Test
	public void topHoursShouldLightRedLampForEvery5Hours() {
		assertEquals("OOOO\r\nOOOO", berlinClockTimeConverter.getHour(0));
		assertEquals("RROO\r\nRRRO", berlinClockTimeConverter.getHour(13));
		assertEquals("RRRR\r\nRRRO", berlinClockTimeConverter.getHour(23));
		assertEquals("RRRR\r\nRRRR", berlinClockTimeConverter.getHour(24));
	}

	@Test
	public void bottomHoursShouldLightRedLampForEverySingleHourLeftFromTopHours() {
		assertEquals("OOOO\r\nOOOO", berlinClockTimeConverter.getHour(0));
		assertEquals("OOOO\r\nROOO", berlinClockTimeConverter.getHour(1));
		assertEquals("OOOO\r\nRRRO", berlinClockTimeConverter.getHour(3));
		assertEquals("ROOO\r\nRROO", berlinClockTimeConverter.getHour(7));
		assertEquals("RROO\r\nRRRO", berlinClockTimeConverter.getHour(13));
		assertEquals("RRRR\r\nRRRO", berlinClockTimeConverter.getHour(23));
		assertEquals("RRRR\r\nRRRR", berlinClockTimeConverter.getHour(24));
	}

	@Test
	public void topMinutesShouldLightYellowLampForEvery5MinutesUnlessItIsFirstQuarterHalfOrLastQuarter() {
		assertEquals("OOOOOOOOOOO\r\nOOOO", berlinClockTimeConverter.getMinute(0));
		assertEquals("YYROOOOOOOO\r\nYYOO", berlinClockTimeConverter.getMinute(17));
		assertEquals("YYRYYRYYRYY\r\nYYYY", berlinClockTimeConverter.getMinute(59));
	}

	@Test
	public void bottomMinutesShouldLightYellowLampForEveryMinuteLeftFromTopMinutes() {
		assertEquals("OOOOOOOOOOO\r\nOOOO", berlinClockTimeConverter.getMinute(0));
		assertEquals("OOOOOOOOOOO\r\nYOOO", berlinClockTimeConverter.getMinute(1));
		assertEquals("OOOOOOOOOOO\r\nYYYO", berlinClockTimeConverter.getMinute(3));
		assertEquals("YOOOOOOOOOO\r\nYYOO", berlinClockTimeConverter.getMinute(7));
		assertEquals("YYROOOOOOOO\r\nYYOO", berlinClockTimeConverter.getMinute(17));
		assertEquals("YYRYYRYYRYY\r\nYYYY", berlinClockTimeConverter.getMinute(59));
	}

	@Test
	public void berlinClockShouldBeConvertedIntoCorrectSecondsHoursAndMinutes() {
		assertEquals("Y\r\nRRRO\r\nROOO\r\nYYRYYRYOOOO\r\nYYOO",berlinClockTimeConverter.convertTime("16:37:16"));
		assertEquals("Y\r\nOOOO\r\nOOOO\r\nOOOOOOOOOOO\r\nOOOO",berlinClockTimeConverter.convertTime("00:00:00"));
		assertEquals("O\r\nRROO\r\nRRRO\r\nYYROOOOOOOO\r\nYYOO",berlinClockTimeConverter.convertTime("13:17:01"));
		assertEquals("O\r\nRRRR\r\nRRRO\r\nYYRYYRYYRYY\r\nYYYY",berlinClockTimeConverter.convertTime("23:59:59"));
		assertEquals("Y\r\nRRRR\r\nRRRR\r\nOOOOOOOOOOO\r\nOOOO",berlinClockTimeConverter.convertTime("24:00:00"));
	}

	@Test
	public void invalidTimeFormat1() throws Exception {
		assertEquals(false, berlinClockTimeConverter.validate(null));
	}

	@Test
	public void invalidTimeFormat2() throws Exception {
		assertEquals(false, berlinClockTimeConverter.validate(""));
	}

	@Test
	public void invalidTimeFormat3() throws Exception {
		assertFalse(berlinClockTimeConverter.validate("abc"));
	}

	@Test
	public void invalidTimeFormat4() throws Exception {
		assertFalse(berlinClockTimeConverter.validate("12:61:00"));
	}

	@Test
	public void invalidTimeFormat5() throws Exception {
		assertFalse(berlinClockTimeConverter.validate("25:00:00"));
	}

	@Test
	public void invalidTimeFormat6() throws Exception {
		assertFalse(berlinClockTimeConverter.validate("25:00:68"));
	}

	@Test
	public void invalidTimeFormat7() throws Exception {
		assertFalse(berlinClockTimeConverter.validate("112233"));
	}
	
	@Test
	public void validTimeFormat() throws Exception {
		assertTrue(berlinClockTimeConverter.validate("12:12:12"));
	}

}
