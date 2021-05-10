package br.com.janiaoliveira.agropopshop.agropopshop_janiaoliveira.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.janiaoliveira.agropopshop.agropopshop_janiaoliveira.model.Dependente;
import br.com.janiaoliveira.agropopshop.agropopshop_janiaoliveira.repository.ClienteRepository;
import br.com.janiaoliveira.agropopshop.agropopshop_janiaoliveira.repository.DependenteRepository;

@Controller
@RequestMapping("/")
public class DependenteController {
	
	@Autowired
	private ClienteRepository repo;
	
	@Autowired
	private DependenteRepository dependenteRepository;

	@GetMapping(value = "/adicionarDependente")
	public ModelAndView adicionaDependente() {
		ModelAndView mv = new ModelAndView("adicionarDependente");
		mv.addObject("clientes", repo.findAll());
		mv.addObject("dependente", new Dependente());
		return mv;		
	}
	
	@PostMapping(value = "/adicionarDependente")
	public String adicionaDependente(Dependente dependente) {
		dependenteRepository.save(dependente);
		return "redirect:/listarDependentes";		
	}
	
	@PostMapping(value = "/editarDependente")
	public ModelAndView editarDependentes(Dependente dependente) {
		dependenteRepository.save(dependente);
		return new ModelAndView("redirect:/listarDependentes");
	}
	
	@GetMapping("/editarDependente/{id}")
	public ModelAndView editarTelaDependente(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView("editarDependente");
		mav.addObject("clientes", repo.findAll());
		mav.addObject("dependente", dependenteRepository.findById(id));
		return mav;
	}
	
	@GetMapping(value = "/removerDependente/{id}")
	public String removerDependente(@PathVariable Long id) {
		dependenteRepository.delete(dependenteRepository.getOne(id));
		return "redirect:/listarDependentes";
	}
	
	@GetMapping(value = "/listarDependentes")
	public ModelAndView listaDependentes() {
		ModelAndView mv = new ModelAndView("listarDependentes");
		mv.addObject("dependentes", dependenteRepository.findAll());
		return mv;
	}
}
