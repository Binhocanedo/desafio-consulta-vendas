package com.devsuperior.dsmeta.controllers;

import com.devsuperior.dsmeta.dto.RelatorioDTO;
import com.devsuperior.dsmeta.dto.ResponseReportDTO;
import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.dto.SalesSummaryDTO;
import com.devsuperior.dsmeta.entities.Seller;
import com.devsuperior.dsmeta.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

	@Autowired
	private SaleService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<SaleMinDTO> findById(@PathVariable Long id) {
		SaleMinDTO dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}

	@GetMapping(value = "/report")
	public ResponseEntity<ResponseReportDTO> getReport(@RequestParam(value = "name", required = false) String name,
													   @RequestParam(value = "minDate", required = false) String minDate,
													   @RequestParam(value = "maxDate", required = false) String maxDate) {
		ResponseReportDTO report = service.getReportSellers(name, minDate, maxDate);
		return ResponseEntity.ok(report);
	}

	@GetMapping(value = "/summary")
	public ResponseEntity<List<SalesSummaryDTO>> getSummary(@RequestParam(value = "minDate", required = false) String minDate,
															@RequestParam(value = "maxDate", required = false) String maxDate) {
		List<SalesSummaryDTO> summary = service.getSalesSummary(minDate, maxDate);
		return ResponseEntity.ok(summary);
	}

	@GetMapping(value = "/relatorio")
	public ResponseEntity<List<RelatorioDTO>> getSeller (@RequestParam(value = "minDate", required = false) String minDate,
												         @RequestParam(value = "maxDate", required = false) String maxDate){
		List<RelatorioDTO> relatorio = service.getRelatorio(minDate, maxDate);
		return ResponseEntity.ok(relatorio);
	}
}