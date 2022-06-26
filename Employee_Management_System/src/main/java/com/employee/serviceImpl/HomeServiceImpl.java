package com.employee.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.exception.PageNotFound;
import com.employee.model.Employee;
import com.employee.repository.HomeRepository;
import com.employee.service.HomeService;

@Service
public class HomeServiceImpl implements HomeService
{
	
	@Autowired
	
	HomeRepository hr;

	@Override
	public Employee registerData(Employee e) {
		return hr.save(e);
		
	}

	@Override
	public List<Employee> displayAllData() {
		
		return hr.findAll();
	}

	@Override
	public List<Employee> softDeleteData(int id) {
		Employee e= hr.findById(id).get();
		e.setActive(false);
		hr.save(e);
		List<Employee> list=hr.findAll();
		List<Employee> l=new ArrayList<Employee>();
		for(Employee e1:list)
		{
			if(e1.isActive()==true)
			{
				l.add(e);
			}
		}
		return l;
	}

	@Override
	public Employee displaySingleData(int id) {
		
		return hr.findById(id).get();
	}

	@Override
	public void saveEmpData(Employee e) {
		hr.save(e);
		
	}

	@Override
	public Employee displaySingleDataUP(String un, String ps) {
		
		return hr.findByUsernameAndPassword(un,ps);
	}

	@Override
	public Employee displayMobileData(String mbn) {
		Employee e1=null;
		try {
		 e1=hr.findByMobileno(mbn);
		 System.out.println(e1.getName());
	}
		catch (Exception e) {
			throw new PageNotFound("User Not Available");
		}
		return e1;
		}
		

	@Override
	public void deleteData(int id) {
		// TODO Auto-generated method stub
		try {
			hr.deleteById(id);
		}
		catch (Exception e) {
			throw new PageNotFound("Id Not Found");
		
		}
	}
	
}

