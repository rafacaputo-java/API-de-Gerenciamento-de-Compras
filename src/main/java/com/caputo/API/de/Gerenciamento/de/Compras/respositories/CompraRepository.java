package com.caputo.API.de.Gerenciamento.de.Compras.respositories;

import com.caputo.API.de.Gerenciamento.de.Compras.model.entities.Compra;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {

  @Query("SELECT c FROM Compra c WHERE c.cpfComprador = :cpfComprador AND c.nomeProduto = :nomeProduto")
  List<Compra> findByCpfCompradorAndNomeProduto(String cpfComprador, String nomeProduto);

  @Query("SELECT c FROM Compra c WHERE " +
      "(:cpfComprador IS NULL OR c.cpfComprador LIKE %:cpfComprador%) AND " +
      "(:nomeProduto IS NULL OR LOWER(c.nomeProduto) LIKE LOWER(CONCAT('%', :nomeProduto, '%'))) AND " +
      "(:dataInicio IS NULL OR c.dataHoraCompra >= :dataInicio) AND " +
      "(:dataFim IS NULL OR c.dataHoraCompra < :dataFim)") // Use dataFim
  List<Compra> filtrarCompras(@Param("cpfComprador") String cpfComprador,
      @Param("nomeProduto") String nomeProduto,
      @Param("dataInicio") LocalDateTime dataInicio,
      @Param("dataFim") LocalDateTime dataFim); // Adicione dataFim


  List<Compra> findByDataHoraCompraBetween(LocalDateTime dataInicio, LocalDateTime dataFim);


}
