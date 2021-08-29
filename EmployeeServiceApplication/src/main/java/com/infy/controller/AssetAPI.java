package com.infy.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.dto.AssetDTO;
import com.infy.exception.AssetServiceException;
import com.infy.service.AssetService;

@RestController
@CrossOrigin
@RequestMapping("/InfyAsset")
public class AssetAPI {

	@Autowired
	Environment environment;
	
	@Autowired
	private AssetService assetService;
	
	@GetMapping("/assets")
	public ResponseEntity<List<AssetDTO>> getAssets() throws AssetServiceException {

		List<AssetDTO> assetList = this.assetService.getAssets();
		return new ResponseEntity<>(assetList, HttpStatus.OK);

	}

	@GetMapping(value = "/asset/{assetId}")
	public ResponseEntity<AssetDTO> getAsset(@PathVariable String assetId) throws AssetServiceException {
		AssetDTO asset = assetService.getAsset(assetId);
		return new ResponseEntity<>(asset, HttpStatus.OK);
	}

	@PostMapping(value = "/asset")
	public ResponseEntity<String> addAsset(@RequestBody AssetDTO asset) throws AssetServiceException {
		assetService.addAsset(asset);
		return new ResponseEntity<>(environment.getProperty("asset.ASSET_INSERTION_SUCCESSFULL"),
				HttpStatus.OK);
	}

	@PutMapping(value = "/asset/{assetId}")
	public ResponseEntity<String> updateAsset(@PathVariable String assetId, @RequestBody AssetDTO asset)
			throws AssetServiceException {
		assetService.updateAsset(assetId, asset);
		return new ResponseEntity<>(environment.getProperty("asset.ASSET_UPDATE_SUCCESSFULL"),
				HttpStatus.OK);

	}

	@DeleteMapping(value = "/asset/{assetId}")
	public ResponseEntity<String> deleteAsset(@PathVariable String assetId) throws AssetServiceException {
		assetService.deleteAsset(assetId);
		return new ResponseEntity<>(environment.getProperty("asset.ASSET_DELETED_SUCCESSFULL"),
				HttpStatus.OK);
	}
	
}
