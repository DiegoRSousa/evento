package com.uepb.evento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uepb.evento.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
