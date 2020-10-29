package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entity.Rate;
import pe.edu.upc.repository.IRateRepository;
import pe.edu.upc.serviceinterface.IRateService;

@Service
public class RateServiceImpl implements Serializable, IRateService{
	private static final long serialVersionUID = 1L;
	@Autowired
	private IRateRepository cR;
	@Override
	public void insert(Rate rate) {
		// TODO Auto-generated method stub
		cR.save(rate);
	}
	@Override
	public List<Rate> list() {
		// TODO Auto-generated method stub
		return cR.findAll();
	}
	@Override
	public void delete(int idRate) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Optional<Rate> searchId(int idRate) {
		// TODO Auto-generated method stub
		return null;
	}
}
