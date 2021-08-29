package com.infy.service;

import java.util.ArrayList;




import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dto.AssetDTO;
import com.infy.dto.EmployeeDTO;
import com.infy.entity.Asset;
import com.infy.entity.Employee;
import com.infy.exception.AssetServiceException;
import com.infy.exception.EmployeeServiceException;
import com.infy.repository.AssetRepository;
import com.infy.repository.EmployeeRepository;
import com.infy.utility.LoggingAspect;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	private static final Log LOGGER = LogFactory.getLog(LoggingAspect.class);

	@Autowired
	private EmployeeRepository empRepo;
	
	@Autowired
	private AssetRepository assetRepo;
	
	@Autowired
	private TrainingService trainingService;

	@Override
	public List<EmployeeDTO> getEmployees() throws EmployeeServiceException {
		
		List<Employee> empList = (List<Employee>) empRepo.findAll();
		if (empList.isEmpty())
			throw new EmployeeServiceException("employee.EMPLOYEES_LIST_EMPTY");
		List<EmployeeDTO> empDTO = new ArrayList<EmployeeDTO>();

		for (Employee employee : empList) {
			EmployeeDTO e = new EmployeeDTO();
			e.setEmpId(employee.getEmpId());
			e.setEmpName(employee.getEmpName());
			e.setEmpAddress(employee.getEmpAddress());

			AssetDTO a = new AssetDTO();
			a.setAssetId(employee.getAsset().getAssetId());
			a.setAssetName(employee.getAsset().getAssetName());
			a.setAssetType(employee.getAsset().getAssetType());

			e.setAsset(a);

			empDTO.add(e);
		}
		return empDTO;
	}

	@Override
	public EmployeeDTO getEmployee(Integer employeeId) throws EmployeeServiceException {

		Optional<Employee> employeeopt = empRepo.findById(employeeId);
		Employee employee = employeeopt.orElseThrow(
				() -> new EmployeeServiceException("employee.EMPLOYEE_NOT_PRESENT"));
		EmployeeDTO e = new EmployeeDTO();
		e.setEmpId(employee.getEmpId());
		e.setEmpName(employee.getEmpName());
		e.setEmpAddress(employee.getEmpAddress());

		AssetDTO a = new AssetDTO();
		a.setAssetId(employee.getAsset().getAssetId());
		a.setAssetName(employee.getAsset().getAssetName());
		a.setAssetType(employee.getAsset().getAssetType());

		e.setAsset(a);

		return e;
	}

	@Override
	public EmployeeDTO addEmployee(EmployeeDTO employee) throws EmployeeServiceException, AssetServiceException {

		Employee e = new Employee();
		e.setEmpId(employee.getEmpId());
		e.setEmpName(employee.getEmpName());
		e.setEmpAddress(employee.getEmpAddress());
		
		Optional<Employee> empopt= empRepo.findById(employee.getEmpId());
        if(empopt.isPresent())
        	throw new EmployeeServiceException("employee.CANNOT_ADD_EMPLOYEE");
        
		
		AssetDTO asset = employee.getAsset();

		Optional<Asset> assetopt= assetRepo.findById(asset.getAssetId());

		Asset a= assetopt.orElseThrow(()->new AssetServiceException("asset.ASSET_NOT_PRESENT"));
		
		Optional<Employee> a1= empRepo.findByAsset(a);        
		
		if(!a1.isEmpty())
			throw new AssetServiceException("asset.CANNOT_ADD_ASSET_TO_EMPLOYEE");

		Asset newAsset = new Asset();
		newAsset.setAssetId(a.getAssetId());
		newAsset.setAssetName(a.getAssetName());
		newAsset.setAssetType(a.getAssetType());
		
		e.setAsset(newAsset);

		LOGGER.info("employee.EMPLOYEE_INSERTION_SUCCESSFULL");
		empRepo.save(e);
		
		return employee;

	}

	@Override
	public Employee updateEmployee(Integer empId, EmployeeDTO employee) throws EmployeeServiceException, AssetServiceException {
		Optional<Employee> empopt = empRepo.findById(empId);
		Employee e = empopt.orElseThrow(
				() -> new EmployeeServiceException("employee.EMPLOYEE_NOT_PRESENT"));
	
		
		Optional<Asset> assetopt = assetRepo.findById(employee.getAsset().getAssetId());
		
		Asset gotAsset = assetopt.orElseThrow(()-> new EmployeeServiceException("asset.ASSET_NOT_PRESENT"));
		
		 Optional<Employee> e1= empRepo.findByAsset(gotAsset);   
		 
			if(!e1.isEmpty() && empId!=e1.get().getEmpId())
				throw new AssetServiceException("asset.CANNOT_ADD_ASSET_TO_EMPLOYEE");
		
		e.setEmpAddress(employee.getEmpAddress());
		e.setEmpName(employee.getEmpName());
		
		Asset a = new Asset();
		
		
		a.setAssetId(employee.getAsset().getAssetId());
		a.setAssetName(employee.getAsset().getAssetName());
	    a.setAssetType(employee.getAsset().getAssetType());
	    
	    e.setAsset(a);
       
		LOGGER.info("employee.EMPLOYEE_UPDATE_SUCCESSFULL");
		return empRepo.save(e);

	}

	@Override
	public void deleteEmployee(Integer empId) throws EmployeeServiceException {
		Optional<Employee> empopt = empRepo.findById(empId);
		
		Employee e= empopt.orElseThrow(() -> new EmployeeServiceException("employee.EMPLOYEE_NOT_PRESENT"));
		empRepo.deleteById(empId);
		
		LOGGER.info("employee.EMPLOYEE_DELETED_SUCCESSFULL");
		
	

		
		
	}

}
