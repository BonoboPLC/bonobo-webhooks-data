package org.bonobo.webhooks.model;

import org.bonobo.webhooks.data.WebhooksEventResponse;

public class WebhooksResponseWrapper extends AbstractResponseWrapper<WebhooksEventResponse> {

    public WebhooksResponseWrapper() {
    }

    public WebhooksResponseWrapper(WebhooksEventResponse data) {
        super(data);
    }
}
