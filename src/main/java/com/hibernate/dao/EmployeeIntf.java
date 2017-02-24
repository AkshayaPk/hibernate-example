package com.hibernate.dao;

import java.util.List;

import com.hibernate.model.Employee;

public interface EmployeeIntf {

	void save(Employee employee);

	void update(Employee employee);

	void delete(Employee employee);

	List<Employee> list();

}