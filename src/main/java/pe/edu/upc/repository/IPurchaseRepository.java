package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Purchase;

@Repository
public interface IPurchaseRepository extends JpaRepository<Purchase, Integer> {

}
