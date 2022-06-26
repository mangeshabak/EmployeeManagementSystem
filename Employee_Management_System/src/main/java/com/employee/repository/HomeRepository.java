package com.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.model.Employee;

@Repository
public interface HomeRepository extends JpaRepository<Employee, Integer>
{

	public Employee findByUsernameAndPassword(String un, String ps);

	public Employee findByMobileno(String mbn);

}

