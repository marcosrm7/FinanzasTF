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
@Table (name="client")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idClient;
	@Column (name="nameClient", nullable=false, length=45)
	private String nameClient;
	@Column (name="numberClient", nullable=false, length=8)
	private int numberClient;
	
	@Column (name="rateClient", nullable=false, length=8)
	private Double rateClient;
	//tipo de tasa: quincenal, mensual
	@ManyToOne
	@JoinColumn(name = "idRate")
	private Rate rate;
	//tipo de tasa: quincenal, mensual
	@ManyToOne
	@JoinColumn(name = "idInterest")
	private Interest interest;
	@Column (name="creditClient", nullable=false, length=8)
	private Double creditClient;
	//captitalizacion: diaria mensual 
	@ManyToOne
	@JoinColumn(name = "idCapitalization")
	private Capitalization capitalization;
	
	
	@Column (name="debtCliente", nullable=false, length=8)
	private Double debtCliente;

	//@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
		//@JoinColumn(name = "idPurchase", nullable = false)
		//private List<Purchase> idlistPurchase;

	public Client(int idClient, String nameClient, int numberClient, Double rateClient, Rate rate, Interest interest,
			Double creditClient, Capitalization capitalization, Double debtCliente) {
		super();
		this.idClient = idClient;
		this.nameClient = nameClient;
		this.numberClient = numberClient;
		this.rateClient = rateClient;
		this.rate = rate;
		this.interest = interest;
		this.creditClient = creditClient;
		this.capitalization = capitalization;
		this.debtCliente = debtCliente;
	}

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getNameClient() {
		return nameClient;
	}

	public void setNameClient(String nameClient) {
		this.nameClient = nameClient;
	}

	public int getNumberClient() {
		return numberClient;
	}

	public void setNumberClient(int numberClient) {
		this.numberClient = numberClient;
	}

	public Double getRateClient() {
		return rateClient;
	}

	public void setRateClient(Double rateClient) {
		this.rateClient = rateClient;
	}

	public Rate getRate() {
		return rate;
	}

	public void setRate(Rate rate) {
		this.rate = rate;
	}

	public Interest getInterest() {
		return interest;
	}

	public void setInterest(Interest interest) {
		this.interest = interest;
	}

	public Double getCreditClient() {
		return creditClient;
	}

	public void setCreditClient(Double creditClient) {
		this.creditClient = creditClient;
	}

	public Capitalization getCapitalization() {
		return capitalization;
	}

	public void setCapitalization(Capitalization capitalization) {
		this.capitalization = capitalization;
	}

	public Double getDebtCliente() {
		return debtCliente;
	}

	public void setDebtCliente(Double debtCliente) {
		this.debtCliente = debtCliente;
	}
	
	

	

	
}
