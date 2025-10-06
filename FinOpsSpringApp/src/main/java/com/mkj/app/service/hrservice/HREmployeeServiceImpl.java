package com.mkj.app.service.hrservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkj.app.entity.Employee;
import com.mkj.app.repository.hrrepo.HREmployeeRepository;

@Service
public class HREmployeeServiceImpl implements HrEmployeeService
{
	@Autowired
	HREmployeeRepository hrRepo;

	@Override
	public String saveEmployee(Employee e) {
		Employee savedEmployee = hrRepo.save(e);
		return savedEmployee.getEmpCode()+" "+savedEmployee.getEmpName()+" Saved";
	}

	@Override
	public Employee getEmployee(int code) {
		Employee savedEmployee = hrRepo.findById(code).get();
		return savedEmployee;
	}

	
}
