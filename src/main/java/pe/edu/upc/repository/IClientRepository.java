package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Client;

@Repository
public interface IClientRepository  extends JpaRepository<Client, Integer> {

	
	List<Client> findAllByOrderByIdClient();
}
