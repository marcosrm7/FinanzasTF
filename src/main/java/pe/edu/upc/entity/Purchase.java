package pe.edu.upc.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name="purchase")
public class Purchase implements Serializable {
	//agregar fecha de compra!
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idPurchase;
	//@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//@JoinColumn(name = "idProduct", nullable = false)
	//private List<Product> idlistProduct; error
	@ManyToOne
	@JoinColumn(name = "idClient", nullable = false)
	private Client idClient;
	@Column (name="descriptionPurchase", nullable=false, length=45)
	private String descriptionPurchase;
	@Column (name="deliveryPurchase", nullable=false, length=45)
	private Double deliveryPurchase;
	public Purchase(int idPurchase, Client idClient, String descriptionPurchase,
			Double deliveryPurchase) {
		super();
		this.idPurchase = idPurchase;
		//this.idlistProduct = idlistProduct;
		this.idClient = idClient;
		this.descriptionPurchase = descriptionPurchase;
		this.deliveryPurchase = deliveryPurchase;
	}
	public Purchase() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdPurchase() {
		return idPurchase;
	}
	public void setIdPurchase(int idPurchase) {
		this.idPurchase = idPurchase;
	}
	//public List<Product> getIdlistProduct() {
	//	return idlistProduct;
	//}
	//public void setIdlistProduct(List<Product> idlistProduct) {
	//	this.idlistProduct = idlistProduct;
	//}
	public Client getIdClient() {
		return idClient;
	}
	public void setIdClient(Client idClient) {
		this.idClient = idClient;
	}
	public String getDescriptionPurchase() {
		return descriptionPurchase;
	}
	public void setDescriptionPurchase(String descriptionPurchase) {
		this.descriptionPurchase = descriptionPurchase;
	}
	public Double getDeliveryPurchase() {
		return deliveryPurchase;
	}
	public void setDeliveryPurchase(Double deliveryPurchase) {
		this.deliveryPurchase = deliveryPurchase;
	}
	
	
	
	
}
