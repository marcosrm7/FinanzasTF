package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Capitalization;

@Repository
public interface ICapitalizationRepository extends JpaRepository<Capitalization, Integer>{

}
