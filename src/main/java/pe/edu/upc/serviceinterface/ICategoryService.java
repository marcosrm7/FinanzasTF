package pe.edu.upc.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.Category;

public interface ICategoryService {

	public void insert(Category category);

	List<Category> list();

	public void delete(int idCategory);

	Optional<Category> searchId(int idCategory);
}
