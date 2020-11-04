package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Purchase;

@Repository
public interface IPurchaseRepository extends JpaRepository<Purchase, Integer> {
	//@Query("from Loan i where i.account=:parametro")
	@Query(value="SELECT * FROM public.purchases where id_client=:parametro",nativeQuery=true)
	List<Purchase> findByUser(@Param("parametro")int idAccount);
}
