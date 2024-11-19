package com.projetoAvaliacao.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoAvaliacao.entity.Produto;
import com.projetoAvaliacao.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Produto salvarProduto(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	public List<Produto> buscarTodos(){
		return produtoRepository.findAll();
	}
	
	public Optional<Produto> buscarPorId(Long id) {
		return produtoRepository.findById(id);
	}
	
	public Produto atualizarProduto (Produto produto) {
		if (produtoRepository.existsById(produto.getId())) {
			return produtoRepository.save(produto);
		} else {
			throw new RuntimeException("Hóspede não encontrado");
		}
	}
	
	public void deletarProduto(Long id) {
		produtoRepository.deleteById(id);
	}
}
