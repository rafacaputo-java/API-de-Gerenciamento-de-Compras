package com.caputo.API.de.Gerenciamento.de.Compras.model.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Table(name = "compra")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Compra {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String produtoId;

  @Column(nullable = false)
  private String nomeProduto;

  @Column(nullable = false)
  private Long quantidade;

  @Column(nullable = false)
  private String cpfComprador;

  @Column(nullable = false)
  private BigDecimal valorUnitario;

  @Column(name = "data_hora_compra")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime dataHoraCompra;

}
