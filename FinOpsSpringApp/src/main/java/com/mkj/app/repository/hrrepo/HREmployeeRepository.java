package com.mkj.app.repository.hrrepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mkj.app.entity.Employee;

@Repository
public interface HREmployeeRepository extends JpaRepository<Employee, Integer>
{

}
