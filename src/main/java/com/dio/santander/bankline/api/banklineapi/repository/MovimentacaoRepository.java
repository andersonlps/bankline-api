package com.dio.santander.bankline.api.banklineapi.repository;

import com.dio.santander.bankline.api.banklineapi.model.Movimentacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer> {
    
}
