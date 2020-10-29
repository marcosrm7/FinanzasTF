package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entity.Interest;
import pe.edu.upc.repository.IInterestRepository;
import pe.edu.upc.serviceinterface.IInterestService;

@Service
public class InterestServiceImpl implements Serializable, IInterestService{
	private static final long serialVersionUID = 1L;
	@Autowired
	private IInterestRepository cR;
	@Override
	public void insert(Interest interes) {
		// TODO Auto-generated method stub
		cR.save(interes);
	}
	@Override
	public List<Interest> list() {
		// TODO Auto-generated method stub
		return cR.findAll();
	}
	@Override
	public Optional<Interest> searchId(int idInterest) {
		// TODO Auto-generated method stub
		return cR.findById(idInterest);
	}
}
