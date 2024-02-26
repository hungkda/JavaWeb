package hung.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import hung.entity.Product;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	private static StandardServiceRegistry standardServiceRegistry;
	static {
		try {
//			Configuration config = new Configuration().configure();
//			ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
//			sessionFactory = config.buildSessionFactory(reg);
			if(sessionFactory == null) {
				standardServiceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
				MetadataSources metadataSources = new MetadataSources(standardServiceRegistry).addAnnotatedClass(Product.class);
				Metadata metadata = metadataSources.getMetadataBuilder().build();
				sessionFactory = metadata.getSessionFactoryBuilder().build();
			}
		}catch(Throwable ex) {
			ex.printStackTrace();
		} 
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}

