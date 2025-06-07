package com.bo;

public class Student 
{
	private int RollNo;
	private String name;
	private String password;
	private String contactno;
	private String email;
	private String birthdate;
	private String city;
	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String name, String password, String contactno, String email, String birthdate, String city) {
		super();
		this.name = name;
		this.password = password;
		this.contactno = contactno;
		this.email = email;
		this.birthdate = birthdate;
		this.city = city;
	}
	
	
	
	public Student(int rollNo, String name, String password, String contactno, String email, String birthdate,
			String city) {
		super();
		RollNo = rollNo;
		this.name = name;
		this.password = password;
		this.contactno = contactno;
		this.email = email;
		this.birthdate = birthdate;
		this.city = city;
	}

	public int getRollNo() {
		return RollNo;
	}

	public void setRollNo(int rollNo) {
		RollNo = rollNo;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public String getContactno() {
		return contactno;
	}
	public String getEmail() {
		return email;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public String getCity() {
		return city;
	}
	
	
}
