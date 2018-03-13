package org.bonobo.webhooks.data;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.bonobo.webhooks.data.agent.AgentEvent;
import org.bonobo.webhooks.data.game.GameEvent;
import org.bonobo.webhooks.data.player.PlayerEvent;
import org.bonobo.webhooks.data.user.UserEvent;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "category", include = JsonTypeInfo.As.EXISTING_PROPERTY)
@JsonSubTypes({
    @JsonSubTypes.Type(value = PlayerEvent.class, name = "100"),
    @JsonSubTypes.Type(value = UserEvent.class, name = "200"),
    @JsonSubTypes.Type(value = AgentEvent.class, name = "300"),
    @JsonSubTypes.Type(value = GameEvent.class, name = "400")}
)
@ApiModel(description = "Core class for an actual event", discriminator = "category", 
	subTypes = { PlayerEvent.class, GameEvent.class, UserEvent.class, AgentEvent.class })
public abstract class DataChangeEvent implements Serializable {
	
	private static final long serialVersionUID = 171287623675912593L;
	
	public static final String CATEGORY_PLAYER = "100";
	public static final String CATEGORY_USER = "200";
	public static final String CATEGORY_AGENT = "300";
	public static final String CATEGORY_GAME = "400";
	
	public static final String TYPE_PLAYER_CREATE = "101";
	public static final String TYPE_PLAYER_UPDATE = "102";
	public static final String TYPE_PLAYER_BALANCE = "103";
	public static final String TYPE_PLAYER_STATUS = "104";
	public static final String TYPE_PLAYER_DEPOSIT = "105";
	public static final String TYPE_PLAYER_WITHDRAW = "106";
	
	public static final String TYPE_USER_CREATE = "201";
	
	public static final String TYPE_AGENT_CREATE = "301";
	
	public static final String TYPE_GAME_STATUS = "401";
	public static final String TYPE_GAME_RESCHEDULE = "402";
	
	@NotNull
	@ApiModelProperty(value = "the event id", required = true, example = "00112233-4455-6677-8899-aabbccddeeff")
	private String eventId;
	
	@JsonIgnore
	@ApiModelProperty(value = "the company id", notes = "internal use only, does not serialize over the wire")
	private Long memberId;
	
	@ApiModelProperty(required = true, allowableValues = "100,101,102,103,104,105,106,200,201,300,301,400,401", example = "101")
	public abstract String getCategory();

	public DataChangeEvent() {
		super();
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}	
	
}