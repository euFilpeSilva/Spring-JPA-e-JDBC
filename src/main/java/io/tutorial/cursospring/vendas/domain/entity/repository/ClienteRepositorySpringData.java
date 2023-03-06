package io.tutorial.cursospring.vendas.domain.entity.repository;

import io.tutorial.cursospring.vendas.domain.entity.Cliente;
import org.h2.command.dml.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepositorySpringData extends JpaRepository<Cliente, Integer> {

////    O QueryMethod a abaixo equivale a seguinte consulta SQL:
////    SELECT c FROM Cliente c WHERE c.nome LIKE :nome
//    List<Cliente> findByNomeLike(String cli);

    @Query(value = " select c from Cliente c where c.nome like '%:nome%' ", nativeQuery = true)
    List<Cliente> buscarPorNome( @Param("nome") String nome );

//    mais um exemplo abaixo:
    List<Cliente> findByNomeOrIdOrderById(String nome, Integer id);

//    outro
    Cliente findOneByNome(String nome);
}

