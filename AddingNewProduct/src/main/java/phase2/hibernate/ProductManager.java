package phase2.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class ProductManager {
	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;
 
	public ProductManager() {
		setup();
	}
	
    protected void setup() {
    	try {
            // Creating a registry
            registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

            // Create the MetadataSources
            MetadataSources sources = new MetadataSources(registry);

            // Create the Metadata
            Metadata metadata = sources.getMetadataBuilder().build();

            // Create SessionFactory
            sessionFactory = metadata.getSessionFactoryBuilder().build();

          } catch (Exception e) {
            e.printStackTrace();
            if (registry != null) {
              StandardServiceRegistryBuilder.destroy(registry);
            }
          }
    }
 
    protected void exit() {
        // code to close Hibernate Session factory
    	sessionFactory.close();
    }
 
    protected boolean add(String name, String details) {
        Product product = new Product();
        if (name == null || details == null || name.equals("") || details.equals("")) {
        	return false;
        }
        product.setName(name);
        product.setDetails(details);
        
        Session session = sessionFactory.openSession();
        session.beginTransaction();
     
        session.save(product);
     
        session.getTransaction().commit();
        session.close();
        return true;
    }
 
    protected void read(long id) {
        // get a product by Id
    	Session session = sessionFactory.openSession();
    	long hid = 1;
        Product product = session.get(Product.class, id);
     
        System.out.println(product.toString());
     
        session.close();
    }
    
    protected List<Product> getProducts() {
    	Session session = sessionFactory.openSession();
    	String hql = "FROM product_tbl";
    	Query query = session.createQuery(hql, Product.class);
    	List results = query.list();
    	session.close();
    	return results;
    }
}