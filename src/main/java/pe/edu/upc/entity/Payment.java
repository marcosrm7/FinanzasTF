package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "payments")
public class Payment implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPayment;
	@Column(name = "descriptionPayment", nullable = false, length = 38)
	private String descriptionPayment;
	@Column(name = "amountPayment", nullable = false, columnDefinition = "Decimal(8,2)")
	private Double amountPayment;
	@ManyToOne
	@JoinColumn(name = "idSell")
	private Sell sell;

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payment(int idPayment, String descriptionPayment, Double amountPayment, Sell sell) {
		super();
		this.idPayment = idPayment;
		this.descriptionPayment = descriptionPayment;
		this.amountPayment = amountPayment;
		this.sell = sell;
	}

	public int getIdPayment() {
		return idPayment;
	}

	public void setIdPayment(int idPayment) {
		this.idPayment = idPayment;
	}

	public String getDescriptionPayment() {
		return descriptionPayment;
	}

	public void setDescriptionPayment(String descriptionPayment) {
		this.descriptionPayment = descriptionPayment;
	}

	public Double getAmountPayment() {
		return amountPayment;
	}

	public void setAmountPayment(Double amountPayment) {
		this.amountPayment = amountPayment;
	}

	public Sell getSell() {
		return sell;
	}

	public void setSell(Sell sell) {
		this.sell = sell;
	}

}
