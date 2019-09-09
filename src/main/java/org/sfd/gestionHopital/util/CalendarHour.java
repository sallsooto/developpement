package org.sfd.gestionHopital.util;

public class CalendarHour {
	private String houre;
	private boolean engaged;
	public CalendarHour() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CalendarHour(String houre, boolean engaged) {
		super();
		this.houre = houre;
		this.engaged = engaged;
	}
	public String getHoure() {
		return houre;
	}
	public void setHoure(String houre) {
		this.houre = houre;
	}
	public boolean isEngaged() {
		return engaged;
	}
	public void setEngaged(boolean engaged) {
		this.engaged = engaged;
	}
	
	
}
