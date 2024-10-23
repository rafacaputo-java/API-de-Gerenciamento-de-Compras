package com.caputo.API.de.Gerenciamento.de.Compras.model.dto.response;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RelatorioComprasDTO {

  private String nomeProduto;
  private BigDecimal valorUnitario;
  private Long quantidadeCompras;
  private BigDecimal totalVendido;

}
