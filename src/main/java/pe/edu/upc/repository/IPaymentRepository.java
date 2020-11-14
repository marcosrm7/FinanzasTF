package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Payment;

@Repository
public interface IPaymentRepository extends JpaRepository<Payment, Integer> {

}
