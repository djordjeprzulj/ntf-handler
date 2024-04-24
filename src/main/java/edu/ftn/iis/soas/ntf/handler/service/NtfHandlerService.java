package edu.ftn.iis.soas.ntf.handler.service;

import edu.ftn.iis.soas.domain.model.NotificationRequest;

public interface NtfHandlerService {

	String handleNotificationRequest(NotificationRequest request);
	
}
