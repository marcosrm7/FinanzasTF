package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entity.Product;
import pe.edu.upc.repository.IProductRepository;
import pe.edu.upc.serviceinterface.IProductService;

@Service
public class ProductServiceImpl implements IProductService, Serializable {

	private static final long serialVersionUID = 1L;
	@Autowired
	private IProductRepository pR;

	@Override
	public void insert(Product product) {
		pR.save(product);
	}

	@Override
	public List<Product> list() {
		return pR.findAll();
	}

}
