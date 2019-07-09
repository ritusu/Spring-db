package com.lti.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.component.CarPart;
import com.lti.component.CarPartsInventory;
import com.lti.component.CarPartsInventoryImpl3;


public class CarPartsTest {

	@Test
	public void add() {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		
		CarPartsInventory cpi=(CarPartsInventory)context.getBean("carPartsImpl3");
		
		CarPart c=new CarPart();
	
		//CarPart c = (CarPart)context.getBean("c");
	
		c.setPartNo(141);
		c.setPartName("wheel");
		c.setCarModel("pista");
		c.setQuantity(116);
		
		cpi.addNewPart(c);
	}
	
	@Test
	public void testCarFetch() {
		
	ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		
		CarPartsInventory cpi=(CarPartsInventory)context.getBean("carPartsImpl4");

		  List<CarPart> list=  cpi.getAvailableParts();
		  for(CarPart c:list) {
		    	System.out.println(c.getPartNo()+" "+c.getPartName()+" "+c.getCarModel()+" "+c.getQuantity()); 	
		    }
}
}
	
