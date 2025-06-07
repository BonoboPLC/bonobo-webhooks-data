package org.bonobo.webhooks.data.game;

import org.bonobo.webhooks.data.DataChangeEvent;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "category", include = JsonTypeInfo.As.EXISTING_PROPERTY)
@JsonSubTypes({
    @JsonSubTypes.Type(value = GameStatusEvent.class, name = "401"),
    @JsonSubTypes.Type(value = GameRescheduleEvent.class, name = "402")}
)
@ApiModel(description = "Base class for a game event", discriminator = "category", 
	subTypes = { GameStatusEvent.class, GameRescheduleEvent.class }, 
	parent = DataChangeEvent.class
)
public abstract class GameEvent extends DataChangeEvent {

	private static final long serialVersionUID = -8359851916578634669L;

	@NotNull(message = "Game ID must be provided")
	@ApiModelProperty(value = "the game definition id", example = "1234", required = true)
	private Long gameId;
	
	@NotNull(message = "Game Instance ID must be provided")
	@ApiModelProperty(value = "the game instance id", example = "43444444", required = true)
	private Long gameInstanceId;
		
	//TODO game title and icon
	
	public GameEvent() {
		super();
	}

	@Override
	public String getCategory() {
		return DataChangeEvent.CATEGORY_GAME;
	}

	public Long getGameId() {
		return gameId;
	}

	public void setGameId(Long gameId) {
		this.gameId = gameId;
	}

	public Long getGameInstanceId() {
		return gameInstanceId;
	}

	public void setGameInstanceId(Long gameInstanceId) {
		this.gameInstanceId = gameInstanceId;
	}

}
