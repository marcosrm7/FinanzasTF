package pe.edu.upc.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.Purchase;

public interface IPurchaseService {

	public void insert(Purchase purchase);

	List<Purchase> list();

	public void delete(int idPurchase);

	Optional<Purchase> searchId(int idPurchase);
	
	List<Purchase> listarComprasPorID(int idCliente);
}
