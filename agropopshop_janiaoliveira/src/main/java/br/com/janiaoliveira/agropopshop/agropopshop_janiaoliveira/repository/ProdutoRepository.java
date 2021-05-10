package br.com.janiaoliveira.agropopshop.agropopshop_janiaoliveira.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.janiaoliveira.agropopshop.agropopshop_janiaoliveira.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	List<Produto> findAllByOrderByNomeAsc();
}
