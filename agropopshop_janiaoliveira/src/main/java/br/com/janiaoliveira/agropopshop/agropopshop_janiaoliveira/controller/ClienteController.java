package br.com.janiaoliveira.agropopshop.agropopshop_janiaoliveira.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.janiaoliveira.agropopshop.agropopshop_janiaoliveira.model.Cliente;
import br.com.janiaoliveira.agropopshop.agropopshop_janiaoliveira.repository.ClienteRepository;

@Controller
@RequestMapping("/")
public class ClienteController {

	@Autowired
	ClienteRepository clienteRepo;

	@GetMapping(value = "/")
	public String index() {
		return "index";
	}

	@GetMapping("/listarClientes")
	public ModelAndView listarclientes() {
		List<Cliente> lista = clienteRepo.findAll();
		ModelAndView mav = new ModelAndView("listarCliente");
		mav.addObject("clientes", lista);
		return mav;
	}

	@GetMapping("/adicionarCliente")
	public ModelAndView formAdicionarCliente() {
		ModelAndView modelView = new ModelAndView("adicionarCliente");
		modelView.addObject(new Cliente());
		return modelView;
	}

	@PostMapping("/adicionarClientes")
	public ModelAndView adicionarClientes(Cliente cliente) {
		clienteRepo.save(cliente);
		return new ModelAndView("redirect:/listarClientes");
	}

	@GetMapping("/editar/{id}")
	public ModelAndView formEditarCliente(@PathVariable("id") long id) {
		Cliente cliente = clienteRepo.findById(id).orElseThrow(() -> new IllegalAccessError("Não existe"));
		ModelAndView modelAndView = new ModelAndView("editarCliente");
		modelAndView.addObject("cliente",cliente);
		return modelAndView;
	}

	@PostMapping("/editarCliente")
	public ModelAndView editarCliente(Cliente cliente) {
		clienteRepo.save(cliente);
		return new ModelAndView("redirect:/listarClientes");
	}

	@GetMapping("/remover/{id}")
	public ModelAndView removerCliente(@PathVariable("id") long id) {
		clienteRepo.deleteById(id);
		return new ModelAndView("redirect:/listarClientes");
	}
}
