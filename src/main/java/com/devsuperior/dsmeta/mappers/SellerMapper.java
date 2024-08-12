package com.devsuperior.dsmeta.mappers;

import com.devsuperior.dsmeta.dto.SellerDTO;
import com.devsuperior.dsmeta.entities.Seller;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SellerMapper {

    private List<Seller> sellerToDTO(List<Seller> sellerList){
        Map<Long, Seller> mapSeller = new HashMap<>();

        sellerList.forEach(seller -> {
            Seller sellerDTO =
                    mapSeller.getOrDefault(seller.getId(), sellerMapper(seller));
        });
        return null;
    }

    private SellerDTO sellerMapper(Seller seller){
        SellerDTO sellerDTO = new SellerDTO();
        sellerDTO.setId(seller.getId());
        sellerDTO.setName(seller.getName());
        sellerDTO.setEmail((seller.getEmail()));
        sellerDTO.setPhone(seller.getPhone());

        return sellerDTO;
    }
}
