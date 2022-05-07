package com.dio.santander.bankline.api.banklineapi.controller;

import java.util.List;

import com.dio.santander.bankline.api.banklineapi.DTO.CorrentistaDTO;
import com.dio.santander.bankline.api.banklineapi.model.Correntista;
import com.dio.santander.bankline.api.banklineapi.repository.CorrentistaRepository;
import com.dio.santander.bankline.api.banklineapi.service.CorrentistaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/correntistas")
public class CorrentistaController {
    
    @Autowired
    private CorrentistaRepository repository;

    @Autowired
    private CorrentistaService service;

    @GetMapping
    public List<Correntista> findAll(){
        return repository.findAll();
    }

    @PostMapping
    public void save(@RequestBody CorrentistaDTO correntista) {
        service.save(correntista);
    }
}
