package com.projetoAvaliacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoAvaliacao.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
