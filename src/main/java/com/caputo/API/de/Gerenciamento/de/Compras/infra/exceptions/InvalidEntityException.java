package com.caputo.API.de.Gerenciamento.de.Compras.infra.exceptions;

public class InvalidEntityException extends RuntimeException {

  public InvalidEntityException(String message) {
    super(message);
  }
}
