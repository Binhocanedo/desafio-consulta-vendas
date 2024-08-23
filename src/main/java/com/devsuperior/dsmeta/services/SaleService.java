package com.devsuperior.dsmeta.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.devsuperior.dsmeta.dto.*;
import com.devsuperior.dsmeta.mappers.SellerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service
public class SaleService{

	@Autowired
	private SaleRepository repository;

	@Autowired
	private SellerMapper mapper;

	public SaleMinDTO findById(Long id) {
		Optional<Sale> result = repository.findById(id);
		Sale entity = result.get();
		return new SaleMinDTO(entity);
	}

	public List<SalesSummaryDTO> getSalesSummary(String minDate, String maxDate){

		LocalDate endDate = maxDate != null ? LocalDate.parse(maxDate) : LocalDate.now();
		LocalDate startDate = minDate != null ? LocalDate.parse(minDate) : endDate.minusYears(1L);

		return repository.findSalesSummary(startDate, endDate);
	}

	public ResponseReportDTO getReportSellers(String name, String minDate, String maxDate){

		LocalDate endDate;
		LocalDate startDate;
		String nameFilter = (name != null && !name.isEmpty()) ? name : "";
		boolean noParams = (minDate == null || minDate.isEmpty()) && (maxDate == null || nameFilter.isEmpty());

		if (noParams) {
			endDate = LocalDate.now();
			startDate = endDate.minusYears(1L);
		} else {
			endDate = (maxDate != null && !maxDate.isEmpty()) ? LocalDate.parse(maxDate) : LocalDate.now();
			startDate = (minDate != null && !minDate.isEmpty()) ? LocalDate.parse(minDate) : endDate.minusYears(1L);
		}


		List<SellerPerSaleDTO> report = repository.findReport(nameFilter, startDate, endDate);

		List<SellerPerSaleDTO> maskedReport = report.stream().peek(seller ->{
			String email = seller.getEmail();
			String maskedEmail = email.replaceAll("(^.).*(.@)", "$1***$2");
			seller.setEmail(maskedEmail);
        }).collect(Collectors.toList());

		ResponseReportDTO response = new ResponseReportDTO();
		response.setContent(maskedReport);

		return response;
	}

	public List<RelatorioDTO> getRelatorio(String minDate, String maxDate){
		List<RelatorioDTO> relatorioDTO = repository.findRelatorio(LocalDate.parse(minDate), LocalDate.parse(maxDate));
		return mapper.sellerToDTO(relatorioDTO);
	}
}