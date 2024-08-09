package com.devsuperior.dsmeta.masked;

import com.devsuperior.dsmeta.dto.SellerPerSaleDTO;
import org.springframework.stereotype.Component;

@Component
public interface MaskApply {
    void applyMask(SellerPerSaleDTO seller);
}
