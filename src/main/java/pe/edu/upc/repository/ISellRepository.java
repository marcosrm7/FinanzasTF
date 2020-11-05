package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Sell;

@Repository
public interface ISellRepository extends CrudRepository<Sell,Integer>{

}
