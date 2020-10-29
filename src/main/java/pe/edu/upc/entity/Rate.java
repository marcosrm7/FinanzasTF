package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="rate")
public class Rate implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idRate;
	@Column (name="nameRate", nullable=false, length=45)
	private String nameRate; //quincenal, mensual
	@Column (name="daysRate", nullable=false, length=45)
	private int daysRate; //7,15
	public Rate(int idRate, String nameRate, int daysRate) {
		super();
		this.idRate = idRate;
		this.nameRate = nameRate;
		this.daysRate = daysRate;
	}
	public Rate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdRate() {
		return idRate;
	}
	public void setIdRate(int idRate) {
		this.idRate = idRate;
	}
	public String getNameRate() {
		return nameRate;
	}
	public void setNameRate(String nameRate) {
		this.nameRate = nameRate;
	}
	public int getDaysRate() {
		return daysRate;
	}
	public void setDaysRate(int daysRate) {
		this.daysRate = daysRate;
	}
	
	
	
}
