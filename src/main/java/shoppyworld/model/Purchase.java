package shoppyworld.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Purchase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int product_id;
	
	private String p_o_email;
	
	private String user_email;
	
	private String purchase_status;
	
	private String address;

	public Purchase() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Purchase(int id, int product_id, String p_o_email, String user_email, String purchase_status,
			String address) {
		super();
		this.id = id;
		this.product_id = product_id;
		this.p_o_email = p_o_email;
		this.user_email = user_email;
		this.purchase_status = purchase_status;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getP_o_email() {
		return p_o_email;
	}

	public void setP_o_email(String p_o_email) {
		this.p_o_email = p_o_email;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getPurchase_status() {
		return purchase_status;
	}

	public void setPurchase_status(String purchase_status) {
		this.purchase_status = purchase_status;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Purchase [id=" + id + ", product_id=" + product_id + ", p_o_email=" + p_o_email + ", user_email="
				+ user_email + ", purchase_status=" + purchase_status + ", address=" + address + "]";
	}
	
	
}
