package edu.ftn.iis.soas.ntf.handler.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.ftn.iis.soas.domain.model.NotificationRequest;
import edu.ftn.iis.soas.domain.model.NotificationResponse;
import edu.ftn.iis.soas.ntf.handler.service.NtfHandlerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/handler")
@Slf4j
@RequiredArgsConstructor
public class HandlerController {
	
	private final NtfHandlerService ntfHandlerService;
	
	@PostMapping("/handle")
	public NotificationResponse handle(@RequestBody NotificationRequest request) {
		log.info("handle call received");
		String status = ntfHandlerService.handleNotificationRequest(request);
		return new NotificationResponse(status, request.getSource());
	}
		
}
