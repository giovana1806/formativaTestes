package com.projetoAvaliacao.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.projetoAvaliacao.entity.Produto;
import com.projetoAvaliacao.repository.ProdutoRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
class ProdutoServiceTest {

	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@BeforeEach
	void setUp() {
		produtoRepository.deleteAll(); 
	}
	
	@DisplayName("Testando salvar produto")
	@Test
	void testSalvarProduto() {
		Produto produto = new Produto(null, "caixa de bombom", "chocolates nestle", 15.5);
		
		Produto resultado = produtoService.salvarProduto(produto);
		
		assertNotNull(resultado);
		assertEquals("caixa de bombom", resultado.getNome());
		assertTrue(resultado.getId() > 0);
	}
	
	@DisplayName("Testando listar todos produto")
	@Test
	void testListarTodos() {
		Produto produto1 = new Produto (null, "caixa de bombom", "chocolates nestle", 15.5);
		Produto produto2 = new Produto (null, "Sabonete", "Sabonete dove", 5.0);
		
		produtoService.salvarProduto(produto1);
		produtoService.salvarProduto(produto2);
		
		List<Produto> resultado = produtoService.buscarTodos();
		
		assertNotNull(resultado);
		assertEquals(2, resultado.size());
	}
	
	@DisplayName("Testando buscar por id produto")
	@Test
	void testBuscarPorId() {
		Produto produto1 = new Produto (null, "caixa de bombom", "chocolates nestle", 15.5);
		
		Produto salvo = produtoService.salvarProduto(produto1);
		Optional<Produto> resultado = produtoService.buscarPorId(salvo.getId());
		
		assertTrue(resultado.isPresent());
		assertEquals("caixa de bombom", resultado.get().getNome());
	}
	
	@DisplayName("Testando o atualizar produto")
	@Test
	void testAturalizarProduto() {
		Produto produto1 = new Produto (null, "caixa de bombom", "chocolates nestle", 15.5);
		Produto salvo = produtoService.salvarProduto(produto1);
		
		salvo.setNome("Sabonete");
		salvo.setDescricao("sabonete dove");
		
		Produto atualizado = produtoService.atualizarProduto(salvo);
		
		assertNotNull(atualizado);
		assertEquals("Sabonete", atualizado.getNome());
		assertEquals("sabonete dove", atualizado.getDescricao());
	}
	
	@DisplayName("Testando o deletar produto")
	@Test
	void testDeletarProduto() {
		Produto produto1 = new Produto (null, "caixa de bombom", "chocolates nestle", 15.5);
		
		Produto salvo = produtoService.salvarProduto(produto1);
		produtoService.deletarProduto(salvo.getId());
		
		Optional<Produto> resultado = produtoService.buscarPorId(salvo.getId());
		
		assertTrue(resultado.isEmpty());
	}
}
