package com.ubs.opsit.interviews;

import static org.junit.Assert.*;

import org.junit.Test;

public class TimeFormatValidatorTest {
		
	@Test
	public void testWhenInputTimeIsNull() throws Exception {
		assertEquals(false, TimeFormatValidator.validate(null));
	}

	@Test
	public void testWhenInputTimeIsBlank() throws Exception {
		assertEquals(false, TimeFormatValidator.validate(""));
	}

	@Test
	public void testWhenInputTimeWithMinuteExceeds60() throws Exception {
		assertFalse(TimeFormatValidator.validate("12:61:00"));
	}

	@Test
	public void testWhenInputTimeWithHourExceeds24() throws Exception {
		assertFalse(TimeFormatValidator.validate("25:00:00"));
	}

	@Test
	public void testWhenInputTimeWithSecondExceeds60() throws Exception {
		assertFalse(TimeFormatValidator.validate("23:00:68"));
	}
	
	@Test
	public void testWhenInputTimeWithInvalidHourFormat() throws Exception {
		assertFalse(TimeFormatValidator.validate("-10:00:00"));
	}
	
	@Test
	public void testWhenInputTimeWithInvalidMinuteFormat() throws Exception {
		assertFalse(TimeFormatValidator.validate("10:a10:00"));
	}
	
	@Test
	public void testWhenInputTimeWithInvalidSecondFormat() throws Exception {
		assertFalse(TimeFormatValidator.validate("10:10:110"));
	}
	
	@Test
	public void testWhenInputTimeWithHourIs24AndMinuteIsNot0() throws Exception {
		assertFalse(TimeFormatValidator.validate("24:10:00"));
	}
	
	@Test
	public void testWhenInputTimeWithHourIs24AndSecondIsNot0() throws Exception {
		assertFalse(TimeFormatValidator.validate("24:00:05"));
	}

	@Test
	public void testWhenInputTimeIsNotATime() throws Exception {
		assertFalse(TimeFormatValidator.validate("112233"));
	}

	@Test
	public void testWhenInputTimeIsValid() throws Exception {
		assertTrue(TimeFormatValidator.validate("12:12:12"));
	}


}
