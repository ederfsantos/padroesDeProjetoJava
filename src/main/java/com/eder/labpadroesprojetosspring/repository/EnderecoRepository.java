package com.eder.labpadroesprojetosspring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eder.labpadroesprojetosspring.model.Endereco;
@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, String>{

}
