package pe.edu.upc.serviceinterface;

import java.util.List;

import pe.edu.upc.entity.Product;

public interface IProductService {
	
	public void insert(Product product);

	List<Product> list();
}
