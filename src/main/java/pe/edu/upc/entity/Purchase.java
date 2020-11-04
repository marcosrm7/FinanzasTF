package pe.edu.upc.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "purchases")
public class Purchase implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPurchase;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "datePurchase", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date datePurchase;
	
	@Column(name = "descriptionPurchase", nullable = false, length = 100)
	private String descriptionPurchase;
	@Column(name = "typePurchase", nullable = false, length = 40)
	private String typePurchase;
	@ManyToOne
	@JoinColumn(name = "idClient")
	private Client client;
	@ManyToOne
	@JoinColumn(name = "idProduct")
	private Product product;

	public Purchase() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Purchase(int idPurchase, Date datePurchase, String descriptionPurchase, String typePurchase, Client client,
			Product product) {
		super();
		this.idPurchase = idPurchase;
		this.datePurchase = datePurchase;
		this.descriptionPurchase = descriptionPurchase;
		this.typePurchase = typePurchase;
		this.client = client;
		this.product = product;
	}

	public int getIdPurchase() {
		return idPurchase;
	}

	public void setIdPurchase(int idPurchase) {
		this.idPurchase = idPurchase;
	}

	public Date getDatePurchase() {
		return datePurchase;
	}

	public void setDatePurchase(Date datePurchase) {
		this.datePurchase = datePurchase;
	}

	public String getDescriptionPurchase() {
		return descriptionPurchase;
	}

	public void setDescriptionPurchase(String descriptionPurchase) {
		this.descriptionPurchase = descriptionPurchase;
	}

	public String getTypePurchase() {
		return typePurchase;
	}

	public void setTypePurchase(String typePurchase) {
		this.typePurchase = typePurchase;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}


}
