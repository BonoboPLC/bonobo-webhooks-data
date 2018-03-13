package org.bonobo.webhooks.data.player;

import java.io.Serializable;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.bonobo.webhooks.data.DataChangeEvent;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Triggered when a player deposits", parent = PlayerEvent.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerDepositEvent extends PlayerEvent implements Serializable  {

	private static final long serialVersionUID = 5717753410860363022L;

	@NotNull(message = "Order ID must be provided")
	@ApiModelProperty(value = "the order id", example = "1233", required = true)
	private String orderId;
	
	@NotNull(message = "Amount must be provided")
	@DecimalMin(value = "0.01")
	@ApiModelProperty(value = "the deposit amount", example = "10.34", required = true)
	private Double amount;
	
	@NotNull(message = "Amount must be provided")
	@DecimalMin(value = "0.01")
	@ApiModelProperty(value = "the updated balance", example = "100.32", required = true)
	private Double balance;
	
	@NotNull(message = "Currency must be provided")
	@Size(min = 3, max = 3, message = "Currency must be a 3 letter code")
	@ApiModelProperty(value = "the currency", example = "USD", required = true, notes = "Currency must be the ISO-3 code")
	private String currency;

	@Override
	public String getCategory() {
		return DataChangeEvent.TYPE_PLAYER_DEPOSIT;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
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

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

}
