package org.bonobo.webhooks.data.player;

import java.io.Serializable;

import org.bonobo.webhooks.data.DataChangeEvent;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@ApiModel(description="Triggered when a player withdraws", parent = PlayerEvent.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerWithdrawEvent extends PlayerEvent implements Serializable {

	private static final long serialVersionUID = -5350406473200017337L;

	@NotNull(message = "Order ID must be provided")
	@ApiModelProperty(value = "the order id", example = "1233", required = true)
	private String orderId;
	
	@NotNull(message = "Amount must be provided")
	@DecimalMin(value = "0.01")
	@ApiModelProperty(value = "the withdrawn amount, with 2 decimals", example = "10.34", required = true)
	private Double amount;
	
	@NotNull(message = "Amount must be provided")
	@DecimalMin(value = "0.01")
	@ApiModelProperty(value = "the updated balance, with 2 decimals", example = "100.32", required = true)
	private Double balance;
	
	@NotNull(message = "Currency must be provided")
	@Size(min = 3, max = 3, message = "Currency must be a ISO-3 letter code")
	@ApiModelProperty(value = "the currency", example = "USD", required = true, notes = "Currency must be the ISO-3 code")
	private String currency;
	
	@Override
	public String getCategory() {
		return DataChangeEvent.TYPE_PLAYER_WITHDRAW;
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
