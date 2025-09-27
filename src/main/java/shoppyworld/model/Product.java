package shoppyworld.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String product_owner_email;
	
	private String product_owner_name;
	
	private String product_owner_contact;
	
	private String product_name;
	
	private String product_price;
	
	private String product_category;
	
	private String product_details;
	
	private String product_status;
	
	private int discount;
	
	private int quantity;
	
	private String size;
	
	private String p_i_path;
	
	private String p_i_name;
	
	private String product_order;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int id, String product_owner_email, String product_owner_name, String product_owner_contact,
			String product_name, String product_price, String product_category, String product_details,
			String product_status, int discount, int quantity, String size, String p_i_path, String p_i_name,
			String product_order) {
		super();
		this.id = id;
		this.product_owner_email = product_owner_email;
		this.product_owner_name = product_owner_name;
		this.product_owner_contact = product_owner_contact;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_category = product_category;
		this.product_details = product_details;
		this.product_status = product_status;
		this.discount = discount;
		this.quantity = quantity;
		this.size = size;
		this.p_i_path = p_i_path;
		this.p_i_name = p_i_name;
		this.product_order = product_order;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProduct_owner_email() {
		return product_owner_email;
	}

	public void setProduct_owner_email(String product_owner_email) {
		this.product_owner_email = product_owner_email;
	}

	public String getProduct_owner_name() {
		return product_owner_name;
	}

	public void setProduct_owner_name(String product_owner_name) {
		this.product_owner_name = product_owner_name;
	}

	public String getProduct_owner_contact() {
		return product_owner_contact;
	}

	public void setProduct_owner_contact(String product_owner_contact) {
		this.product_owner_contact = product_owner_contact;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_price() {
		return product_price;
	}

	public void setProduct_price(String product_price) {
		this.product_price = product_price;
	}

	public String getProduct_category() {
		return product_category;
	}

	public void setProduct_category(String product_category) {
		this.product_category = product_category;
	}

	public String getProduct_details() {
		return product_details;
	}

	public void setProduct_details(String product_details) {
		this.product_details = product_details;
	}

	public String getProduct_status() {
		return product_status;
	}

	public void setProduct_status(String product_status) {
		this.product_status = product_status;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getP_i_path() {
		return p_i_path;
	}

	public void setP_i_path(String p_i_path) {
		this.p_i_path = p_i_path;
	}

	public String getP_i_name() {
		return p_i_name;
	}

	public void setP_i_name(String p_i_name) {
		this.p_i_name = p_i_name;
	}

	public String getProduct_order() {
		return product_order;
	}

	public void setProduct_order(String product_order) {
		this.product_order = product_order;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", product_owner_email=" + product_owner_email + ", product_owner_name="
				+ product_owner_name + ", product_owner_contact=" + product_owner_contact + ", product_name="
				+ product_name + ", product_price=" + product_price + ", product_category=" + product_category
				+ ", product_details=" + product_details + ", product_status=" + product_status + ", discount="
				+ discount + ", quantity=" + quantity + ", size=" + size + ", p_i_path=" + p_i_path + ", p_i_name="
				+ p_i_name + ", product_order=" + product_order + "]";
	}

}
