package com.mkj.app.service.hrservice;

import org.springframework.stereotype.Service;

import com.mkj.app.entity.Employee;

@Service
public interface HrEmployeeService {

	public String saveEmployee(Employee e);
	public Employee getEmployee(int code);
}
