package com.projeto.sistema.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.sistema.modelos.Produtos;
import com.projeto.sistema.repositorios.ProdutosRepositorio;

@Controller

public class ProdutosControle {
	
	@Autowired 
	private ProdutosRepositorio produtosRepositorio;
	
	@GetMapping("/cadastroProdutos")
	public ModelAndView cadastrar(Produtos produtos) {
		ModelAndView mv = new ModelAndView("/administrativo/produtos/cadastro");
		mv.addObject("produtos", produtos);
		return mv;
	}
	
	@PostMapping("/SalvarProdutos")
	public ModelAndView salvar(Produtos produtos, BindingResult result) {
		if(result.hasErrors()) {
			return cadastrar(produtos);
		}
		produtosRepositorio.saveAndFlush(produtos);
		return cadastrar(new Produtos());
		
	}
	
	

}
