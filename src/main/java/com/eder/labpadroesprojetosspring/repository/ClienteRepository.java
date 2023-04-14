package com.eder.labpadroesprojetosspring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eder.labpadroesprojetosspring.model.Cliente;
@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}
