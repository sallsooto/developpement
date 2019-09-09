package org.sfd.gestionHopital.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class RvCalendar {
	private String date;
	private String dayName;
	List<CalendarHour> hours;
	public RvCalendar() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public RvCalendar(Calendar calendar) {
		this.date = new SimpleDateFormat("dd/MM/yyyy").format(calendar.getTime());
		this.dayName = new SimpleDateFormat("EEEE").format(calendar.getTime());
	}
	
	public RvCalendar(Calendar calendar,List<CalendarHour> hours) {
		this.date = new SimpleDateFormat("dd/MM/yyyy").format(calendar.getTime());
		this.dayName = new SimpleDateFormat("EEEE").format(calendar.getTime());
		this.hours = hours;
	}

	public String getDate() {
		return date;
	}

	public void setDate(Calendar calendar) {
		this.date = new SimpleDateFormat("dd/MM/yyyy").format(calendar.getTime());
	}

	public String getDayName() {
		return dayName;
	}

	public void setDayName(Calendar calendar) {
		this.dayName =  new SimpleDateFormat("EEEE").format(calendar.getTime());
	}

	public List<CalendarHour> getHours() {
		return hours;
	}

	public void setHours(List<CalendarHour> hours) {
		this.hours = hours;
	}
	
	
}
