package phase2.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class ProductManager {
	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;
 
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
 
    protected void create() {
        // code to save a book
    }
 
    protected void read(long id) {
        // code to get a book
    	Session session = sessionFactory.openSession();
    	long hid = 1;
        Product product = session.get(Product.class, id);
     
        System.out.println(product.toString());
     
        session.close();
    }
 
    protected void update() {
        // code to modify a book
    }
 
    protected void delete() {
        // code to remove a book
    }
 
    public static void main(String[] args) {
        // code to run the program
    	ProductManager manager = new ProductManager();
        manager.setup();
        manager.read(2);
        if (manager.sessionFactory == null) {
        	System.out.println("sessionfactory is null");
        }
     
    }
}