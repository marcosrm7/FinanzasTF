package pe.edu.upc.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.Client;

public interface IClientService {
	public void insert(Client client);

	List<Client> list();

	public void delete(int idclient);

	Optional<Client> searchId(int idclient);
}
