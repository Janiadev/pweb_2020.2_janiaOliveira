package br.com.janiaoliveira.agropopshop.agropopshop_janiaoliveira.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.janiaoliveira.agropopshop.agropopshop_janiaoliveira.model.Pedido;
import br.com.janiaoliveira.agropopshop.agropopshop_janiaoliveira.repository.ClienteRepository;
import br.com.janiaoliveira.agropopshop.agropopshop_janiaoliveira.repository.PedidoRepository;
import br.com.janiaoliveira.agropopshop.agropopshop_janiaoliveira.repository.ProdutoRepository;

@Controller
@RequestMapping("/")
public class PedidoController {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@GetMapping("/adicionarPedido")
	public ModelAndView telaAdiciona() {
		ModelAndView mv = new ModelAndView("adicionarPedido");
		mv.addObject("produtos", produtoRepository.findAllByOrderByNomeAsc());
		mv.addObject("clientes", clienteRepository.findAllByOrderByNomeAsc());
		mv.addObject("pedido", new Pedido());
		return mv;
	}

	@PostMapping("/adicionarPedido")
	public String adiciona(Pedido pedido) {
		pedido.setDataDeCadastro(LocalDate.now());
		pedido.setValorUnidade(produtoRepository.getOne(pedido.getProduto().getId()).getPreco());
		pedidoRepository.save(pedido);
		return "redirect:/listarPedidos";
	}

	@GetMapping("/listarPedidos")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("listarPedidos");
		mv.addObject("pedidos", pedidoRepository.findAll());
		return mv;
	}

	@GetMapping("/editarPedido/{id}")
	public ModelAndView editarTela(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("editarPedido");
		mv.addObject("produtos", produtoRepository.findAllByOrderByNomeAsc());
		mv.addObject("clientes", clienteRepository.findAllByOrderByNomeAsc());
		mv.addObject("pedido", pedidoRepository.getOne(id));
		return mv;
	}

	@PostMapping("/editarPedido")
	public String editar(Pedido pedido) {
		pedido.setValorUnidade(produtoRepository.getOne(pedido.getProduto().getId()).getPreco());
		pedidoRepository.save(pedido);
		return "redirect:/listarPedidos";
	}

	@GetMapping("/removerPedido/{id}")
	public String remover(@PathVariable Long id) {
		pedidoRepository.delete(pedidoRepository.getOne(id));
		return "redirect:/listarPedidos";
	}
}
