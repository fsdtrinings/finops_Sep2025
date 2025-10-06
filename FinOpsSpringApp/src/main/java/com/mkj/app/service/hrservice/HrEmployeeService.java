package com.mkj.app.service.hrservice;

import org.springframework.stereotype.Service;

import com.mkj.app.entity.Employee;
import com.mkj.app.entity.KYCDocuments;

@Service
public interface HrEmployeeService {

	public String saveEmployee(Employee e);
	public String uploadDocs(KYCDocuments docs);
	public void clearCache();
	public Employee getEmployee(int code);
	
	public KYCDocuments getDocs(int adharNumber);
	public Employee linkDocumentsWithEmployee(int adharnumber,
												int empCode);
}
