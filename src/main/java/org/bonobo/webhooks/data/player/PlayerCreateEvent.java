package org.bonobo.webhooks.data.player;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@ApiModel(description="Triggered when a player is created", parent = PlayerEvent.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerCreateEvent extends PlayerEvent implements Serializable  {

	private static final long serialVersionUID = -5497212592074465769L;

	@NotBlank(message = "Username must be provided")
	@ApiModelProperty(value = "the username", example = "test1234", required = true)
	private String username;
	
	@NotBlank(message = "Password must be provided")
	@ApiModelProperty(value = "the password", example = "$2a$10$9EEhIHdAZ42lZw0xy8sA8uqGyGJPlD8ZPBDRumKDPx6b/fFamfGpi", required = true, 
		notes = "Password must be encoded using bcrypt hashing algorithm")
	private String password;

	@Email(message = "Not a valid email address")
	@ApiModelProperty(value = "the email address", example = "test1234@lottorace.com", required = true)
	private String email;
	
	@ApiModelProperty(value = "the phone number", example = "416-233-333", required = true)
	private String phone;
	
	@ApiModelProperty(value = "the first name", example = "John", required = true)
	private String firstName;
	
	@ApiModelProperty(value = "the last name", example = "Doe", required = true)
	private String lastName;
	
	@ApiModelProperty(value = "the birthdate", example = "1980-08-11", required = true, notes = "Birthdate must resolve to 18+")
	private String birthdate;
	
	@Size(min = 1, max = 1, message = "Gender must be either M or F")
	@ApiModelProperty(value = "the gender", example = "M", required = true, allowableValues = "M,F")
	private String gender;
	
	@ApiModelProperty(value = "the street address", example = "123 Cool Street", required = true)
	private String addressStreet;
	
	@ApiModelProperty(value = "the city", example = "Toronto", required = true)
	private String addressCity;
	
	@ApiModelProperty(value = "the state/province", example = "Ontario", required = true)
	private String addressState;
	
	@ApiModelProperty(value = "the postal/zip code", example = "M4P4B9", required = true)
	private String addressPostalcode;
	
	@NotNull(message = "Country must be provided")
	@Size(min = 2, max = 2, message = "Country must be 2 letters")
	@ApiModelProperty(value = "the country", example = "CA", required = true, 
		notes = "Country must be provided in ISO-2 mode")
	private String addressCountry;
	
	@ApiModelProperty(value = "the language id", example = "en_US", required = true)
	private String languageId;
	
	public PlayerCreateEvent() {
		super();
	}

	@Override
	public String getCategory() {
		return PlayerEvent.TYPE_PLAYER_CREATE;
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

	public String getLanguageId() {
		return languageId;
	}

	public void setLanguageId(String languageId) {
		this.languageId = languageId;
	}

}
