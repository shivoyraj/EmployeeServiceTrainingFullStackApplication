package com.infy.service;

import com.infy.repository.AssetRepository;
import com.infy.repository.EmployeeRepository;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.infy.utility.LoggingAspect;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dto.AssetDTO;
import com.infy.entity.Asset;
import com.infy.entity.Employee;
import com.infy.exception.AssetServiceException;

@Service
public class AssetServiceImpl implements AssetService {

	private static final Log LOGGER = LogFactory.getLog(LoggingAspect.class);

	
	@Autowired
	private AssetRepository assetRepo;

	@Autowired
	private EmployeeRepository empRepo;
	



	@Override
	public AssetDTO getAsset(String assetId) throws AssetServiceException {
		Optional<Asset> assetopt= assetRepo.findById(assetId);
		Asset asset= assetopt.orElseThrow(()->new AssetServiceException("asset.ASSET_NOT_PRESENT"));
		AssetDTO a = new AssetDTO();
		a.setAssetId(asset.getAssetId());
		a.setAssetName(asset.getAssetName());
		a.setAssetType(asset.getAssetType());
		
		return a;
	}



	@Override
	public Asset updateAsset(String assetId, AssetDTO asset) throws AssetServiceException {
		Optional<Asset> asstopt = assetRepo.findById(assetId);
		Asset a= asstopt.orElseThrow(()->new AssetServiceException("asset.ASSET_NOT_PRESENT"));
		a.setAssetName(asset.getAssetName());
		a.setAssetType(asset.getAssetType());
		LOGGER.info("asset.ASSET_UPDATE_SUCCESSFULL");
		return assetRepo.save(a);
		
	}



	@Override
	public void deleteAsset(String assetId) throws AssetServiceException {
		Optional<Asset> asstopt = assetRepo.findById(assetId);
		Asset a= asstopt.orElseThrow(()-> new AssetServiceException("asset.ASSET_NOT_PRESENT"));
		
		Optional<Employee> a1= empRepo.findByAsset(a);        
		
		if(a1.isEmpty()) {
			assetRepo.deleteById(assetId);
		    LOGGER.info("asset.ASSET_DELETED_SUCCESSFULL");
		}
		else 
			throw new AssetServiceException("asset.CANNOT_DELETE_ASSET");
		
	}



	@Override
	public List<AssetDTO> getAssets() throws AssetServiceException {
		List<Asset> assetList = (List<Asset>) assetRepo.findAll();
		if (assetList.isEmpty())
			throw new AssetServiceException("asset.ASSET_LIST_EMPTY");
		List<AssetDTO> assetDTO= new ArrayList<AssetDTO>();
		
		for(Asset asset:assetList) {
			AssetDTO a = new AssetDTO();
			a.setAssetId(asset.getAssetId());
			
			a.setAssetName(asset.getAssetName());
			a.setAssetType(asset.getAssetType());
			assetDTO.add(a);
		}
        return  assetDTO;
	}



	@Override
	public Asset addAsset(AssetDTO asset) throws AssetServiceException {
		
		Optional<Asset> asstopt = assetRepo.findById(asset.getAssetId());
		if (asstopt.isPresent())
     	   throw new AssetServiceException("asset.CANNOT_ADD_ASSET");
		Asset a= new Asset();
		a.setAssetId(asset.getAssetId());
		a.setAssetName(asset.getAssetName());
		a.setAssetType(asset.getAssetType());
		
		LOGGER.info("asset.ASSET_INSERTION_SUCCESSFULL");
		return assetRepo.save(a);
	}
	
}
