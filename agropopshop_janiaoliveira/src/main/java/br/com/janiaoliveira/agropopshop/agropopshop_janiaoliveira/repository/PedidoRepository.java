package br.com.janiaoliveira.agropopshop.agropopshop_janiaoliveira.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.janiaoliveira.agropopshop.agropopshop_janiaoliveira.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
