package br.com.janiaoliveira.cadpessoas.controllers;

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
public class PessoaController {

	@Autowired
	PessoaRepository pessoaRepo;
	
	public String index() {
		return "index.html";
	}
	
	@GetMapping("/listarPessoas")
	public ModelAndView listarPessoas() {
		List <Pessoa> lista = pessoaRepo.findAll();
		ModelAndView mav = new ModelAndView("listarPessoas");
		mav.addObject("pessoas", lista);
		return mav;
	}
}
