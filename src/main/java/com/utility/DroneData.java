package com.utility;

import java.util.Map;

public class DroneData {
	private double latitude;
	private double longitude;
	private boolean isAlive;
	private Map<String, Boolean> objects;
	
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	public boolean isAlive() {
		return isAlive;
	}
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
	public Map<String, Boolean> getObjects() {
		return objects;
	}
	public void setObjects(Map<String, Boolean> objects) {
		this.objects = objects;
	}
	
}
