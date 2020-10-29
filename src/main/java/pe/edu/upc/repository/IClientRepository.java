package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Client;

@Repository
public interface IClientRepository  extends JpaRepository<Client, Integer> {

}
