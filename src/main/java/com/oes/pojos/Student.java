package com.oes.pojos;

public class Student {
	
	private String firstName;
	private String lastName;
	private String qualification;
	private int mobile;
	private String email;
	private String password;
	
	public Student(String firstName, String lastName, String qualification, int mobile, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.qualification = qualification;
		this.mobile = mobile;
		this.email = email;
		this.password = password;
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

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", qualification=" + qualification
				+ ", mobile=" + mobile + ", email=" + email + ", password=" + password + "]";
	}	

}
