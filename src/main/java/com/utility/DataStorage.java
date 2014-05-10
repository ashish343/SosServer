package com.utility;

import java.util.HashMap;
import java.util.Map;

public final class DataStorage {
	public static Map<String, DroneData> droneList = new HashMap<String, DroneData>();

	public static Map<String, DroneData> getDroneList() {
		return droneList;
	}

	public static void setDroneList(Map<String, DroneData> droneList) {
		DataStorage.droneList = droneList;
	}
	
	public static Map<String, DroneData> getMap() {
		return droneList;
	}
	
	public static void setInfo(String id, DroneData droneData) {
		droneList.put(id, droneData);
	}
}
