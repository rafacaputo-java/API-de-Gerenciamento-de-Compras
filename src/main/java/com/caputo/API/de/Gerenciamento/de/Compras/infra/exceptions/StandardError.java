package com.caputo.API.de.Gerenciamento.de.Compras.infra.exceptions;

import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StandardError {

  private Instant timestamp;
  private Integer status;
  private String error;
  private String message;
  private String path;

}
