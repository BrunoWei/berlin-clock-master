package com.ubs.opsit.interviews;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BerlinClockSecondTest {

	private BerlinClockSecond berlinClockSecond = new BerlinClockSecond();
	
	@Test
	public void testEvenSecondsShouldTurnOnWhenSecondIs0() {
		assertEquals("Y", berlinClockSecond.getLamps(0));
	}
	
	@Test
	public void testEvenSecondsShouldTurnOnWhenSecondIs2() {
		assertEquals("Y", berlinClockSecond.getLamps(2));
	}

	@Test
	public void testOddSecondsShouldTurnOffWhenSecondIs1() {
		assertEquals("O", berlinClockSecond.getLamps(1));
	}
	
	@Test
	public void testOddSecondsShouldTurnOffWhenSecondIs59() {
		assertEquals("O", berlinClockSecond.getLamps(59));
	}
}
