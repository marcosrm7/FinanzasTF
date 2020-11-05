package pe.edu.upc.entity;

public class ProductToSell extends Product{
	private Double cantidad;

	public ProductToSell(int idProduct, String nameProduct, int quantityProduct, Double priceProduct, Category category, Double cantidad) {
		super(idProduct,nameProduct,quantityProduct,priceProduct,category);
		this.cantidad = cantidad;
	}
	public ProductToSell( String nameProduct, int quantityProduct, Double priceProduct, Category category, Double cantidad) {
		super(nameProduct,quantityProduct,priceProduct,category);
		this.cantidad = cantidad;
	}
	
	 public void aumentarCantidad() {
	        this.cantidad++;
	    }

	public Double getCantidad() {
	        return cantidad;
	    }

	 public Double getTotal() {
	        return this.getPriceProduct() * this.cantidad;
	    }
	
}
