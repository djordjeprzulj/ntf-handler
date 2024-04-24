package edu.ftn.iis.soas.ntf.handler.service.impl;

import org.springframework.stereotype.Service;

import edu.ftn.iis.soas.domain.model.Notification;
import edu.ftn.iis.soas.domain.model.NotificationRequest;
import edu.ftn.iis.soas.ntf.handler.client.NtfEmailClient;
import edu.ftn.iis.soas.ntf.handler.client.NtfLoggerClient;
import edu.ftn.iis.soas.ntf.handler.service.NtfHandlerService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NtfHandlerServiceImpl implements NtfHandlerService {

	private final NtfLoggerClient ntfLoggerClient;
	private final NtfEmailClient ntfEmailClient;
	
	@Override
	public String handleNotificationRequest(NotificationRequest request) {
		
		String response = ntfLoggerClient.logRequest(request);
		
		String channel = request.getChannel(); 
		if (channel.equalsIgnoreCase("email")) {
			String[] destinations = request.getDestinations().split(",");
			for (String destination : destinations) {
				Notification notification = new Notification();
				notification.setDestination(destination.trim());
				notification.setPayload(request.getText());
				ntfEmailClient.send(notification);	
				// TODO log sent notification
			}			
		} else {
			return "Channel " + channel + " not supported.";
		}
	
		return response;
	}

}
