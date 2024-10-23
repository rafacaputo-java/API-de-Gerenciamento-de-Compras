package com.caputo.API.de.Gerenciamento.de.Compras.mappers;

import com.caputo.API.de.Gerenciamento.de.Compras.model.dto.request.CompraRequest;
import com.caputo.API.de.Gerenciamento.de.Compras.model.dto.response.CompraResponse;
import com.caputo.API.de.Gerenciamento.de.Compras.model.entities.Compra;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;

@Component
public class CompraMapper {

  public Compra toEntity(CompraRequest compraRequest){
    return Compra.builder()
        .produtoId(compraRequest.getProdutoId())
        .nomeProduto(compraRequest.getNomeProduto())
        .quantidade(compraRequest.getQuantidade())
        .cpfComprador(compraRequest.getCpfComprador())
        .valorUnitario(compraRequest.getValorUnitario())
        .dataHoraCompra(LocalDateTime.now())
        .build();
  }

  public CompraResponse toResponse(Compra compra){
    return CompraResponse.builder()
        .id(compra.getId())
        .produtoId(compra.getProdutoId())
        .nomeProduto(compra.getNomeProduto())
        .quantidade(compra.getQuantidade())
        .cpfComprador(compra.getCpfComprador())
        .valorUnitario(compra.getValorUnitario())
        .dataHoraCompra(LocalDateTime.now())
        .build();
  }

}
