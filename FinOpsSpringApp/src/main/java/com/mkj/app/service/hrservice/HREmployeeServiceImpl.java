package com.mkj.app.service.hrservice;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mkj.app.entity.Employee;
import com.mkj.app.entity.KYCDocuments;
import com.mkj.app.repository.hrrepo.DocumentRepository;
import com.mkj.app.repository.hrrepo.HREmployeeRepository;



@Service
public class HREmployeeServiceImpl implements HrEmployeeService
{
	@Autowired
	HREmployeeRepository hrRepo;
	
	@Autowired
	DocumentRepository docRepo;

	@Override
	public String saveEmployee(Employee e) {
		Employee savedEmployee = hrRepo.save(e);
		return savedEmployee.getEmpCode()+" "+savedEmployee.getEmpName()+" Saved";
	}

	
	@CacheEvict(value = "empCache",allEntries = true)
	public void clearCache()
	{
		
	}
	
	@Override
	@Cacheable(value = "empCache" , key = "#code")
	public Employee getEmployee(int code) {
		Employee savedEmployee = hrRepo.findById(code).get();
		return savedEmployee;
	}

	@Override
	@Transactional
	public String uploadDocs(KYCDocuments docs) {
		
		KYCDocuments savedDocs = docRepo.save(docs);
		return savedDocs.toString()+" Saved";
		
	}

	@Override
	public KYCDocuments getDocs(int adharNumber) {
		KYCDocuments savedDocs  = docRepo.findById(adharNumber).get();
		return savedDocs;
				
	}

	@Override
	@Transactional
	public Employee linkDocumentsWithEmployee
				(int adharNumber, int empCode) {

		Employee savedEmployee = getEmployee(empCode);
	
		KYCDocuments doc = getDocs(adharNumber);
			
		savedEmployee.setEmpDocs(doc); // called update query for us
		return savedEmployee;
	
		
	}
	
	
	

	
}




















