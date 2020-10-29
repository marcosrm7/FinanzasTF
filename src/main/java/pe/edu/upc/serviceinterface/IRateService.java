package pe.edu.upc.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.Rate;

public interface IRateService {
	public void insert(Rate rate);

	List<Rate> list();

	public void delete(int idRate);

	Optional<Rate> searchId(int idRate);
}
