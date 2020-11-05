package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import pe.edu.upc.entity.ProductSelled;

@Repository
public interface IProductSelledRepository extends CrudRepository<ProductSelled,Integer>{

}
