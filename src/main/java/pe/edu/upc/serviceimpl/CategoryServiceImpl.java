package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entity.Category;
import pe.edu.upc.repository.ICategoryRepository;
import pe.edu.upc.serviceinterface.ICategoryService;

@Service
public class CategoryServiceImpl implements Serializable, ICategoryService {

	private static final long serialVersionUID = 1L;
	@Autowired
	private ICategoryRepository cR;

	@Override
	public void insert(Category category) {
		cR.save(category);
	}

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return cR.findAll();
	}

	@Override
	public void delete(int idCategory) {
		// TODO Auto-generated method stub
		cR.deleteById(idCategory);
	}

	@Override
	public Optional<Category> searchId(int idCategory) {
		// TODO Auto-generated method stub
		return cR.findById(idCategory);
	}

}
