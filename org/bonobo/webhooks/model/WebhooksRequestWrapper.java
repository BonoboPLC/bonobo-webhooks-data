package org.bonobo.webhooks.model;

import org.bonobo.webhooks.data.WebhooksEvent;

import io.swagger.annotations.ApiModel;

@ApiModel(description="Core wrapper for the request")
public class WebhooksRequestWrapper extends RequestWrapper<WebhooksEvent> {

	private static final long serialVersionUID = -6335850721890508367L;

	WebhooksRequestWrapper() {
    }

    public WebhooksRequestWrapper(WebhooksEvent data) {
        super(data);
    }
}
