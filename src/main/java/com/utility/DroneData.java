package com.utility;

import java.util.Map;

public class DroneData {
	private float latitude;
	private float longitude;
	
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	private boolean isAlive;
	private Map<String, Boolean> objects;
	
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
