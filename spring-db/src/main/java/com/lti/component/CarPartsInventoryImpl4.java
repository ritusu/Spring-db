package com.lti.component;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;



@Component("carPartsImpl4")
//this is done using hibernate and also spring is used for creating objects of entity manager and entity manager factory
//spring also helps us by pom.xml file elimination.


public class CarPartsInventoryImpl4 implements CarPartsInventory{


	//this time we are injecting EntityManager
	//object required when using JPA
	//@Autowired doesnt work for injecting the same
	//we use @Persistence context for annotation
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional//this line will automatically write begin and commit line we used to write in hibernate
	public void addNewPart(CarPart carPart) {
		entityManager.persist(carPart);
		}	
	
	public List<CarPart> getAvailableParts() {
		
		  Query q=entityManager.createQuery("select cp from CarPart cp");
    	List<CarPart> list=q.getResultList();
		return list;
		//return entityManager.createQuery("select cp from CarPart cp");
		}
	
	

}
