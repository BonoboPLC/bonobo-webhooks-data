package org.bonobo.webhooks.data;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.util.Assert;

public class WebhooksEventBuilder {

	protected ArrayList<EventNotification> notifications;
			
	public WebhooksEventBuilder() {
		this.notifications = new ArrayList<EventNotification>();
	}

	public WebhooksEventBuilder(DataChangeEvent change) {
		this.notifications = new ArrayList<EventNotification>();
		add(change);
	}
	
	public WebhooksEventBuilder addDataChangeEvent(DataChangeEvent change) {
		add(change);
		return this;
	}
	
	public static WebhooksEventBuilder withPayload(DataChangeEvent change) {
		return new WebhooksEventBuilder(change);
	}
	
	public WebhooksEvent build() 
	{
		Assert.notEmpty(this.notifications, "At least one event must be present");
		
		WebhooksEvent event = new WebhooksEvent();
		event.setEventNotifications(notifications);
		
		return event;
	}
	
	private void add(DataChangeEvent change) {
		Assert.notNull(change, "Event must not be null");
		Assert.notNull(change.getMemberId(), "Site ID must be provided");		
		
		change.setEventId(UUID.randomUUID().toString());
		
		EventNotification n = new EventNotification();
		n.setRealmId(change.getMemberId().toString());
		n.setDataChangeEvent(change);
		
		notifications.add(n);
	}
}
