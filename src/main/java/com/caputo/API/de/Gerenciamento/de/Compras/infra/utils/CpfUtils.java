package com.caputo.API.de.Gerenciamento.de.Compras.infra.utils;

public class CpfUtils {

  public static String maskCpf(String cpf) {
    cpf = cpf.replaceAll("\\D", "");

    if (cpf.length() != 11) {
      throw new IllegalArgumentException("CPF inválido");
    }

    return cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
  }

}
