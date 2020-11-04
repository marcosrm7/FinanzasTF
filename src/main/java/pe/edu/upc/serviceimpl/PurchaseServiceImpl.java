package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entity.Purchase;
import pe.edu.upc.repository.IPurchaseRepository;
import pe.edu.upc.serviceinterface.IPurchaseService;

@Service
public class PurchaseServiceImpl implements IPurchaseService, Serializable {

	private static final long serialVersionUID = 1L;
	@Autowired
	private IPurchaseRepository purR;

	@Override
	public void insert(Purchase purchase) {
		purR.save(purchase);
	}

	@Override
	public List<Purchase> list() {
		return purR.findAll();
	}

	@Override
	public void delete(int idPurchase) {
		purR.deleteById(idPurchase);
	}

	@Override
	public Optional<Purchase> searchId(int idPurchase) {
		return purR.findById(idPurchase);
	}

	@Override
	public List<Purchase> listarComprasPorID(int idCliente) {
		// TODO Auto-generated method stub
		List<Purchase> op = purR.findByUser(idCliente);
		return op;
	}

}
