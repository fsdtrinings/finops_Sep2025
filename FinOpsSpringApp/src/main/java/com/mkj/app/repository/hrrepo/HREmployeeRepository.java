package com.mkj.app.repository.hrrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mkj.app.entity.Employee;

@Repository
public interface HREmployeeRepository extends JpaRepository<Employee, Integer>
{

	public List<Employee> findByTechName(String techName);
}
