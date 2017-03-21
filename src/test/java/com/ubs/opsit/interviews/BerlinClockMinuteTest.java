package com.ubs.opsit.interviews;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BerlinClockMinuteTest {

	private BerlinClockMinute berlinClockMinute = new BerlinClockMinute();
	
	@Test
	public void topMinutesShouldNotLightAnyYellowLampsWhenMinuteIs0() {
		assertEquals("OOOOOOOOOOO\r\nOOOO", berlinClockMinute.getLamps(0));
	}
	
	@Test
	public void topMinutesShouldLight2YellowLampsAnd1RedLampWhenItIsFirstQuarterWhenMinuteIs17() {
		assertEquals("YYROOOOOOOO\r\nYYOO", berlinClockMinute.getLamps(17));
	}
	
	@Test
	public void topMinutesShouldLight8YellowLampsAnd3RedLampsWhenItIsFirstQuarterHalfOrLastQuarterWhenMinuteIs59() {
		assertEquals("YYRYYRYYRYY\r\nYYYY", berlinClockMinute.getLamps(59));
	}

	@Test
	public void bottomMinutesShouldNotLightAnyYellowLampsWhenMinuteIs0() {
		assertEquals("OOOOOOOOOOO\r\nOOOO", berlinClockMinute.getLamps(0));
	}
	
	@Test
	public void bottomMinutesShouldLight1YellowLampWhenMinuteIs1() {
		assertEquals("OOOOOOOOOOO\r\nYOOO", berlinClockMinute.getLamps(1));
	}
	
	@Test
	public void bottomMinutesShouldLight3YellowLampsWhenMinuteIs3() {
		assertEquals("OOOOOOOOOOO\r\nYYYO", berlinClockMinute.getLamps(3));
	}
	
	@Test
	public void bottomMinutesShouldLight2YellowLampsWhenMinuteIs7() {
		assertEquals("YOOOOOOOOOO\r\nYYOO", berlinClockMinute.getLamps(7));
	}
	
	@Test
	public void bottomMinutesShouldLight2YellowLampsWhenMinuteIs17() {
		assertEquals("YYROOOOOOOO\r\nYYOO", berlinClockMinute.getLamps(17));
	}
	
	@Test
	public void bottomMinutesShouldLight4YellowLampsWhenMinuteIs59() {
		assertEquals("YYRYYRYYRYY\r\nYYYY", berlinClockMinute.getLamps(59));
	}
}
