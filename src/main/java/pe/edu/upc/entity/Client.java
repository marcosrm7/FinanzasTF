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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "clients")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idClient;
	@Pattern(regexp = "[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+(\\s[a-zA-ZÀ-ÿ\\u00f1\\u00d1])*[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+(\\s[a-zA-ZÀ-ÿ\\u00f1\\u00d1])*[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+(\\s[a-zA-ZÀ-ÿ\\u00f1\\u00d1])*[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+$", message = "El nombre debe tener mínimo 1 y máximo 4 palabras (solo letras)")
	@Column(name = "nameClient", nullable = false, length = 45)
	private String nameClient;
	@Min(value = 900000000, message = "El teléfono debe tener 9 dígitos númericos y que empiece por el número 9")
	@Max(value = 999999999, message = "El teléfono debe tener 9 dígitos númericos y que empiece por el número 9")
	@Column(name = "numberClient", nullable = false, length = 8)
	private int numberClient;
	@Min(value = 1, message = "La tasa mínima es 1%")
	@Max(value = 100, message = "La tasa máxima es 100%")
	@Column(name = "rateClient", nullable = false, length = 8)
	private Double rateClient;
	// tipo de tasa: quincenal, mensual
	@ManyToOne
	@JoinColumn(name = "idRate")
	private Rate rate;
	// tipo de tasa: quincenal, mensual
	@ManyToOne
	@JoinColumn(name = "idInterest")
	private Interest interest;
	@Min(value = 1000, message = "La línea de crédito mínima es S/1000")
	@Max(value = 10000, message = "La línea de crédito máxima es S/10000")
	@Column(name = "creditClient", nullable = false, length = 8)
	private Double creditClient;
	// captitalizacion: diaria mensual
	@ManyToOne
	@JoinColumn(name = "idCapitalization")
	private Capitalization capitalization;

	private Double creditoDisponible;

	@Column(name = "debtCliente", nullable = false, length = 8)
	private Double debtCliente = (double) 0;

	// @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	// @JoinColumn(name = "idPurchase", nullable = false)
	// private List<Purchase> idlistPurchase;

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
		this.creditoDisponible = creditClient;
		this.capitalization = capitalization;
		this.debtCliente = debtCliente;
	}

	public Client(String nameClient, int numberClient, Double rateClient, Rate rate, Interest interest,
			Double creditClient, Capitalization capitalization, Double debtCliente) {
		super();

		this.nameClient = nameClient;
		this.numberClient = numberClient;
		this.rateClient = rateClient;
		this.rate = rate;
		this.interest = interest;
		this.creditClient = creditClient;
		this.creditoDisponible = creditClient;
		this.capitalization = capitalization;
		this.debtCliente = debtCliente;
	}

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	// A RESTAR COMPRAS!
	public boolean sinCredito(Double compra) {
		if (this.creditoDisponible - compra <= 0)
			return false;
		else
			return true;
	}

	public void restarCredito(Double compra) {

		this.creditoDisponible -= compra;
	}

	public void aumentarDeuda(Double compra) {
		this.debtCliente += compra;
	}

	public Double getCreditoDisponible() {
		return creditoDisponible;
	}

	public void setCreditoDisponible(Double creditoDisponible) {
		this.creditoDisponible = creditoDisponible;
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
