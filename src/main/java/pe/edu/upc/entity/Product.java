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
@Table(name = "products")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProduct;
	@Column(name = "nameProduct", nullable = false, length = 38)
	private String nameProduct;
	@Column(name = "quantityProduct", nullable = false)
	private int quantityProduct;
	@Column(name = "priceProduct", nullable = false, columnDefinition = "Decimal(8,2)")
	private Double priceProduct;
	@ManyToOne
	@JoinColumn(name = "idCategory")
	private Category category;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int idProduct, String nameProduct, int quantityProduct, Double priceProduct, Category category) {
		super();
		this.idProduct = idProduct;
		this.nameProduct = nameProduct;
		this.quantityProduct = quantityProduct;
		this.priceProduct = priceProduct;
		this.category = category;
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

	public int getQuantityProduct() {
		return quantityProduct;
	}

	public void setQuantityProduct(int quantityProduct) {
		this.quantityProduct = quantityProduct;
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

}
