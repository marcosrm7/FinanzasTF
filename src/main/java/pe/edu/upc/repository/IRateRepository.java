package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Rate;

@Repository
public interface IRateRepository extends JpaRepository<Rate, Integer> {

}
