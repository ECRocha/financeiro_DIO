package com.ederson.financeiro.resource;

import com.ederson.financeiro.dto.TransacaoDTO;
import com.ederson.financeiro.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transacoes")
public class TransacaoController {
    private final TransacaoService service;

    @Autowired
    public TransacaoController(TransacaoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<TransacaoDTO> criarTransacao(@RequestBody TransacaoDTO dto) {
        TransacaoDTO criada = service.salvarTransacao(dto);
        return ResponseEntity.ok(criada);
    }

    @GetMapping
    public ResponseEntity<List<TransacaoDTO>> obterTransacoes() {
        return ResponseEntity.ok(service.obterTodasTransacoes());
    }
}

