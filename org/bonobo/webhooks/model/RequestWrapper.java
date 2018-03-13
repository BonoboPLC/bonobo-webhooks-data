package org.bonobo.webhooks.model;

import java.io.Serializable;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Wrapper for the actual request", subTypes = {WebhooksRequestWrapper.class})
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RequestWrapper<WebhooksEvent> implements Serializable {

	private static final long serialVersionUID = 3429509192157957739L;

	@JsonIgnore
    @ApiModelProperty(hidden = true)
    String raw;

    @Valid
    @ApiModelProperty(required = true)
    WebhooksEvent data;

    public RequestWrapper() {
    }

    public RequestWrapper(WebhooksEvent data) {
        this.data = data;
    }

    public WebhooksEvent getData() {
        return data;
    }

    public void setData(WebhooksEvent data) {
        this.data = data;
    }

    public String getRaw() {
        return raw;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"data\": ").append(data);
        sb.append('}');
        return sb.toString();
    }
}
