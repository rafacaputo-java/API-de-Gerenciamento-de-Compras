package com.caputo.API.de.Gerenciamento.de.Compras.services.impl;

import com.caputo.API.de.Gerenciamento.de.Compras.exceptions.InvalidEntityException;
import com.caputo.API.de.Gerenciamento.de.Compras.mappers.CompraMapper;
import com.caputo.API.de.Gerenciamento.de.Compras.model.dto.request.CompraRequest;
import com.caputo.API.de.Gerenciamento.de.Compras.model.dto.response.RelatorioComprasDTO;
import com.caputo.API.de.Gerenciamento.de.Compras.model.dto.response.CompraResponse;
import com.caputo.API.de.Gerenciamento.de.Compras.model.entities.Compra;
import com.caputo.API.de.Gerenciamento.de.Compras.respositories.CompraRepository;
import com.caputo.API.de.Gerenciamento.de.Compras.services.CompraService;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompraServiceImpl implements CompraService {

  private final CompraRepository compraRepository;

  private final CompraMapper compraMapper;

  public CompraResponse registrarCompra(CompraRequest compraRequest) {

    List<Compra> comprasExistentes = compraRepository.findByCpfCompradorAndNomeProduto(compraRequest.getCpfComprador(), compraRequest.getNomeProduto());
    var totalComprado = comprasExistentes.stream().mapToLong(Compra::getQuantidade).sum();

    if (totalComprado + compraRequest.getQuantidade() > 3) {
      throw new InvalidEntityException("Um mesmo CPF não pode comprar mais de 3 unidades do mesmo produto");
    }

    return compraMapper.toResponse(compraRepository.save(compraMapper.toEntity(compraRequest)));
  }

  public List<CompraResponse> pesquisarCompras(String cpfComprador, String nomeProduto, LocalDate dataInicio) {
    LocalDateTime inicioDoDia = gerarDataIncio(dataInicio);
    LocalDateTime fimDoDia = gerarDataFim(dataInicio);

    var comprasFiltradas = compraRepository.filtrarCompras(cpfComprador, nomeProduto, inicioDoDia, fimDoDia);

    return comprasFiltradas.stream()
        .map(compraMapper::toResponse)
        .collect(Collectors.toList());
  }

  public List<RelatorioComprasDTO> gerarRelatorio(LocalDate dataInicio) {
    LocalDateTime inicioDoDia = gerarDataIncio(dataInicio);
    LocalDateTime fimDoDia = gerarDataFim(dataInicio);
    List<RelatorioComprasDTO> relatorio = new ArrayList<>();

    List<Compra> compras = compraRepository.findByDataHoraCompraBetween(inicioDoDia, fimDoDia);

    Map<String, RelatorioComprasDTO> mapRelatorio = new HashMap<>();

    for (Compra compra : compras) {
      String nomeProduto = compra.getNomeProduto();
      RelatorioComprasDTO dto = mapRelatorio.getOrDefault(nomeProduto, new RelatorioComprasDTO());

      if (dto.getTotalVendido() == null) {
        dto.setTotalVendido(BigDecimal.ZERO);
      }

      dto.setNomeProduto(nomeProduto);
      dto.setValorUnitario(compra.getValorUnitario());

      dto.setQuantidadeCompras(
          dto.getQuantidadeCompras() == null ? compra.getQuantidade() :
              dto.getQuantidadeCompras() + compra.getQuantidade()
      );

      dto.setTotalVendido(dto.getTotalVendido().add(compra.getValorUnitario().multiply(BigDecimal.valueOf(compra.getQuantidade()))));

      mapRelatorio.put(nomeProduto, dto);
    }

    relatorio.addAll(mapRelatorio.values());
    return relatorio;
    }

    public LocalDateTime gerarDataIncio(LocalDate dataInicio){
      return dataInicio != null ? dataInicio.atStartOfDay() : null;
    }

    public LocalDateTime gerarDataFim(LocalDate dataInicio){
    return  dataInicio != null ? dataInicio.plusDays(1).atStartOfDay() : null;
    }



}
