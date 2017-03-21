package com.ubs.opsit.interviews;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TimeComponentsTest {

	private TimeComponents timeComponents = TimeComponents.getTimeComponents("12:12:12");
	
	@Test
	public void testShouldReturnCorrectHour() {		
		assertEquals(timeComponents.getHour(), 12);
	}
	
	@Test
	public void testShouldReturnCorrectMinute() {		
		assertEquals(timeComponents.getMinute(), 12);
	}
	
	@Test
	public void testShouldReturnCorrectSecond() {		
		assertEquals(timeComponents.getSecond(), 12);
	}

}
