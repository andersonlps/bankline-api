package com.dio.santander.bankline.api.banklineapi.controller;

import java.util.List;
import com.dio.santander.bankline.api.banklineapi.DTO.MovimentacaoDTO;
import com.dio.santander.bankline.api.banklineapi.model.Movimentacao;
import com.dio.santander.bankline.api.banklineapi.repository.MovimentacaoRepository;
import com.dio.santander.bankline.api.banklineapi.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {
    
    @Autowired
    private MovimentacaoRepository repository;

    @Autowired
    private MovimentacaoService service;

    @GetMapping
    public List<Movimentacao> findAll(){
        return repository.findAll();
    }

    @GetMapping("/{idConta}")
    public List<Movimentacao> findAll(@PathVariable("idConta") Integer idConta){
    return repository.findByIdConta(idConta);
}

    @PostMapping
    public void save(@RequestBody MovimentacaoDTO movimentacao) {
        service.save(movimentacao);
    }
}
