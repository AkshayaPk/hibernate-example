package com.hibernate.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.hibernate.model.Employee;

public class TestEmployeeDAO {

public static void main(String[] args) {
    EmployeeDAO dao=new EmployeeDAO();
    Employee employee=new Employee();
//    employee.setId(5);
    employee.setFirstName("");
    employee.setLastName("a");
    dao.save(employee);
//    dao.update(employee);
//    dao.delete(employee);
    List<Employee> list=dao.list();
    System.out.println(list);
}
}
