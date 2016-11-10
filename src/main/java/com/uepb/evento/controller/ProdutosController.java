package com.uepb.evento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uepb.evento.model.Produto;
import com.uepb.evento.repository.ProdutoRepository;

@Controller
@RequestMapping("/produtos")
public class ProdutosController {

	@Autowired
	ProdutoRepository produtoRepository;
	
	@RequestMapping
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("Produtos");
		mv.addObject(new Produto());
		mv.addObject("produtos", produtoRepository.findAll());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(@Validated Produto produto, Errors erros, RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView("Produtos");
		if(erros.hasErrors()) {
			mv.addObject("produtos", produtoRepository.findAll());
			return mv;
		}
		produtoRepository.save(produto);
		mv.setViewName("redirect:/produtos");
		attributes.addFlashAttribute("mensagem", "Produto cdastrado com sucesso!");
		return mv;
	}
}
