package com.employee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.model.Employee;


public interface HomeService {
	public Employee registerData(Employee e);
	public List<Employee> displayAllData();
	public void deleteData(int id);
	public Employee displaySingleData(int id);
	public void saveEmpData(Employee e);
	public Employee displaySingleDataUP(String un, String ps);
	public Employee displayMobileData(String mbn);
	public List<Employee> softDeleteData(int id);
}
