package com.devsuperior.dsmeta.mappers;

import com.devsuperior.dsmeta.dto.RelatorioDTO;
import com.devsuperior.dsmeta.dto.SellerDTO;
import com.devsuperior.dsmeta.entities.Seller;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SellerMapper {

    public List<RelatorioDTO> sellerToDTO(List<RelatorioDTO> relatorioDTO){
        Map<Long, RelatorioDTO> mapRelatorio = new HashMap<>();

        relatorioDTO.forEach(relatorio -> {
            Long id = relatorio.getId();
            LocalDate date = relatorio.getDate();
            RelatorioDTO responseRelatorio = mapRelatorio.getOrDefault(id, createDefaultRelatorio(relatorio));
            Double amountTotal = responseRelatorio.getAmount();
            Double amountAtual = relatorio.getAmount();
            responseRelatorio.setAmount(amountTotal + amountAtual);

            if(date.isAfter(responseRelatorio.getDate())){
                responseRelatorio.setDate(date);
            }

            mapRelatorio.put(id, responseRelatorio);

        });
        return mapRelatorio.values().stream().toList();
    }

    private RelatorioDTO createDefaultRelatorio(RelatorioDTO relatorioDTO){
        RelatorioDTO relatorio = new RelatorioDTO();
        relatorio.setId(relatorioDTO.getId());
        relatorio.setName(relatorioDTO.getName());
        relatorio.setAmount(0.0);
        relatorio.setDate(relatorioDTO.getDate());
        return relatorio;
    }
}
