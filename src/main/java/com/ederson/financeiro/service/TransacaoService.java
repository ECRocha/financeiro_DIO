package com.ederson.financeiro.service;

import com.ederson.financeiro.dto.TransacaoDTO;
import com.ederson.financeiro.enums.TipoTransacao;
import com.ederson.financeiro.model.Transacao;
import com.ederson.financeiro.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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

        if (dto == null) {
            throw new IllegalArgumentException("Não pode ser nulo.");
        }
        if (dto.getDescricao() == null || dto.getDescricao().isEmpty()) {
            throw new IllegalArgumentException("A descrição não pode ser vazia.");
        }
        if (dto.getValor() == null || dto.getValor().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("O valor deve ser positivo.");
        }
        if (dto.getTipo() == null || !isValidTipo(dto.getTipo())) {
            throw new IllegalArgumentException("Tipo de transação inválido: " + dto.getTipo());
        }

        Transacao transacao = new Transacao();
        transacao.setDescricao(dto.getDescricao());
        transacao.setValor(dto.getValor());
        transacao.setTipo(TipoTransacao.valueOf(dto.getTipo()));

        Transacao savedTransacao = repository.save(transacao);

        return toDTO(savedTransacao);
    }

    public List<TransacaoDTO> obterTodasTransacoes() {
        return repository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private boolean isValidTipo(String tipo) {
        try {
            TipoTransacao.valueOf(tipo);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    private TransacaoDTO toDTO(Transacao transacao) {
        TransacaoDTO dto = new TransacaoDTO();
        dto.setDescricao(transacao.getDescricao());
        dto.setValor(transacao.getValor());
        dto.setTipo(transacao.getTipo().name());
        return dto;
    }
}
