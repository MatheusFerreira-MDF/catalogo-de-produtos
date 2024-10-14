package com.projeto.sistema.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.sistema.modelos.Produtos;

public interface ProdutosRepositorio extends JpaRepository<Produtos, Long> {

}
