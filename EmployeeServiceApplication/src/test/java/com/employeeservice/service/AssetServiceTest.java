package com.employeeservice.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.infy.exception.AssetServiceException;
import com.infy.repository.AssetRepository;
import com.infy.repository.EmployeeRepository;
import com.infy.service.AssetServiceImpl;

@SpringBootTest
public class AssetServiceTest {
	
	@Mock
    private AssetRepository assetRepo;

    @Mock
    private EmployeeRepository empRepo;
    
    @InjectMocks
    private AssetServiceImpl AssetService;
    
    @Test
    public void getAssetTest() throws Exception{
    	try {
			AssetService.getAssets();
		} catch (AssetServiceException e) {
			System.out.println(""+e.getMessage());
		}
    }

}
