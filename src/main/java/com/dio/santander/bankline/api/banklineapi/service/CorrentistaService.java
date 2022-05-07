package com.dio.santander.bankline.api.banklineapi.service;

import java.util.Date;

import com.dio.santander.bankline.api.banklineapi.DTO.CorrentistaDTO;
import com.dio.santander.bankline.api.banklineapi.model.Conta;
import com.dio.santander.bankline.api.banklineapi.model.Correntista;
import com.dio.santander.bankline.api.banklineapi.repository.CorrentistaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CorrentistaService {

    @Autowired
    private CorrentistaRepository repository;

    public void save(CorrentistaDTO correntistaDto) {
        Correntista correntista = new Correntista();
        correntista.setCpf(correntistaDto.getCpf());
        correntista.setNome(correntistaDto.getNome());
        
        Conta conta = new Conta();
        conta.setSaldo(0.0);
        conta.setNumero(new Date().getTime());
        
        correntista.setConta(conta);
        repository.save(correntista);

    }
}
