package com.infy.dto;

public class AssetDTO {

	@Override
	public String toString() {
		return "AssetDTO [AssetId=" + AssetId + ", AssetType=" + AssetType + ", AssetName=" + AssetName + "]";
	}
	
	private String AssetId;
	private String AssetType;
	private String AssetName;
	public String getAssetId() {
		return AssetId;
	}
	public void setAssetId(String assetId) {
		AssetId = assetId;
	}
	public String getAssetType() {
		return AssetType;
	}
	public void setAssetType(String assetType) {
		AssetType = assetType;
	}
	public String getAssetName() {
		return AssetName;
	}
	public void setAssetName(String assetName) {
		AssetName = assetName;
	}
}
