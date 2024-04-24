package edu.ftn.iis.soas.ntf.handler.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import edu.ftn.iis.soas.domain.model.Notification;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class NtfEmailClient {
	
	private RestTemplate restTemplate = new RestTemplate();
	
	@Value("${app.emailUrl}")
	private String emailUrl;
	
	public String send(Notification notification) {
				
		String path = "http://" + emailUrl + "/api/email/send";
		String response = restTemplate.postForObject(path, notification, String.class);
		log.trace("response: " + response);
		return response;
	}

}
