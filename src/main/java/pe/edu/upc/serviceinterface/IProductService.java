package pe.edu.upc.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.Product;

public interface IProductService {

	public void insert(Product product);

	List<Product> list();

	public void delete(int idProduct);

	Optional<Product> searchId(int idProduct);
}
