package org.bonobo.webhooks.data;

import java.io.Serializable;
import java.util.ArrayList;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "The top level event type")
@JsonIgnoreProperties(ignoreUnknown = true)
public class WebhooksEvent  implements Serializable {

	private static final long serialVersionUID = 5010712543589848791L;
	
	@Valid
	@Size(max = 100)
	@NotEmpty(message="At least one event must be present")
	@ApiModelProperty(required = true, allowEmptyValue = false, notes = "A maximum of 100 events can be sent")
	private ArrayList<EventNotification> eventNotifications;

	public WebhooksEvent() {
		super();
	}

	public ArrayList<EventNotification> getEventNotifications() {
		return eventNotifications;
	}

	public void setEventNotifications(ArrayList<EventNotification> eventNotifications) {
		this.eventNotifications = eventNotifications;
	}
	
}
