package io.tutorial.cursospring.vendas.domain.entity.repository;

import io.tutorial.cursospring.vendas.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
