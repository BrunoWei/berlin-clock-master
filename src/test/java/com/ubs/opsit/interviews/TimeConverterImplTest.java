package com.ubs.opsit.interviews;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TimeConverterImplTest {

	TimeConverterImpl tc = new TimeConverterImpl();

	// A given time should be correctly converted to Berlin time.
	@Test
	public void testConvertTime() {
		String berlinTime1 = tc.convertTime("17:37:16");
		String expected1 = "Y\r\nRRRO\r\nRROO\r\nYYRYYRYOOOO\r\nYYOO";
		assertEquals(expected1, berlinTime1);

		String berlinTime2 = tc.convertTime("00:00:00");
		String expected2 = "Y\r\nOOOO\r\nOOOO\r\nOOOOOOOOOOO\r\nOOOO";
		assertEquals(expected2, berlinTime2);

		String berlinTime3 = tc.convertTime("13:17:01");
		String expected3 = "O\r\nRROO\r\nRRRO\r\nYYROOOOOOOO\r\nYYOO";
		assertEquals(expected3, berlinTime3);

		String berlinTime4 = tc.convertTime("23:59:59");
		String expected4 = "O\r\nRRRR\r\nRRRO\r\nYYRYYRYYRYY\r\nYYYY";
		assertEquals(expected4, berlinTime4);

		String berlinTime5 = tc.convertTime("24:00:00");
		String expected5 = "Y\r\nRRRR\r\nRRRR\r\nOOOOOOOOOOO\r\nOOOO";
		assertEquals(expected5, berlinTime5);
	}

	// Yellow lamp should blink on/off every two seconds
	@Test
	public void testGetSecondOnOff() {
		assertEquals("Y", tc.getSecondOnOff(0));
		assertEquals("O", tc.getSecondOnOff(1));
		assertEquals("Y", tc.getSecondOnOff(2));
		assertEquals("O", tc.getSecondOnOff(59));
	}

	// The first hour row should light a red lamp for every 5 hours
	@Test
	public void testGetFirstRowHours() {
		assertEquals("OOOO", tc.getFirstRowHours(0));
		assertEquals("ROOO", tc.getFirstRowHours(7));
		assertEquals("RROO", tc.getFirstRowHours(13));
		assertEquals("RRRR", tc.getFirstRowHours(23));
		assertEquals("RRRR", tc.getFirstRowHours(24));
	}

	// The second hour row should light a red lamp for every hour left from the
	// first hour row.
	@Test
	public void testGetSecondRowHours() {
		assertEquals("OOOO", tc.getSecondRowHours(0));
		assertEquals("ROOO", tc.getSecondRowHours(6));
		assertEquals("RROO", tc.getSecondRowHours(7));
		assertEquals("RRRO", tc.getSecondRowHours(13));
		assertEquals("RRRO", tc.getSecondRowHours(23));
		assertEquals("RRRR", tc.getSecondRowHours(24));
	}

	// The first minute row should light a yellow lamp for every 5 minutes
	// unless it's first quarter, half or last quarter
	@Test
	public void testGetFirstRowMins() {
		assertEquals("OOOOOOOOOOO", tc.getFirstRowMins(0));
		assertEquals("YOOOOOOOOOO", tc.getFirstRowMins(7));
		assertEquals("YYOOOOOOOOO", tc.getFirstRowMins(13));
		assertEquals("YYROOOOOOOO", tc.getFirstRowMins(17));
		assertEquals("YYRYYRYYRYY", tc.getFirstRowMins(59));
	}

	// The second minute row should light a yellow lamp for every minute left
	// from the first minute row.
	@Test
	public void testGetSecondRowMins() {
		assertEquals("OOOO", tc.getSecondRowMins(0));
		assertEquals("YYOO", tc.getSecondRowMins(17));
		assertEquals("YYYY", tc.getSecondRowMins(59));
	}

}
