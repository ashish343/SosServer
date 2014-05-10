package com.servlet;

import java.io.IOException;
import java.util.Date;
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

@SuppressWarnings("serial")
@WebServlet(
        name = "Servlet", 
        urlPatterns = {"/home"}
    )
public class DefaultController extends HttpServlet {
    protected final Log logger = LogFactory.getLog(getClass());
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	Map<String, DroneData> droneData = new HashMap<String, DroneData>();
    	
    	DroneData drone = new DroneData();
    	drone.setAlive(true);
    	drone.setLocation("abc");
    	Map<String, Boolean> objects = new HashMap<String, Boolean>();
    	objects.put("1", true);
		drone.setObjects(objects );
		
		droneData.put("Drone1", drone);
		
		DataStorage.setDroneList(droneData );
        Map<String, DroneData> droneList = DataStorage.getDroneList();
        Gson gson = new Gson();
        ServletOutputStream out = response.getOutputStream();
        out.write(gson.toJson(droneList).getBytes());
        out.flush();
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    	ServletOutputStream out = resp.getOutputStream();
        out.write("heroku".getBytes());
        out.flush();
    	handleRequest(req, resp);
    }
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	String now = (new Date()).toString();
        logger.info("Returning hello view with " + now);
        return new ModelAndView("/WEB_INF/jsp/hello.jsp", "now", now);
    }
}

