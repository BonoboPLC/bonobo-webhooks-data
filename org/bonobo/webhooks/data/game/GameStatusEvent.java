package org.bonobo.webhooks.data.game;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.bonobo.webhooks.data.DataChangeEvent;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Triggered when a game is started or stopped", parent = GameEvent.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GameStatusEvent extends GameEvent implements Serializable {

	private static final long serialVersionUID = 3486540224563097839L;
	
	@NotNull(message = "Action must be provided")
	@ApiModelProperty(value = "the action", example = "GAME_START", required = true, 
		allowableValues = "GAME_START,GAME_STOP,INSTANCE_STARTED,INSTANCE_ENDED,INSTANCE_FAILED,INSTANCE_STOPPED,INSTANCE_REFUNDED,INSTANCE_RESCHEDULED")
	private String action;
	
	public GameStatusEvent() {
		super();
	}

	@Override
	public String getCategory() {
		return DataChangeEvent.TYPE_GAME_STATUS;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

}
