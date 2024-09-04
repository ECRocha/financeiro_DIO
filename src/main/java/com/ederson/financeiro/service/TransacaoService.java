package com.ederson.financeiro.service;

import com.ederson.financeiro.dto.TransacaoDTO;
import com.ederson.financeiro.enums.TipoTransacao;
import com.ederson.financeiro.model.Transacao;
import com.ederson.financeiro.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransacaoService {
    private final TransacaoRepository repository;

    @Autowired
    public TransacaoService(TransacaoRepository repository) {
        this.repository = repository;
    }

    public TransacaoDTO salvarTransacao(TransacaoDTO dto) {
        Transacao transacao = new Transacao();
        transacao.setDescricao(dto.getDescricao());
        transacao.setValor(dto.getValor());
        transacao.setData(dto.getData());
        transacao.setTipo(TipoTransacao.valueOf(dto.getTipo()));
        repository.save(transacao);
        return dto;
    }

    public List<TransacaoDTO> obterTodasTransacoes() {
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    private TransacaoDTO toDTO(Transacao transacao) {
        TransacaoDTO dto = new TransacaoDTO();
        dto.setDescricao(transacao.getDescricao());
        dto.setValor(transacao.getValor());
        dto.setData(transacao.getData());
        dto.setTipo(transacao.getTipo().name());
        return dto;
    }
}

