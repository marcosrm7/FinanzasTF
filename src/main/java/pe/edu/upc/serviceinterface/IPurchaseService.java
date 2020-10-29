package pe.edu.upc.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.Purchase;

public interface IPurchaseService {
	
	public void insert (Purchase l);
	
	List <Purchase> list();
	
	Purchase listarId(int idLoan);

    Optional<Purchase> fetchByLoanIdWithLoanDetailsWithBooks(int idLoan);
    
    List<Purchase> listarIdUsuario(int idUsuario);
}
