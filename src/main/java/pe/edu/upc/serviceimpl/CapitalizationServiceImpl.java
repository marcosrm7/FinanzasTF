package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entity.Capitalization;
import pe.edu.upc.repository.ICapitalizationRepository;
import pe.edu.upc.serviceinterface.ICapitalizationService;

@Service
public class CapitalizationServiceImpl implements Serializable, ICapitalizationService{
	private static final long serialVersionUID = 1L;
	@Autowired
	private ICapitalizationRepository cR;
	@Override
	public void insert(Capitalization capitalization) {
		// TODO Auto-generated method stub
		cR.save(capitalization);
	}

	@Override
	public List<Capitalization> list() {
		// TODO Auto-generated method stub
		return cR.findAll();
		}

	@Override
	public void delete(int idcapitalization) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Capitalization> searchId(int idcapitalization) {
		// TODO Auto-generated method stub
		return null;
	}

}
