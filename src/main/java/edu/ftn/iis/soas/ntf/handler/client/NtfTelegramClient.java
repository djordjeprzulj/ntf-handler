package edu.ftn.iis.soas.ntf.handler.client;

import edu.ftn.iis.soas.domain.model.Notification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class NtfTelegramClient {
	
	private RestTemplate restTemplate = new RestTemplate();
	
	@Value("${app.telegramUrl}")
	private String telegramUrl;
	
	public String send(Notification notification) {
				
		String path = "http://" + telegramUrl + "/api/telegram/send";
		String response = restTemplate.postForObject(path, notification, String.class);
		log.trace("response: " + response);
		return response;
	}

}
