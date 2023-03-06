package io.tutorial.cursospring.vendas.domain.entity.repository;

import io.tutorial.cursospring.vendas.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
