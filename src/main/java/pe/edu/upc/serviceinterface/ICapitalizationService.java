package pe.edu.upc.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.Capitalization;

public interface ICapitalizationService {
	public void insert(Capitalization capitalization);

	List<Capitalization> list();

	public void delete(int idcapitalization);

	Optional<Capitalization> searchId(int idcapitalization);
}
