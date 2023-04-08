package model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import model.Endereco;
@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, String>{

}
