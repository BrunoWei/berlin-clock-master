package com.ubs.opsit.interviews;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BerlinClockHourTest {

	private BerlinClockHour berlinClockHour = new BerlinClockHour();
	
	@Test
	public void topHoursShouldNotLightAnyRedLampsWhenHourIs0() {
		assertEquals("OOOO\r\nOOOO", berlinClockHour.getLamps(0));
		
	}
	
	@Test
	public void topHoursShouldNotLightAnyRedLampsWhenHourIs4() {
		assertEquals("OOOO\r\nOOOO", berlinClockHour.getLamps(0));
		
	}
	
	@Test
	public void topHoursShouldLight1RedLampWhenHourIs5() {
		assertEquals("ROOO\r\nOOOO", berlinClockHour.getLamps(5));
		
	}
	
	@Test
	public void topHoursShouldLight2RedLampsWhenHourIs13() {
		assertEquals("RROO\r\nRRRO", berlinClockHour.getLamps(13));
		
	}
	
	@Test
	public void topHoursShouldLight4RedLampsWhenHourIs23() {
		assertEquals("RRRR\r\nRRRO", berlinClockHour.getLamps(23));
		
	}
	
	@Test
	public void topHoursShouldLight4RedLampsWhenHourIs24() {
		assertEquals("RRRR\r\nRRRR", berlinClockHour.getLamps(24));
		
	}

	
	@Test
	public void bottomHoursShouldNotLightAnyRedLampsWhenHourIs0() {
		assertEquals("OOOO\r\nOOOO", berlinClockHour.getLamps(0));
	}
	
	@Test
	public void bottomHoursShouldLight1RedLampWhenHourIs1() {
		assertEquals("OOOO\r\nROOO", berlinClockHour.getLamps(1));
	}
	
	@Test
	public void bottomHoursShouldLight3RedLampsWhenHourIs3() {
		assertEquals("OOOO\r\nRRRO", berlinClockHour.getLamps(3));
	}
	
	@Test
	public void bottomHoursShouldLight2RedLampsWhenHourIs7() {
		assertEquals("ROOO\r\nRROO", berlinClockHour.getLamps(7));
	}
	
	@Test
	public void bottomHoursShouldLight3RedLampsWhenHourIs13() {
		assertEquals("RROO\r\nRRRO", berlinClockHour.getLamps(13));
	}
	
	@Test
	public void bottomHoursShouldLight3RedLampsWhenHourIs23() {
		assertEquals("RRRR\r\nRRRO", berlinClockHour.getLamps(23));
	}
	
	@Test
	public void bottomHoursShouldLight4RedLampsWhenHourIs24() {
		assertEquals("RRRR\r\nRRRR", berlinClockHour.getLamps(24));
	}
}
