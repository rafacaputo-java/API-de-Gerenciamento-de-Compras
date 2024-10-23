package com.caputo.API.de.Gerenciamento.de.Compras.model.dto.request;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompraRequest {

  private String produtoId;

  private String nomeProduto;

  private Long quantidade;

  private String cpfComprador;

  private BigDecimal valorUnitario;

}
