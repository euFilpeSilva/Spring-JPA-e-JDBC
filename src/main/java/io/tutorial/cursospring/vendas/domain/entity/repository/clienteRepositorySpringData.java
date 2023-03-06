package io.tutorial.cursospring.vendas.domain.entity.repository;

import io.tutorial.cursospring.vendas.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface clienteRepositorySpringData extends JpaRepository<Cliente, Integer> {

}

