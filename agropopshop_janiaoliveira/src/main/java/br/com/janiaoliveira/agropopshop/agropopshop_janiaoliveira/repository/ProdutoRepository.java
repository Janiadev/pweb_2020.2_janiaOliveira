package br.com.janiaoliveira.agropopshop.agropopshop_janiaoliveira.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.janiaoliveira.agropopshop.agropopshop_janiaoliveira.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
