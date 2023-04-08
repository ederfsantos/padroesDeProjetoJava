package model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import model.Cliente;
@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}
