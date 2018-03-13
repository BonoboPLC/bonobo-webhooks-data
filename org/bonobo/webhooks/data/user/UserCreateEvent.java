package org.bonobo.webhooks.data.user;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.bonobo.webhooks.data.DataChangeEvent;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Triggered when a user is created", parent = UserEvent.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserCreateEvent extends UserEvent implements Serializable  {

	private static final long serialVersionUID = 5386330348898183332L;

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
		
	public UserCreateEvent() {
		super();
	}

	@Override
	@ApiModelProperty(value = "the event type", required = true)
	public String getCategory() {
		return DataChangeEvent.TYPE_USER_CREATE;
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

}
