package com.cf.firm.controller;

import java.net.URI;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cf.firm.bean.Firm;
import com.cf.firm.dao.FirmDao;

@RestController
public class FirmController {
	
	@Autowired
	private FirmDao fDao;
	
	@GetMapping(path="/firm",produces="application/json")
	public List<Firm> getAllFirms(){
		return fDao.findAll();
	}
	
	@GetMapping(path = "/firm/cicle", produces = "application/json")
	public List<Firm> getcicleAssets() {
		int currentYear = Calendar.getInstance().getWeekYear();
		return fDao.findByYearCicle(currentYear-6, currentYear);
	}
	
	@PostMapping(path = "/firm", consumes = "application/json",produces="application/json")
	public ResponseEntity<?> saveAllAssets(@RequestBody List<Firm> firms) {
		if(!firms.isEmpty()) {
			List<Firm> savedFirms = fDao.saveAll(firms);
			URI location = null;
			if (!savedFirms.isEmpty())
				location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/firm/firm/cicle").buildAndExpand()
						.toUri();
			return ResponseEntity.created(location).build();
		}else {
			return ResponseEntity.noContent().build(); 
		} 
	}
	
	@PutMapping(path = "/firm", consumes = "application/json")
	public ResponseEntity<?> updateAllAssets(@RequestBody List<Firm> firms) {

		if (!firms.isEmpty()) {
			for (Firm firm : firms) {
				Firm existing = fDao.findById(firm.getId()).get();
				if (existing != null && existing.getId() > 0) {
					existing.setYear(firm.getYear());
					existing.setAmount(firm.getAmount());
					fDao.saveAndFlush(existing);
				} else {
					return ResponseEntity.notFound().build();
				}
			}
		} else {
			return ResponseEntity.noContent().build();
		}
		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/firm/cicle").buildAndExpand()
				.toUri();
		return ResponseEntity.created(location).build();
	}

}
