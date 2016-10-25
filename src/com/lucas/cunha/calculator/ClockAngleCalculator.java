package com.lucas.cunha.calculator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author lucas
 *
 */
public class ClockAngleCalculator {
	private static final int FULL_CLOCK_ANGLE = 360;
	private static final int HOUR_ANGLE = FULL_CLOCK_ANGLE / 12;
	private static final int MINUTE_ANGLE = FULL_CLOCK_ANGLE / 60;
	private Map<Time, Integer> calculatedAnglesByTime;
	
	public ClockAngleCalculator() {
		this.calculatedAnglesByTime = new HashMap<Time, Integer>();
	}
	
	public int getSmallestAngle(int hours) {
		return this.getSmallestAngle(hours, 0);
	}
	
	public int getSmallestAngle(int hours, int minutes) {
		Iterator<?> it = this.calculatedAnglesByTime.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        Time t = (Time)pair.getKey();
	        if(t.getHour() == hours && t.getMinute() == minutes) {
				return (int)pair.getValue();
	        }
	    }
		
		if(hours >= 12) {
			hours -= 12;
		}
		
		int difference = Math.abs((hours * HOUR_ANGLE) - (minutes * MINUTE_ANGLE));
		int angle = difference > 180 ? (FULL_CLOCK_ANGLE - difference) : difference;

		this.calculatedAnglesByTime.put(new Time(hours, minutes), angle);
		
		return angle;
	}

	public Map<Time, Integer> getCalculatedAnglesByTime() {
		return calculatedAnglesByTime;
	}
}
