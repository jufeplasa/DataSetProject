package model;

import java.io.Serializable;

public class Person implements Comparable<Person>, Serializable {
	
	private static final long serialVersionUID = 1L;
	private String code;
	private String name;
	private String lastName;
	private String fullName;
	private String gender;
	private String dateOfBirth;
	private int age;
	private double height;
	private String nacionality;
	private String profilePhoto;
	private String comparatorValue;

	public Person(String name, String lastName,int age,String dateOfBirth,String profilePhoto, String nacionality, double height, String code) {
		this.name = name;
		this.lastName = lastName;
		this.setAge(age);
		this.dateOfBirth = dateOfBirth;
		this.profilePhoto = profilePhoto;
		this.nacionality = nacionality;
		this.height = height;
		this.code=code;
		fullName=name+" "+lastName;
	}

	public Person (String name, String lastName) {
		this.name = name;
		this.lastName = lastName;
	}

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


	public String getFullName() {
		return fullName;
	}


	public void setFullName() {
		fullName =name+" "+lastName; 
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
	
	public String toString() {
		return getComparatorValue();
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getComparatorValue() {
		return comparatorValue;
	}

	public void setComparatorValue(String comparatorValue) {
		this.comparatorValue = comparatorValue;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
