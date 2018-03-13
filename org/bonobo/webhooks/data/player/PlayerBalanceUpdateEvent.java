package org.bonobo.webhooks.data.player;

import java.io.Serializable;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Triggered when a player balance is updated", parent = PlayerEvent.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerBalanceUpdateEvent extends PlayerEvent implements Serializable {

	private static final long serialVersionUID = 1408048049884000596L;

	@NotNull(message = "Balance must be provided")
	@DecimalMin(value = "0.01", message = "Balance must be greater than zero")
	@ApiModelProperty(value = "the actual balance", example = "10.34", required = true)
	private Double balance;
	
	@NotNull(message = "Currency must be provided")
	@Size(min = 3, max = 3, message = "Currency must be a 3 letter code")
	@ApiModelProperty(value = "the currency", example = "USD", required = true, notes = "Currency must be the ISO-3 code")
	private String currency;
	
	@Override
	@ApiModelProperty(value = "the event type", allowableValues = "103", required = true)
	public String getCategory() {
		return PlayerEvent.TYPE_PLAYER_BALANCE;
	}

	public PlayerBalanceUpdateEvent() {
		super();
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

}
