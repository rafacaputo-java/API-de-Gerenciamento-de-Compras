package com.caputo.API.de.Gerenciamento.de.Compras.services;

import com.caputo.API.de.Gerenciamento.de.Compras.model.dto.request.CompraRequest;
import com.caputo.API.de.Gerenciamento.de.Compras.model.dto.response.CompraResponse;
import com.caputo.API.de.Gerenciamento.de.Compras.model.dto.response.RelatorioComprasDTO;
import java.time.LocalDate;
import java.util.List;

public interface CompraService {

  CompraResponse registrarCompra(CompraRequest compraRequest);

  List<CompraResponse> pesquisarCompras(String cpfComprador, String nomeProduto, LocalDate dataInicio);

  List<RelatorioComprasDTO> gerarRelatorio(LocalDate dataInicio);

}
