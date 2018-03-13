package org.bonobo.webhooks.data.user;

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
	subTypes = { UserCreateEvent.class }, 
	parent = DataChangeEvent.class
)
public class UserEvent extends DataChangeEvent {

	private static final long serialVersionUID = 1565994367552758025L;
	
	@NotNull
	@ApiModelProperty(value = "the user id", example = "1234", required = true)
	private Long id;
	
	@Override
	@ApiModelProperty(value = "the event type", required = true)
	public String getCategory() {
		return DataChangeEvent.CATEGORY_USER;
	}

}
