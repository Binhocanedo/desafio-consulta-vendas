package com.devsuperior.dsmeta.masked.imp;

import com.devsuperior.dsmeta.dto.SellerPerSaleDTO;
import com.devsuperior.dsmeta.masked.MaskApply;
import org.springframework.stereotype.Component;

@Component
public class PhoneMask implements MaskApply {
    @Override
    public void applyMask(SellerPerSaleDTO seller) {
        String phone = seller.getPhone();
        String maskedPhone = phone.replaceAll("(^.).*(.{8}$)", "$1 $2");
        seller.setPhone(maskedPhone);
    }
}