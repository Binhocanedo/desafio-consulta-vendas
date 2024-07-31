package com.devsuperior.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import com.devsuperior.dsmeta.dto.SalesSummaryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	public SaleMinDTO findById(Long id) {
		Optional<Sale> result = repository.findById(id);
		Sale entity = result.get();
		return new SaleMinDTO(entity);
	}

	public List<SalesSummaryDTO> getSalesSummary(String minDate, String maxDate){

		LocalDate endDate = (maxDate != null) ? LocalDate.parse(maxDate) : LocalDate.now();
		LocalDate startDate;

		if(minDate != null){
			startDate = LocalDate.parse(minDate);
		}else{
			startDate = endDate.minusYears(1L);
		}

		return repository.findSalesSummary(startDate, endDate);
	}
}