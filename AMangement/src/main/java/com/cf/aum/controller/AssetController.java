package com.cf.aum.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cf.aum.bean.Asset;
import com.cf.aum.dao.AssetsDao;


@RestController
@RequestMapping(path = "/aum")
public class AssetController {

	@Autowired
	private AssetsDao aDao;

	@GetMapping(path = "/assets", produces = "application/json")
	public List<Asset> getAllAssets() {
		return aDao.findAll();
	}
	
	@GetMapping(path = "/assets/cicle", produces = "application/json")
	public List<Asset> getcicleAssets() {
		List<Asset> cicleAssets = new ArrayList<Asset>();
		Long currentYear = (long) Calendar.getInstance().getWeekYear();
		cicleAssets = aDao.findByYearCicle(currentYear-6, currentYear);
		return cicleAssets;
	}

	@GetMapping(path = "/assets/discretionary/{type}", produces = "application/json")
	public List<Asset> getAllAssets(@PathVariable Long type) {
		return aDao.findByDiscretionary(type);
	}

	@PostMapping(path = "/assets", consumes = "application/json",produces="application/json")
	public ResponseEntity<?> saveAllAssets(@RequestBody List<Asset> assets) {
		if(!assets.isEmpty()) {
			List<Asset> savedAssets = aDao.saveAll(assets);
			URI location = null;
			if (!savedAssets.isEmpty())
				location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/schwab/assets/cicle").buildAndExpand()
						.toUri();
			return ResponseEntity.created(location).build();
		}else {
			return ResponseEntity.noContent().build(); 
		} 
	}

	@PutMapping(path = "/assets", consumes = "application/json")
	public ResponseEntity<?> updateAllAssets(@RequestBody List<Asset> assets) {

		if (!assets.isEmpty()) {
			for (Asset asset : assets) {
				Asset existing = aDao.findById(asset.getId()).get();
				if (existing != null && existing.getId() > 0) {
					existing.setYear(asset.getYear());
					existing.setAmount(asset.getAmount());
					existing.setDiscretionary(asset.getDiscretionary());
					aDao.saveAndFlush(existing);
				} else {
					return ResponseEntity.notFound().build();
				}
			}
		} else {
			return ResponseEntity.noContent().build();
		}
		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/aum/assets/cicle").buildAndExpand()
				.toUri();
		return ResponseEntity.created(location).build();
	}

}
