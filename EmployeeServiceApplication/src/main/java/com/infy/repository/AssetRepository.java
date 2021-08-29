package com.infy.repository;

import org.springframework.data.repository.CrudRepository;

import com.infy.entity.Asset;

public interface AssetRepository extends CrudRepository<Asset, String> {

}
