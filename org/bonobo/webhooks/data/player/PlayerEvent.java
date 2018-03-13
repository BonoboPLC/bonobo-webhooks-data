package org.bonobo.webhooks.data.player;

import javax.validation.constraints.NotNull;

import org.bonobo.webhooks.data.DataChangeEvent;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "category", include = JsonTypeInfo.As.EXISTING_PROPERTY)
@JsonSubTypes({
    @JsonSubTypes.Type(value = PlayerCreateEvent.class, name = "101"),
    @JsonSubTypes.Type(value = PlayerUpdateEvent.class, name = "102"),
    @JsonSubTypes.Type(value = PlayerBalanceUpdateEvent.class, name = "103"),
    @JsonSubTypes.Type(value = PlayerStatusEvent.class, name = "104"),
    @JsonSubTypes.Type(value = PlayerDepositEvent.class, name = "105"),
    @JsonSubTypes.Type(value = PlayerWithdrawEvent.class, name = "106")}
)
@ApiModel(description = "Base class for a player event", discriminator = "category", 
	subTypes = {PlayerCreateEvent.class, PlayerUpdateEvent.class, PlayerStatusEvent.class, PlayerBalanceUpdateEvent.class}, 
	parent = DataChangeEvent.class
)
public abstract class PlayerEvent extends DataChangeEvent {

	private static final long serialVersionUID = -8853606317753457603L;
	
	@NotNull
	@ApiModelProperty(value = "the player id", example = "1234", required = true)
	private Long id;
	
	public PlayerEvent() {
		super();
	}

	@Override
	@ApiModelProperty(value = "the event type", required = true)
	public String getCategory() {
		return CATEGORY_PLAYER;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
