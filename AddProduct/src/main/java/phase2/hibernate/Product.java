package phase2.hibernate;
import javax.persistence.*;

@Entity
@Table(name = "product_tbl")
public class Product {
	private long product_id;
	private String product_name;
	private String product_details;
	
	public Product() {}
	
	public Product(long nid, String nname, String ndetails) {
		this.product_id = nid;
		this.product_name = nname;
		this.product_details = ndetails;
	}
	
	@Id
	@Column(name = "product_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return product_id;
	}
	
	@Column(name = "product_name")
	public String getName() {
		return product_name;
	}
	
	@Column(name = "product_details")
	public String getDetails() {
		return product_details; 
	}
	
	public void setId(long id) {
        this.product_id = id;
    }
	
	public void setName(String nname) {
		this.product_name = nname;
	}
	
	
	public void setDetails(String ndetails) {
		this.product_details = ndetails;
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("id: " + product_id + ", name: " + product_name + ", details: " + product_details);
		return str.toString();
	}
}
