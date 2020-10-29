package pe.edu.upc.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.Interest;

public interface IInterestService {
	public void insert(Interest interes);

	List<Interest> list();

	Optional<Interest> searchId(int idInterest);
}
