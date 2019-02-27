package com.ecomm.test;
import static org.junit.Assert.*;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.ecomm.model.Supplier;
import com.ecomm.dao.SupplierDAO;

public class SupplierDAOUnitTest 
{
	static SupplierDAO supplierDAO;

	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		
		supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
	}

	//@Ignore
	@Test
	public void addSupplierTest()
	{
		Supplier supplier=new Supplier();
		supplier.setSupplierName("google");
		supplier.setSupplierDesc("ceo of google is : sundar and is present since 1995");
		assertTrue("Problem in adding the Category ",supplierDAO.addSupplier(supplier));
	}
	
	@Ignore
	@Test
	public void getSupplierTest()
	{
		assertNotNull("Problem in get Category",supplierDAO.getSupplier(52));
	}
	
	@Ignore
	@Test
	public void deleteCategoryTest()
	{
		Supplier supplier=supplierDAO.getSupplier(54);
		assertTrue("Problem in Deletion:",supplierDAO.deleteSupplier(supplier));
	}
    
	 @Ignore
     @Test
	public void updateCategoryTest()
	{
		Supplier supplier=supplierDAO.getSupplier(52);
		supplier.setSupplierName("Reliance Industries");
		assertTrue("Problem in Updation",supplierDAO.updateSupplier(supplier));
	}
    
	
	@Test
	public void listCategoriesTest()
	{
		List<Supplier> listSuppliers=supplierDAO.listSuppliers();
		assertNotNull("No Categories",listSuppliers);
		
		for(Supplier supplier:listSuppliers)
		{
			System.out.print(supplier.getId()+":::");
			System.out.print(supplier.getSupplierName()+":::");
			System.out.println(supplier.getSupplierDesc());
		}
	}
	
}