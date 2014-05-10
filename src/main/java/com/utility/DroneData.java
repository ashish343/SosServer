package com.utility;

import java.util.Map;

public class DroneData {
	private String location;
	private boolean isAlive;
	private Map<String, Boolean> objects;
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
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
