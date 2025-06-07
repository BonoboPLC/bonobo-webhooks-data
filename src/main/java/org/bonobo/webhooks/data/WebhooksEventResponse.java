package org.bonobo.webhooks.data;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModelProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WebhooksEventResponse extends WebhooksEvent {

	private static final long serialVersionUID = -7235358528921733816L;
	
	@ApiModelProperty(required = true, allowEmptyValue = false, example = "0", allowableValues = "0,1,-1",
		notes = "Return 0 when all events are successfully processed, -1 if all failed, 1 for partial success (see errors)")
	private int status;

	public WebhooksEventResponse() {
		super();
	}

	public WebhooksEventResponse(int status) {
		super();
		this.status = status;
	}

	@Override
	@JsonIgnore
	public ArrayList<EventNotification> getEventNotifications() {
		return super.getEventNotifications();
	}

	@Override
	@JsonIgnore
	public void setEventNotifications(ArrayList<EventNotification> eventNotifications) {
		super.setEventNotifications(eventNotifications);
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
}
