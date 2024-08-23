package com.devsuperior.dsmeta.mappers;

import com.devsuperior.dsmeta.dto.RelatorioDTO;
import com.devsuperior.dsmeta.dto.SellerDTO;
import com.devsuperior.dsmeta.entities.Seller;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SellerMapper {

    private List<RelatorioDTO> sellerToDTO(List<RelatorioDTO> relatorioDTO){
        Map<Long, RelatorioDTO> mapRelatorio = new HashMap<>();

        relatorioDTO.forEach(relatorio -> {
            Long id = relatorio.getId();
            RelatorioDTO responseRelatorio = mapRelatorio.getOrDefault(id, createDefaultRelatorio(relatorio));
            Double amountTotal = responseRelatorio.getAmount();
            Double amountAtual = relatorio.getAmount();
            responseRelatorio.setAmount(amountTotal + amountAtual);
            mapRelatorio.put(id, responseRelatorio);
        });
        return mapRelatorio.values().stream().toList();
    }

    private RelatorioDTO createDefaultRelatorio(RelatorioDTO relatorioDTO){
        RelatorioDTO relatorio = new RelatorioDTO();
        relatorio.setId(relatorioDTO.getId());
        relatorio.setName(relatorioDTO.getName());
        relatorio.setAmount(0.0);
        return relatorio;
    }
}
