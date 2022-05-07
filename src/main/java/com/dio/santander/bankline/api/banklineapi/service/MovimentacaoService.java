package com.dio.santander.bankline.api.banklineapi.service;

import java.time.LocalDateTime;
import com.dio.santander.bankline.api.banklineapi.DTO.MovimentacaoDTO;
import com.dio.santander.bankline.api.banklineapi.model.Correntista;
import com.dio.santander.bankline.api.banklineapi.model.Movimentacao;
import com.dio.santander.bankline.api.banklineapi.model.MovimentacaoTipo;
import com.dio.santander.bankline.api.banklineapi.repository.CorrentistaRepository;
import com.dio.santander.bankline.api.banklineapi.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovimentacaoService {
    @Autowired
    private MovimentacaoRepository repository;
    
    @Autowired
    private CorrentistaRepository correntistaRepository;

    public void save(MovimentacaoDTO movimentacaoDto) {

        Movimentacao movimentacao = new Movimentacao();
        
        //Outra opção para o tipo de movimentação ---- operador ternario
        //Double valor = movimentacaoDto.getTipo()==MovimentacaoTipo.RECEITA ? movimentacaoDto.getValor() : movimentacaoDto.getValor() * -1;

        Double valor = movimentacaoDto.getValor();
        if(movimentacaoDto.getTipo() == MovimentacaoTipo.DESPESA)
        valor = valor * -1;

        movimentacao.setDataHora(LocalDateTime.now());
        movimentacao.setDescricao(movimentacaoDto.getDescricao());
        movimentacao.setId(movimentacaoDto.getIdConta());
        movimentacao.setTipo(movimentacaoDto.getTipo());
        movimentacao.setValor(valor);

        Correntista correntista = correntistaRepository.findById(movimentacaoDto.getIdConta()).orElse(null);
        if(correntista != null) {
            correntista.getConta().setSaldo(correntista.getConta().getSaldo() + valor);
            correntistaRepository.save(correntista);
        }

        repository.save(movimentacao);
    }
}
