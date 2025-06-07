package org.bonobo.webhooks.data.game;

import java.io.Serializable;

import org.bonobo.webhooks.data.DataChangeEvent;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotNull;

@ApiModel(description="Triggered when a game must be rescheduled", parent = GameEvent.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GameRescheduleEvent extends GameEvent implements Serializable {

	private static final long serialVersionUID = 3486540224563097839L;
	
	@NotNull(message = "The Start Time in Milliseconds since Epoch (Eastern Standard Time)")
	@ApiModelProperty(value = "the new start time in Milliseconds since Epoch", example = "1520865663796", required = true)
	private Long startTime;
	
	@ApiModelProperty(value = "the new end time in Milliseconds since Epoch", example = "1520865663796", required = false)
	private Long endTime;
	
	@ApiModelProperty(value = "The number of times to repeat the tournament", example = "-1", required = false)
	private Integer repeatCount;

	@ApiModelProperty(value = "The number of milliseconds to pause between the repeat firing", example = "3600000", required = false)
	private Long repeatInterval;
	
	@ApiModelProperty(value = "The cron expression, please use http://www.cronmaker.com as an example on how to build it", example = "0 0 12 1/1 * ? *", required = false)
	private String cronEx;
		
	public GameRescheduleEvent() {
		super();
	}

	@Override
	public String getCategory() {
		return DataChangeEvent.TYPE_GAME_RESCHEDULE;
	}

	public Long getStartTime() {
		return startTime;
	}

	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}

	public Long getEndTime() {
		return endTime;
	}

	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}

	public Integer getRepeatCount() {
		return repeatCount;
	}

	public void setRepeatCount(Integer repeatCount) {
		this.repeatCount = repeatCount;
	}

	public Long getRepeatInterval() {
		return repeatInterval;
	}

	public void setRepeatInterval(Long repeatInterval) {
		this.repeatInterval = repeatInterval;
	}

	public String getCronEx() {
		return cronEx;
	}

	public void setCronEx(String cronEx) {
		this.cronEx = cronEx;
	}

}
