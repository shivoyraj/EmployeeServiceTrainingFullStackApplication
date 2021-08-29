package com.infy.entity;

import javax.persistence.Entity;

import javax.persistence.Id;

import com.infy.dto.AssetDTO;

@Entity
public class Asset {
    
	@Id
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
	@Override
	public String toString() {
		return "Assets [AssetId=" + AssetId + ", AssetType=" + AssetType + ", AssetName=" + AssetName + "]";
	}
	
	@Override
	public int hashCode() {
		return 31;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		AssetDTO other = (AssetDTO) obj;
		if (this.getAssetId() == null) {
			if (other.getAssetId() != null)
				return false;
		} else if (!this.getAssetId().equals(other.getAssetId()))
			return false;
		return true;
	}
	
	
}