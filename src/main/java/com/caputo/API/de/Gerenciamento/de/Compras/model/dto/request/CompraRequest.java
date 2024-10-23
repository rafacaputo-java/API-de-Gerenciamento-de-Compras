package com.caputo.API.de.Gerenciamento.de.Compras.model.dto.request;

import jakarta.validation.constraints.Pattern;
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

  @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")
  private String cpfComprador;

  private BigDecimal valorUnitario;

}
