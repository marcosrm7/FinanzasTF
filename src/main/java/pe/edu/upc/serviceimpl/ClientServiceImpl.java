package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entity.Client;
import pe.edu.upc.repository.IClientRepository;
import pe.edu.upc.serviceinterface.IClientService;
@Service
public class ClientServiceImpl implements IClientService, Serializable{
	private static final long serialVersionUID = 1L;
	@Autowired
	private IClientRepository pR;
	@Override
	public void insert(Client client) {
		// TODO Auto-generated method stub
		pR.save(client);
	}
	@Override
	public List<Client> list() {
		// TODO Auto-generated method stub
		return pR.findAll();
	}
	@Override
	public void delete(int idclient) {
		// TODO Auto-generated method stub
		pR.deleteById(idclient);
	}
	@Override
	public Optional<Client> searchId(int idclient) {
		// TODO Auto-generated method stub
		return pR.findById(idclient);
	}

}
