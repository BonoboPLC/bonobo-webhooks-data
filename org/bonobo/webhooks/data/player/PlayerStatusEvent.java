package org.bonobo.webhooks.data.player;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Triggered when a player account status is changed", parent = PlayerEvent.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerStatusEvent extends PlayerEvent implements Serializable  {

	private static final long serialVersionUID = -984190290966101222L;
	
	@NotNull(message = "Enabled must be provided")
	@ApiModelProperty(value = "the account status", example = "true", required = true, allowableValues="true,false", 
			notes = "This can be used when a player is banned/disabled")
	private boolean enabled;
	
	@Override
	public String getCategory() {
		return PlayerEvent.TYPE_PLAYER_STATUS;
	}

	public PlayerStatusEvent() {
		super();
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}
