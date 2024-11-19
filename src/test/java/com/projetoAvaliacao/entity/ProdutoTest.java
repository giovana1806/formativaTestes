package com.projetoAvaliacao.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class ProdutoTest {
	private Produto produto;
	
	@BeforeEach
	void setUp() {
		//Arrange
		produto = new Produto(1L, "caixa de bombom", "chocolates nestle", 15.5);
	}

	@Test
	@DisplayName("Testando o getter e setter do id")
	void testId() {
		//Act
		produto.setId(2L);
		//Assert
		assertEquals(2L, produto.getId());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do nome")
	void testNome() {
		//Act
		produto.setNome("Sabonete");
		//Assert
		assertEquals("Sabonete", produto.getNome());
	}
	
	@Test
	@DisplayName("Testando o getter e setter da descricao")
	void testDescricao() {
		//Act
		produto.setDescricao("sabonete dove");
		//Assert
		assertEquals("sabonete dove", produto.getDescricao());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do preco")
	void testPreco() {
		//Act
		produto.setPreco(3.0);
		//Assert
		assertEquals(3.0, produto.getPreco());
	}
	
	@Test
	@DisplayName("Testando o construtor com todos os argumentos")
	void testConstrutorAll() {
		//Act
		Produto novoProduto = new Produto(3L, "Sabonete", "sabonete dove", 3.0);
		//Assert
		assertAll("novoProduto",
				()-> assertEquals(3L, novoProduto.getId()),
				()-> assertEquals("Sabonete", novoProduto.getNome()),
				()-> assertEquals("sabonete dove", novoProduto.getDescricao()),
				()-> assertEquals(3.0, novoProduto.getPreco()));
	}
}
