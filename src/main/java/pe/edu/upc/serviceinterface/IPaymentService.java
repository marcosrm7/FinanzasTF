package pe.edu.upc.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.Payment;

public interface IPaymentService {

	public void insert(Payment payment);

	List<Payment> list();

	public void delete(int idPayment);

	Optional<Payment> searchId(int idPayment);
}
