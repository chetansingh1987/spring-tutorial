package com.datamanagement.hibernate.dto;

import java.io.Serializable;

//create table employee_table_db(id_db integer primary key , name_db varchar(50) , age_db integer , salary_db integer , address_db varchar(100) )
public class EmployeeDTO implements Serializable{
	public int id;
	public String name ;
	public int age ;
	public int salary ;
	public String address ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
