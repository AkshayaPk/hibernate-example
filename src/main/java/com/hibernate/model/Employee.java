package com.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
/**
 * 
 * @author Akshay
 *
 */
@Entity
@Table(name="employee_details" , catalog="employee")
public class Employee {
@Id @GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="ID")
	private Integer id;

@Column(name="FIRSTNAME",nullable=false) 

	private String firstName;
@Column(name="LASTNAME",nullable=false) 

	private String lastName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
