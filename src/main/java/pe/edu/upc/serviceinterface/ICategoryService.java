package pe.edu.upc.serviceinterface;

import java.util.List;

import pe.edu.upc.entity.Category;

public interface ICategoryService {
	
	public void insert(Category category);

	List<Category> list();
}
