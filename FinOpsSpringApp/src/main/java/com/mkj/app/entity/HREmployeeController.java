package com.mkj.app.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mkj.app.repository.hrrepo.HREmployeeRepository;
import com.mkj.app.service.hrservice.HrEmployeeService;

@RestController
@RequestMapping("/hr")
public class HREmployeeController {

	@Autowired
	HrEmployeeService hrService;
	
	public HREmployeeController() {
		System.out.println("Employee Controller constructor");
	}

	@PostMapping("/employee")
	public String insertEmployee(@RequestBody Employee employee)
	{
		
		String str = hrService.saveEmployee(employee);

		
		return str;
	}
	
	@GetMapping("/employee/{code}")
	public Employee getEmployeebyId(@PathVariable int code)
	{
		return hrService.getEmployee(code);
	}
	
}
