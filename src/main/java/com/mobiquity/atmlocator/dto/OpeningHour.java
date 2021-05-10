package com.mobiquity.atmlocator.dto;

import java.util.List;
/**
 * Model class that represents the OpeningHour
 * 
 * @author Madanmohan Vasa
 */
public class OpeningHour {
	private int dayOfWeek;
	private List<Hour> hours;
	public int getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(int dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	public List<Hour> getHours() {
		return hours;
	}
	public void setHours(List<Hour> hours) {
		this.hours = hours;
	}
}
