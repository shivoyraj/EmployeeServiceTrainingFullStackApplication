package com.infy.service;

import java.util.List;

import com.infy.dto.AssetDTO;
import com.infy.entity.Asset;
import com.infy.exception.AssetServiceException;

public interface AssetService {

	public AssetDTO getAsset(String assetId) throws AssetServiceException;

	public List<AssetDTO> getAssets() throws AssetServiceException;

	public Asset updateAsset(String assetId, AssetDTO asset) throws AssetServiceException;

	public void deleteAsset(String assetId) throws AssetServiceException;
	
	public Asset addAsset(AssetDTO asset) throws AssetServiceException;

}
