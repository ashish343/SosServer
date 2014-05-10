package com.utility;

import java.util.HashMap;
import java.util.Map;

public class DataStorage {
	public static Map<String, DroneData> droneList = new HashMap<String, DroneData>();

	public static Map<String, DroneData> getDroneList() {
		return droneList;
	}

	public static DroneData getDromeList(String key) {
		return droneList.get(key);
	}
	public static void appendDroneList(Map<String, DroneData> droneListValue) {
		droneList.putAll(droneListValue);
	}
	
	public static Map<String, DroneData> getMap() {
		return droneList;
	}
	
	public static void setInfo(String id, DroneData droneData) {
		droneList.put(id, droneData);
	}
}
