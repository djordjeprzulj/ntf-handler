package edu.ftn.iis.soas.ntf.handler.client;

import javax.management.Notification;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import edu.ftn.iis.soas.domain.model.NotificationRequest;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class NtfLoggerClient {
	
	private RestTemplate restTemplate = new RestTemplate();
	
	@Value("${app.loggerUrl}")
	private String loggerUrl;
	
	public String logRequest(NotificationRequest request) {
				
		String path = "http://" + loggerUrl + "/api/logger/logRequest";
		String response = restTemplate.postForObject(path, request, String.class);
		log.trace("response: " + response);
		return response;
	}
	
	public String logNotification(Notification notification) {
		
		String path = "http://" + loggerUrl + "/api/logger/logNotification";
		String response = restTemplate.postForObject(path, notification, String.class);
		log.trace("response: " + response);
		return response;
	}
}
