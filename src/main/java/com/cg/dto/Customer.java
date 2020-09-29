package com.cg.dto;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;



import com.cg.validations.AadharNumber;
import com.cg.validations.MobileNumber;

@Entity
public class Customer {
	@Id

//	@Min(value = 100000000000L,message="aadhar number  must contain 12 digits ")
//	@Max(value=999999999999L,message="aadhar number must contain only 12 digits")
@AadharNumber
private long aadhar;
@NotEmpty(message="name is required")
private String name;

//@Min(value = 5999999999L,message="mobile number  must contain 10 digits and starting number should be greater than 6")
//@Max(value=9999999999L,message="mobile number must contain only 10 digits")
@MobileNumber
private long contact;
@NotEmpty(message="pan is required")
private String pan;

private Date dateOfBirth;
@NotEmpty(message="address is required")
private String address;
@NotEmpty(message="state is required")
private String state;
@NotEmpty(message="city is required")
private String city;
@NotEmpty(message="country is required")
private String country;
@Min(value = 100000,message="zip code must contain 6 digits")
@Max(value=999999,message="zip code must contain only 6 digits")
private int zipCode;
@NotEmpty(message="gender is required")
private String gender;
public Customer() {
	super();
}
public Customer(long aadhar, String name, long contact, String pan, Date dateOfBirth, String address, String state,
		String city, String country, int zipCode, String gender) {
	super();
	this.aadhar = aadhar;
	this.name = name;
	this.contact = contact;
	this.pan = pan;
	this.dateOfBirth = dateOfBirth;
	this.address = address;
	this.state = state;
	this.city = city;
	this.country = country;
	this.zipCode = zipCode;
	this.gender = gender;
}
public long getAadhar() {
	return aadhar;
}
public void setAadhar(long aadhar) {
	this.aadhar = aadhar;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public long getContact() {
	return contact;
}
public void setContact(long contact) {
	this.contact = contact;
}
public String getPan() {
	return pan;
}
public void setPan(String pan) {
	this.pan = pan;
}
public Date getDateOfBirth() {
	return dateOfBirth;
}
public void setDateOfBirth(Date dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public int getZipCode() {
	return zipCode;
}
public void setZipCode(int zipCode) {
	this.zipCode = zipCode;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}

}
