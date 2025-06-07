package org.bonobo.webhooks.data.agent;

import java.io.Serializable;

import org.bonobo.webhooks.data.DataChangeEvent;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@ApiModel(description="Triggered when an agent is created", parent = AgentEvent.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AgentCreateEvent extends AgentEvent implements Serializable {

	private static final long serialVersionUID = 5252307935135652324L;

	@NotNull(message = "Username must be provided")
	@ApiModelProperty(value = "the username", example = "test1234", required = true)
	private String username;
	
	@NotNull(message = "Password must be provided")
	@ApiModelProperty(value = "the password", example = "$2a$10$9EEhIHdAZ42lZw0xy8sA8uqGyGJPlD8ZPBDRumKDPx6b/fFamfGpi", required = true, 
		notes = "Password must be encoded using bcrypt hashing algorithm")
	private String password;

	@NotNull(message = "Email must be provided")
	@Email(message = "Not a valid email address")
	@ApiModelProperty(value = "the email address", example = "test1234@lottorace.com", required = true)
	private String email;
	
	@NotNull(message = "Phone must be provided")
	@ApiModelProperty(value = "the phone number", example = "416-233-333", required = true)
	private String phone;
	
	@NotNull(message = "First Name must be provided")
	@ApiModelProperty(value = "the first name", example = "John", required = true)
	private String firstName;
	
	@NotNull(message = "Last Name must be provided")
	@ApiModelProperty(value = "the last name", example = "Doe", required = true)
	private String lastName;
	
	@NotNull(message = "Birthdate must be provided")
	@ApiModelProperty(value = "the birthdate", example = "1980-08-11", required = true, notes = "Birthdate must resolve to 18+")
	private String birthdate;
	
	@NotNull(message = "Gender must be provided")
	@Size(min = 1, max = 1, message = "Gender must be either M or F")
	@ApiModelProperty(value = "the gender", example = "M", required = true, allowableValues = "M,F")
	private String gender;
	
	@NotNull(message = "Street must be provided")
	@ApiModelProperty(value = "the street address", example = "123 Cool Street", required = true)
	private String addressStreet;
	
	@NotNull(message = "City must be provided")
	@ApiModelProperty(value = "the city", example = "Toronto", required = true)
	private String addressCity;
	
	@NotNull(message = "State/Province must be provided")
	@ApiModelProperty(value = "the state/province", example = "Ontario", required = true)
	private String addressState;
	
	@NotNull(message = "Postal Code/Zip must be provided")
	@ApiModelProperty(value = "the postal/zip code", example = "M4P4B9", required = true)
	private String addressPostalcode;
	
	@NotNull(message = "Country must be provided")
	@Size(min = 2, max = 2, message = "Country must be 2 letters")
	@ApiModelProperty(value = "the country", example = "CA", required = true, 
		notes = "Country must be provided in ISO-2 mode")
	private String addressCountry;

	@NotNull
	@DecimalMin(value = "0")
	@ApiModelProperty(value = "the deposit limit imposed to this agent", example = "1000.00", required = true)
	private Double depositReceiptLimit;
	
	@NotNull
	@DecimalMin(value = "0")
	@ApiModelProperty(value = "the sales receipt limit imposed to this agent", example = "1000.00", required = true)
	private Double salesReceiptLimit;
	
	@NotNull
	@DecimalMin(value = "0")
	@ApiModelProperty(value = "the prize payout limit imposed to this agent", example = "1000.00", required = true)
	private Double prizePayoutLimit;
	
	@NotNull
	@DecimalMin(value = "0")
	@ApiModelProperty(value = "the commission percentage to this agent will receive", example = "0.10", required = true, 
		notes = "Percentage must be sent as a decimal (i.e 10% is 0.10)")
	private Double commissionPercentage;
	
	@NotNull
	@ApiModelProperty(value = "whether this agent can create agents under his supervision", example = "true", required = true, allowableValues = "true,false")
	private boolean subAgentsEnabled;
	
	@NotNull
	@ApiModelProperty(value = "whether this agent can process withdrawals", example = "true", required = true, allowableValues = "true,false")
	private boolean processWithdrawalsEnabled;
	
	@NotNull
	@ApiModelProperty(value = "whether this agent can process deposits", example = "true", required = true, allowableValues = "true,false")
	private boolean processDepositsEnabled;
	
	public AgentCreateEvent() {
		super();
	}

	@Override
	@ApiModelProperty(value = "the event type", required = true)
	public String getCategory() {
		return DataChangeEvent.TYPE_AGENT_CREATE;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddressStreet() {
		return addressStreet;
	}

	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	}

	public String getAddressCity() {
		return addressCity;
	}

	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}

	public String getAddressState() {
		return addressState;
	}

	public void setAddressState(String addressState) {
		this.addressState = addressState;
	}

	public String getAddressPostalcode() {
		return addressPostalcode;
	}

	public void setAddressPostalcode(String addressPostalcode) {
		this.addressPostalcode = addressPostalcode;
	}

	public String getAddressCountry() {
		return addressCountry;
	}

	public void setAddressCountry(String addressCountry) {
		this.addressCountry = addressCountry;
	}

	public Double getDepositReceiptLimit() {
		return depositReceiptLimit;
	}

	public void setDepositReceiptLimit(Double depositReceiptLimit) {
		this.depositReceiptLimit = depositReceiptLimit;
	}

	public Double getSalesReceiptLimit() {
		return salesReceiptLimit;
	}

	public void setSalesReceiptLimit(Double salesReceiptLimit) {
		this.salesReceiptLimit = salesReceiptLimit;
	}

	public Double getPrizePayoutLimit() {
		return prizePayoutLimit;
	}

	public void setPrizePayoutLimit(Double prizePayoutLimit) {
		this.prizePayoutLimit = prizePayoutLimit;
	}

	public Double getCommissionPercentage() {
		return commissionPercentage;
	}

	public void setCommissionPercentage(Double commissionPercentage) {
		this.commissionPercentage = commissionPercentage;
	}

	public boolean isSubAgentsEnabled() {
		return subAgentsEnabled;
	}

	public void setSubAgentsEnabled(boolean subAgentsEnabled) {
		this.subAgentsEnabled = subAgentsEnabled;
	}

	public boolean isProcessWithdrawalsEnabled() {
		return processWithdrawalsEnabled;
	}

	public void setProcessWithdrawalsEnabled(boolean processWithdrawalsEnabled) {
		this.processWithdrawalsEnabled = processWithdrawalsEnabled;
	}

	public boolean isProcessDepositsEnabled() {
		return processDepositsEnabled;
	}

	public void setProcessDepositsEnabled(boolean processDepositsEnabled) {
		this.processDepositsEnabled = processDepositsEnabled;
	}
	
}
