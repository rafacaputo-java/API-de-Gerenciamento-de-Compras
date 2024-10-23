package com.caputo.API.de.Gerenciamento.de.Compras.controllers;

import com.caputo.API.de.Gerenciamento.de.Compras.model.dto.request.CompraRequest;
import com.caputo.API.de.Gerenciamento.de.Compras.model.dto.response.RelatorioComprasDTO;
import com.caputo.API.de.Gerenciamento.de.Compras.model.dto.response.CompraResponse;
import com.caputo.API.de.Gerenciamento.de.Compras.services.CompraService;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/compras")
public class CompraController {

  private final CompraService compraService;

  @PostMapping
  public ResponseEntity<CompraResponse> registrarCompra (@RequestBody CompraRequest compra) {
    CompraResponse novaCompra = compraService.registrarCompra(compra);
    return ResponseEntity.ok(novaCompra);
  }

  @GetMapping("/pesquisar")
  public ResponseEntity<List<CompraResponse>> pesquisarCompras (
      @RequestParam(required = false) String cpfComprador,
      @RequestParam(required = false) String nomeProduto,
      @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataInicio) {
    return ResponseEntity.ok(compraService.pesquisarCompras(cpfComprador, nomeProduto, dataInicio));
  }

  @GetMapping("/relatorio")
  public ResponseEntity<List<RelatorioComprasDTO>> obterRelatorio (
      @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataInicio) {
    return ResponseEntity.ok(compraService.gerarRelatorio(dataInicio));
  }

}
