package org.bonobo.webhooks.data.agent;

import javax.validation.constraints.NotNull;

import org.bonobo.webhooks.data.DataChangeEvent;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "category", include = JsonTypeInfo.As.EXISTING_PROPERTY)
@JsonSubTypes({})
@ApiModel(description = "Base class for an agent event", discriminator = "category", 
	subTypes = { AgentCreateEvent.class }, 
	parent = DataChangeEvent.class
)
public class AgentEvent extends DataChangeEvent {

	private static final long serialVersionUID = -3300250424365678507L;
	
	@NotNull
	@ApiModelProperty(value = "the agent id", example = "1234", required = true)
	private Long id;
	
	@Override
	@ApiModelProperty(value = "the event type", required = true)
	public String getCategory() {
		return DataChangeEvent.CATEGORY_AGENT;
	}

}
