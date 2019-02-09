package com.ecom.Backend;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ecomm.config.DBConfig;

public class test {
	public static void main(String[] arg)
	{
		
		DBConfig db=new DBConfig();
		db.getH2DataSource();
		db.getSessionFactory();
		//db.getHibernateTransactionManager(sf);
		
	}

}
