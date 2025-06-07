package org.bonobo.webhooks.data;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@ApiModel(description = "The wrapper for the event")
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventNotification implements Serializable {

	private static final long serialVersionUID = -8828687422885697751L;

	@NotNull(message = "Site ID must be provided")
	@ApiModelProperty(required = true, allowEmptyValue = false, notes = "Your Site ID", example = "Your Site ID")
	private String realmId;
	
	@Valid
	@NotNull(message = "Event must be provided")
	@ApiModelProperty(required = true, allowEmptyValue = false, notes = "The actual change event you want to affect")
	private DataChangeEvent dataChangeEvent;

	public EventNotification() {
		super();
	}

	public String getRealmId() {
		return realmId;
	}

	public void setRealmId(String realmId) {
		this.realmId = realmId;
	}

	public DataChangeEvent getDataChangeEvent() {
		this.dataChangeEvent.setMemberId(Long.parseLong(realmId));
		return dataChangeEvent;
	}

	public void setDataChangeEvent(DataChangeEvent dataChangeEvent) {
		this.dataChangeEvent = dataChangeEvent;
	}

}