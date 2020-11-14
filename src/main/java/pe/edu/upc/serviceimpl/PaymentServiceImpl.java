package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import pe.edu.upc.entity.Payment;
import pe.edu.upc.repository.IPaymentRepository;
import pe.edu.upc.serviceinterface.IPaymentService;

@Service
public class PaymentServiceImpl implements IPaymentService, Serializable {

	private static final long serialVersionUID = 1L;
	private IPaymentRepository payR;

	@Override
	public void insert(Payment payment) {
		payR.save(payment);
	}

	@Override
	public List<Payment> list() {
		return payR.findAll();
	}

	@Override
	public void delete(int idPayment) {
		payR.deleteById(idPayment);
	}

	@Override
	public Optional<Payment> searchId(int idPayment) {
		return payR.findById(idPayment);
	}

}
