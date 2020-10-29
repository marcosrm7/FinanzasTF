package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="interest")
public class Interest  implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idInterest;
	@Column (name="nameInterest", nullable=false, length=45)
	private String nameInterest;//simple compuesto efectivo
	public Interest(int idInterest, String nameInterest) {
		super();
		this.idInterest = idInterest;
		this.nameInterest = nameInterest;
	}
	public Interest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdInterest() {
		return idInterest;
	}
	public void setIdInterest(int idInterest) {
		this.idInterest = idInterest;
	}
	public String getNameInterest() {
		return nameInterest;
	}
	public void setNameInterest(String nameInterest) {
		this.nameInterest = nameInterest;
	}
	
	
}
