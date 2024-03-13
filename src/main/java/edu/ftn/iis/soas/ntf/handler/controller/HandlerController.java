package edu.ftn.iis.soas.ntf.handler.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.ftn.iis.soas.ntf.handler.model.NotificationRequest;
import edu.ftn.iis.soas.ntf.handler.model.NotificationResponse;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/handler")
@Slf4j
public class HandlerController {

	@PostMapping("/handle")
	public NotificationResponse handle(@RequestBody NotificationRequest request) {
		log.info("handle call received");
		return new NotificationResponse(request.getSource(),"OK");
	}
		
}
