package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Sell;

@Repository
public interface ISellRepository extends CrudRepository<Sell,Integer>{
	@Query(value="SELECT * FROM public.sell where id_client=:parametro",nativeQuery=true)
	List<Sell> findByUser(@Param("parametro")int idAccount);
	
	@Query(value="SELECT SUM(b.price_product) FROM public.sell a left join product_selled b on a.id=:parametro",nativeQuery=true)
	Double totalCompras(@Param("parametro")int idAccount);
	
	
	@Query(value="SELECT * FROM public.sell where estado_compra=0 order by fecha_compra",nativeQuery=true)
	List<Sell> listarValidos();
	
	List<Sell> findAllByOrderByFechaCompra();
	
	
	
	
}
