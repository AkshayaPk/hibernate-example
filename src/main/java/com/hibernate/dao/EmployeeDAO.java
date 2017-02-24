package com.hibernate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.hibernate.model.Employee;

public class EmployeeDAO implements EmployeeIntf {
	private static SessionFactory factory= new AnnotationConfiguration().configure().addPackage("com.hibernate.model").addAnnotatedClass(Employee.class).buildSessionFactory();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hibernate.dao.EmployeeIntf#save(com.hibernate.model.Employee)
	 */
	@Override
	public void save(Employee employee) {
	   

		Session session = factory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		session.save(employee);
		tx.commit();
		session.close();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hibernate.dao.EmployeeIntf#update(com.hibernate.model.Employee)
	 */
	@Override
	public void update(Employee employee) {

		Session session = factory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
        Query query=session.createQuery("Update Employee set firstName=:n where id=:i");
        query.setParameter("n", employee.getFirstName());
        query.setParameter("i",employee.getId());
        query.executeUpdate();
		tx.commit();
		session.close();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hibernate.dao.EmployeeIntf#delete(com.hibernate.model.Employee)
	 */
	@Override
	public void delete(Employee employee) {

		Session session = factory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		Query query = session.createQuery("DELETE from Employee where id=:i");
		query.setParameter("i", employee.getId());
		query.executeUpdate();
		tx.commit();
		session.close();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hibernate.dao.EmployeeIntf#list()
	 */
	@Override
	public List<Employee> list() {

		Session session = factory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		Query query = session.createQuery("FROM Employee");
		List<Employee> list = query.list();
		tx.commit();
		session.close();

		return list;

	}
}
