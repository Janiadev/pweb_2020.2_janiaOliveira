package br.com.janiaoliveira.agropopshop.agropopshop_janiaoliveira.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.janiaoliveira.cadpessoas.model.Pessoa;
import br.com.janiaoliveira.cadpessoas.repository.PessoaRepository;

@Controller
@RequestMapping("/")
public class ClienteController {

	@Autowired
	PessoaRepository clienteRepo;
	
	public String index() {
		return "index.html";
	}
	
	@GetMapping("/listarClientes")
	public ModelAndView listarclientes() {
		List <cliente> lista = clienteRepo.findAll();
		ModelAndView mav = new ModelAndView("listarClientes");
		mav.addObject("cliente", lista);
		return mav;
	}
}
