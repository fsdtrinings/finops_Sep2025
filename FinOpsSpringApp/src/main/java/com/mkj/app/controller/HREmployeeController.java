package com.mkj.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mkj.app.entity.Employee;
import com.mkj.app.entity.KYCDocuments;
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
	public ResponseEntity<Employee> getEmployeebyId(@PathVariable int code)
	{
		Employee savedEmployee =  hrService.getEmployee(code);
		
	
		return new ResponseEntity<Employee>(savedEmployee,HttpStatus.OK);
	}
	
	
	@PostMapping("/kycdocs")
	public ResponseEntity<String> uploadKYCDoc(@RequestBody KYCDocuments docs)
	{
		if(docs != null)
		{
			String msg = hrService.uploadDocs(docs);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}
		return new ResponseEntity<String>("Error! at backend",HttpStatus.BAD_REQUEST);
	}
	
	// ...../employee/1/doc?an=741852
	
	@PutMapping("/employee/{code}/doc")
	public ResponseEntity<Employee> linkDocsWithEmployee
					(@PathVariable int code,
							@RequestParam(required = true) int an)
	{
		
		Employee updatedEmployee = hrService.linkDocumentsWithEmployee(an, code);
		
		return new ResponseEntity<Employee>(updatedEmployee,HttpStatus.OK);
	}
	
}//end class















