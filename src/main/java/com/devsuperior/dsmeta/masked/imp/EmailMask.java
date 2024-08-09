package com.devsuperior.dsmeta.masked.imp;

import com.devsuperior.dsmeta.dto.SellerPerSaleDTO;
import com.devsuperior.dsmeta.masked.MaskApply;
import org.springframework.stereotype.Component;

@Component
public class EmailMask implements MaskApply {

    @Override
    public void applyMask(SellerPerSaleDTO seller) {
        String email = seller.getEmail();
        String maskedEmail = email.replaceAll("(^.).*(.@)", "$1***$2");
        seller.setEmail(maskedEmail);
    }
}
