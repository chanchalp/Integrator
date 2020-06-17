package com.integrator.v1.controller;


import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.integrator.v1.model.ItemReserveEvent;
import com.integrator.v1.model.Response;



@CrossOrigin
@RestController
@RequestMapping(value="api/v1")
public class NotifyController {
	
	public static final Logger LOGGER = Logger.getLogger(NotifyController.class);
	
	@RequestMapping(value = "/facility/{facility_id}/reservation/notify", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<Response> notifyItemReserveEvent(@RequestBody ItemReserveEvent itemReserveEvent,
			@PathVariable("facility_id") String facilityId, HttpServletRequest request) throws Exception {
		Gson gson = new Gson();
		LOGGER.info("notifyItemReserveEvent start for request payload... " + gson.toJson(itemReserveEvent));
		LOGGER.info("facility_id :" + facilityId);
		try {
			LOGGER.info("pushing notification object to DSNS");
			
			// TODO

		} catch (Exception e) {
			LOGGER.error("Exception occred while notifying ItemReserveEvent :: " + e.getMessage());
			throw new Exception();
		}

		return new ResponseEntity<Response>(HttpStatus.OK);

	}

}
