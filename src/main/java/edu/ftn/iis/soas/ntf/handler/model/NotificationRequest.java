package edu.ftn.iis.soas.ntf.handler.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class NotificationRequest {
	
	private String source;
	private List<String> destinations;
	private Channel channel;
	private Template template;
	private String text;
	private Integer priority;
	
}
