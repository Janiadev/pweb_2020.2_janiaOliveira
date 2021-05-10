package br.com.janiaoliveira.agropopshop.agropopshop_janiaoliveira.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.janiaoliveira.agropopshop.agropopshop_janiaoliveira.model.Produto;
import br.com.janiaoliveira.agropopshop.agropopshop_janiaoliveira.repository.ProdutoRepository;

@Controller
@RequestMapping("/")
public class ProdutoController {
	@Autowired
	ProdutoRepository produtoRepo;

	@GetMapping("/adicionarProduto")
	public ModelAndView formAdicionarCliente() {
		ModelAndView modelView = new ModelAndView("adicionarProduto");
		modelView.addObject(new Produto());
		return modelView;
	}

	@PostMapping("/adicionarProduto")
	public ModelAndView adicionarClientes(Produto produto) {
		produtoRepo.save(produto);
		return new ModelAndView("redirect:/listarProdutos");
	}

	@GetMapping("/listarProdutos")
	public ModelAndView listarProdutos() {
		List<Produto> lista = produtoRepo.findAll();
		ModelAndView mav = new ModelAndView("listarProduto");
		mav.addObject("produtos", lista);
		return mav;
	}
	
	@GetMapping("/editarProduto/{id}")
	public ModelAndView formEditarProduto(@PathVariable("id") long id) {
		Produto produto = produtoRepo.findById(id).orElseThrow(() -> new IllegalAccessError("Não existe"));
		ModelAndView modelAndView = new ModelAndView("editarProduto");
		modelAndView.addObject("produto",produto);
		return modelAndView;
	}

	@PostMapping("/editarProduto")
	public ModelAndView editarCliente(Produto produto) {
		produtoRepo.save(produto);
		return new ModelAndView("redirect:/listarProdutos");
	}

	@GetMapping("/removerProduto/{id}")
	public ModelAndView removerCliente(@PathVariable("id") long id) {
		produtoRepo.deleteById(id);
		return new ModelAndView("redirect:/listarProdutos");
	}
}