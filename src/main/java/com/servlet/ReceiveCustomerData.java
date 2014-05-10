package com.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.utility.DataStorage;
import com.utility.DroneData;

/*
 * codeforindia.herokuapp.com/data?droneId=1&isAlive=true&latitude=33&longtitude=33&objectId=2&objectIsAlive=true
 */
@SuppressWarnings("serial")
@WebServlet(
        name = "ReceiveCustomerData", 
        urlPatterns = {"/custdata"}
    )
public class ReceiveCustomerData extends HttpServlet {
    private static final Object ONE = "1";
	private static final Object ZERO = "0";
	protected final Log logger = LogFactory.getLog(getClass());
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	String droneId = request.getParameter("droneId");
    	if(droneId == null || droneId.isEmpty()) {
    		return;
    	}
    	
    	String isAlive = request.getParameter("isAlive");
    	String latitude = request.getParameter("latitude");
    	String longtitude = request.getParameter("longtitude");
    	String objectId = request.getParameter("objectId");
    	String objectIsAlive = request.getParameter("objectIsAlive");
    	
    	Map<String, DroneData> droneData = new HashMap<String, DroneData>();
    	
    	DroneData drone = new DroneData();
    	drone.setAlive(getAliveData(isAlive));
    	drone.setLongitude(Float.parseFloat(longtitude));
    	drone.setLatitude(Float.parseFloat(latitude));
    	
    	
    	Map<String, Boolean> objects = new HashMap<String, Boolean>();
    	if(objectId != null && !objectId.isEmpty()) {
    	    objects.put(objectId, getAliveData(objectIsAlive));
    	}
		
    	drone.setObjects(objects);
    	
    	DroneData droneHashMapData =  DataStorage.getDromeList(droneId);
    	
    	if(droneHashMapData != null) {
    		droneHashMapData.setAlive(getAliveData(isAlive));
    		droneHashMapData.setLatitude(Float.parseFloat(latitude));
    		droneHashMapData.setLongitude(Float.parseFloat(longtitude));
    		
    		if(getAliveData(isAlive)) {
    			// Update the objects hash map.
    			Map<String, Boolean> oldObjects = droneHashMapData.getObjects();
    			oldObjects.put(objectId, getAliveData(objectIsAlive));
    		} 
    		
    		droneData.put(droneId, droneHashMapData);
    		DataStorage.appendDroneList(droneData);
    	} else {
    		droneData.put(droneId, drone);
    		DataStorage.appendDroneList(droneData);
    	}
		
        Map<String, DroneData> droneList = DataStorage.getDroneList();
        Gson gson = new Gson();
        ServletOutputStream out = response.getOutputStream();
        out.write(gson.toJson(droneList).getBytes());
        out.flush();
    }
    
    private Boolean getAliveData(String objectIsAlive) {
		boolean isAlive = false;
		if(objectIsAlive != null && !objectIsAlive.equals(ZERO)) {
			isAlive = true;
		}
		return isAlive;
	}

	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    	doGet(req, resp);
    }
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	doGet(request, response);
    	return null;
    }
}

