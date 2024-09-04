package com.ederson.financeiro.dto;

import java.math.BigDecimal;

public class TransacaoDTO {

    private String descricao;
    private BigDecimal valor;
    private String tipo;

    public TransacaoDTO() {}

    public TransacaoDTO(String descricao, BigDecimal valor, String tipo){
        this.descricao = descricao;
        this.valor = valor;
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
