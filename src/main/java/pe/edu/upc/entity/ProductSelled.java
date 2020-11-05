package pe.edu.upc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ProductSelled {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProduct;
	private String nameProduct;
	private Double cantidad;
	private Double priceProduct;
	@ManyToOne
	@JoinColumn(name = "idCategory")
	private Category category;
	@ManyToOne
	@JoinColumn
	private Sell sell;
	
	public ProductSelled(String nameProduct, Double cantidad, Double priceProduct, Category category,
			Sell sell) {
		super();
	
		this.nameProduct = nameProduct;
		this.cantidad = cantidad;
		this.priceProduct = priceProduct;
		this.category = category;
		this.sell = sell;
	}
	public ProductSelled() {
		super();
		// TODO Auto-generated constructor stub
	}
	   public Double getTotal() {
	        return this.cantidad * this.priceProduct;
	    }

	
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	public String getNameProduct() {
		return nameProduct;
	}
	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}
	public Double getCantidad() {
		return cantidad;
	}
	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}
	public Double getPriceProduct() {
		return priceProduct;
	}
	public void setPriceProduct(Double priceProduct) {
		this.priceProduct = priceProduct;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Sell getSell() {
		return sell;
	}
	public void setSell(Sell sell) {
		this.sell = sell;
	}
	
	
}
