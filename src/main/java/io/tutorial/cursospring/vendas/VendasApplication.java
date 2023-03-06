package io.tutorial.cursospring.vendas;

import io.tutorial.cursospring.vendas.domain.entity.Cliente;
import io.tutorial.cursospring.vendas.domain.entity.Pedido;
import io.tutorial.cursospring.vendas.domain.entity.repository.ClienteRepositorySpringData;
import io.tutorial.cursospring.vendas.domain.entity.repository.ClientesRepository;
import io.tutorial.cursospring.vendas.domain.entity.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class VendasApplication {


	@Bean
	public CommandLineRunner init(
			@Autowired
			ClienteRepositorySpringData clientes,
			@Autowired
			PedidoRepository pedidos
	){
		return args -> {

			System.out.println("Salvando clientes");
			Cliente joao =clientes.save(new Cliente("João"));
			clientes.save(joao);

			Pedido p = new Pedido();
			p.setCliente(clientes.findById(1).get());
			p.setDataPedido( LocalDate.now() );
			p.setTotal(BigDecimal.valueOf(100));
			pedidos.save(p);

			Cliente cliente = clientes.findClienteFetchPedidos(joao.getId());
			System.out.println(cliente);
			System.out.println(cliente.getPedidos());

//			System.out.println("Salvando clientes");
//			clientes.save(new Cliente("Dougllas"));
//			clientes.save(new Cliente("Outro Cliente"));
//
//			List<Cliente> todosClientes = clientes.findAll();
//			todosClientes.forEach(System.out::println);
//
//			System.out.println("Atualizando clientes");
//			todosClientes.forEach(c -> {
//				c.setNome(c.getNome() + " atualizado.");
//				clientes.save(c);
//			});
//
//			todosClientes = clientes.findAll();
//			todosClientes.forEach(System.out::println);
//
//			System.out.println("Buscando clientes");
//			clientes.buscarPorNome("Cli").forEach(System.out::println);
//
//			System.out.println("deletando clientes");
//			clientes.findAll().forEach(c -> {
//				clientes.delete(c);
//			});
//
//			todosClientes = clientes.findAll();
//			if(todosClientes.isEmpty()){
//				System.out.println("Nenhum cliente encontrado.");
//			}else{
//				todosClientes.forEach(System.out::println);
//			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}
}
