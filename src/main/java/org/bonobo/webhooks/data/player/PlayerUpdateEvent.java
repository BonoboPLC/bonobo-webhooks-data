package org.bonobo.webhooks.data.player;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

@ApiModel(description="Triggered when a player is updated", parent = PlayerEvent.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerUpdateEvent extends PlayerEvent implements Serializable  {

	private static final long serialVersionUID = -2457008021813026292L;

	@Email(message = "Not a valid email address")
	@ApiModelProperty(value = "the email address", example = "test1234@lottorace.com", required = true)
	private String email;
	
	@ApiModelProperty(value = "the phone number", example = "416-233-333", required = true)
	private String phone;
	
	@ApiModelProperty(value = "the salutation", example = "Mr/Mrs/Ms/Miss/Mx", required = true)
	private String salutation;
	
	@ApiModelProperty(value = "the first name", example = "John", required = true)
	private String firstName;
	
	@ApiModelProperty(value = "the last name", example = "Doe", required = true)
	private String lastName;
	
	@ApiModelProperty(value = "the street address", example = "123 Cool Street", required = true)
	private String addressStreet;
	
	@ApiModelProperty(value = "the city", example = "Toronto", required = true)
	private String addressCity;
	
	@ApiModelProperty(value = "the state/province", example = "Ontario", required = true)
	private String addressState;
	
	@ApiModelProperty(value = "the postal/zip code", example = "M4P4B9", required = true)
	private String addressPostalcode;
	
	@Size(min = 2, max = 2, message = "Country must be 2 letters")
	@ApiModelProperty(value = "the country", example = "CA", required = true, 
		notes = "Country must be provided in ISO-2 mode")
	private String addressCountry;

	@ApiModelProperty(value = "is the address verified?", required = true)
	private boolean addressVerified;
	
	@ApiModelProperty(value = "is the ID verified?", required = true)
	private boolean idVerified;

	@ApiModelProperty(value = "is the email verified?", required = true)
	private boolean emailVerified;
		
	@ApiModelProperty(value = "player activation status", allowableValues = "ACTIVATED, PENDING", required = true)
	private String activationStatus;
	
	@ApiModelProperty(value = "player verification status", allowableValues = "VERIFIED, PENDING, REJECTED", required = true)
	private String verificationStatus;
	
	@ApiModelProperty(value = "player segment", allowableValues = "A1, A, B, C, D, E, F, G", required = true)
	private String playerSegment;
	
	@ApiModelProperty(value = "player class", allowableValues = "FUNDED, NOT_FUNDED", required = true)
	private String playerClass;
	
	@Override
	public String getCategory() {
		return PlayerEvent.TYPE_PLAYER_UPDATE;
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

	public boolean isAddressVerified() {
		return addressVerified;
	}

	public void setAddressVerified(boolean addressVerified) {
		this.addressVerified = addressVerified;
	}

	public boolean isIdVerified() {
		return idVerified;
	}

	public void setIdVerified(boolean idVerified) {
		this.idVerified = idVerified;
	}

	public boolean isEmailVerified() {
		return emailVerified;
	}

	public void setEmailVerified(boolean emailVerified) {
		this.emailVerified = emailVerified;
	}

	public String getActivationStatus() {
		return activationStatus;
	}

	public void setActivationStatus(String activationStatus) {
		this.activationStatus = activationStatus;
	}

	public String getVerificationStatus() {
		return verificationStatus;
	}

	public void setVerificationStatus(String verificationStatus) {
		this.verificationStatus = verificationStatus;
	}

	public String getPlayerSegment() {
		return playerSegment;
	}

	public void setPlayerSegment(String playerSegment) {
		this.playerSegment = playerSegment;
	}

	public String getPlayerClass() {
		return playerClass;
	}

	public void setPlayerClass(String playerClass) {
		this.playerClass = playerClass;
	}

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PlayerUpdateEvent [email=");
		builder.append(email);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", addressStreet=");
		builder.append(addressStreet);
		builder.append(", addressCity=");
		builder.append(addressCity);
		builder.append(", addressState=");
		builder.append(addressState);
		builder.append(", addressPostalcode=");
		builder.append(addressPostalcode);
		builder.append(", addressCountry=");
		builder.append(addressCountry);
		builder.append(", getId()=");
		builder.append(getId());
		builder.append(", getEventId()=");
		builder.append(getEventId());
		builder.append(", getMemberId()=");
		builder.append(getMemberId());
		builder.append("]");
		return builder.toString();
	}

}
