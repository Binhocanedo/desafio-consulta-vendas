package com.devsuperior.dsmeta.controllers;

import com.devsuperior.dsmeta.dto.SalesSummaryDTO;
import com.devsuperior.dsmeta.entities.Sale;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.services.SaleService;

import java.time.LocalDate;
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
	public ResponseEntity<?> getReport() {
		// TODO
		return null;
	}

	@GetMapping(value = "/summary")
	public ResponseEntity<List<SalesSummaryDTO>> getSummary(@RequestParam(value = "minDate", required = false) String minDate, @RequestParam(value = "maxDate", required = false) String maxDate) {
		List<SalesSummaryDTO> summary = service.getSalesSummary(minDate, maxDate);
		return ResponseEntity.ok(summary);
	}
}