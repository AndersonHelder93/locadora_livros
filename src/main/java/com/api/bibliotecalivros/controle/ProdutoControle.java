package com.api.bibliotecalivros.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.bibliotecalivros.modelo.ProdutoModelo;
import com.api.bibliotecalivros.modelo.RespostaModelo;
import com.api.bibliotecalivros.repositorio.ProdutoRepositorio;

@RestController
@RequestMapping("/api")
public @ResponseBody class ProdutoControle {
	
	//Ações
	@Autowired
	private ProdutoRepositorio acoes;
	
	//Listar produtos
	@RequestMapping(value = "/produtos", method=RequestMethod.GET)
	public @ResponseBody List<ProdutoModelo> listar() {
		return acoes.findAll();
	}
	
	//Cadastrar Produtos
	@RequestMapping(value="/produtos", method=RequestMethod.POST)
	public @ResponseBody ProdutoModelo cadastrar(@RequestBody ProdutoModelo produto) {
		return acoes.save(produto);
	}
	
	//Filtrar produtos
	@RequestMapping(value = "/produtos/{id}", method=RequestMethod.GET)
	public @ResponseBody ProdutoModelo filtrar(@PathVariable Integer id) {
		return acoes.findByid(id);
	}

	@RequestMapping(value="/produtos", method=RequestMethod.PUT)
	public @ResponseBody ProdutoModelo alterar(@RequestBody ProdutoModelo produto) {
		return acoes.save(produto);
	}
	
	//Deletar
	@RequestMapping(value="/produtos/{id}", method=RequestMethod.DELETE)
	public @ResponseBody RespostaModelo deletar(@PathVariable Integer id) {
		
		RespostaModelo resposta = new RespostaModelo();
		
		try {
			ProdutoModelo produto = filtrar(id);
			this.acoes.delete(produto);
			resposta.setMensagem("Produto Removido com sucesso");
		}catch(Exception erro) {
			resposta.setMensagem("Falha ao tentar remover: " + erro.getMessage());
		}
		
		return resposta;
	}
}
