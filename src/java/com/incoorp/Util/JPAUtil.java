    package com.incoorp.Util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.*;


public class JPAUtil {
    
        
	
	/*private static final String PERSISTENCE_UNIT_NAME = "PERSISTENCE";
	private static EntityManagerFactory factory;
        
	public static EntityManagerFactory getEntityManagerFactory() {
		if (factory==null) {
			factory=Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		}
		return factory;				
	}
	
	public static void shutdown() {
		if (factory!=null) {
			factory.close();
		}		
	}*/
    
    private static SessionFactory sessionFactory = buildSessionFactory();
    private static ServiceRegistry serviceRegistry;
    private static Session session;

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            configuration = configuration.configure("hibernate.cfg.xml");
            
            serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            return   configuration.buildSessionFactory(serviceRegistry);
        } catch (HibernateException e) {
            System.err.println("Error en el build " + e);
            throw new ExceptionInInitializerError(e.getMessage() + "ERROR DE INICIALIZACION");
        }
    }
    
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
    
    public static Session getCurrrentSession(){
        return sessionFactory.getCurrentSession();
    }
    
    public static void close(){
        if(sessionFactory != null){
            sessionFactory.close();
        }
        sessionFactory = null;
    }
    
    public static Session openSession(){
        return sessionFactory.openSession();
    }
    
    

}
