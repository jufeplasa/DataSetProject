package model;

import java.io.Serializable;

public class Person implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private String lastName;
	private String gender;
	private String dateOfBirth;
	private double height;
	private String nacionality;
	private String profilePhoto;
	
	
	public Person(String name, String lastName, String gender, String dateOfBirth, double height, String nacionality, String profilePhoto) {
		this.name = name;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.height = height;
		this.nacionality = nacionality;
		this.profilePhoto = profilePhoto;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public double getHeight() {
		return height;
	}


	public void setHeight(double height) {
		this.height = height;
	}


	public String getNacionality() {
		return nacionality;
	}


	public void setNacionality(String nacionality) {
		this.nacionality = nacionality;
	}


	public String getProfilePhoto() {
		return profilePhoto;
	}


	public void setProfilePhoto(String profilePhoto) {
		this.profilePhoto = profilePhoto;
	}
}
