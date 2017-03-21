package com.ubs.opsit.interviews;

public class BerlinClockSecond {

	public String getLamps(int seconds) {
		if (seconds % 2 == 0) {
			return "Y";
		}
		return "O";
	}

}
