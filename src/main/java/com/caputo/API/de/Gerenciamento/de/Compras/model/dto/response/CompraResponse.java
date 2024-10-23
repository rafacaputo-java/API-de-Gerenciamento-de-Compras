package com.caputo.API.de.Gerenciamento.de.Compras.model.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompraResponse {

  private Long id;

  private String produtoId;

  private String nomeProduto;

  private Long quantidade;

  private String cpfComprador;

  private BigDecimal valorUnitario;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime dataHoraCompra;

}
