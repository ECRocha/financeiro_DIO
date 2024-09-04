package com.ederson.financeiro.repository;

import com.ederson.financeiro.enums.TipoTransacao;
import com.ederson.financeiro.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    List<Transacao> findByTipo(TipoTransacao tipo);
}
