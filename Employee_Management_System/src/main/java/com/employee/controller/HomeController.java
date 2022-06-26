package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.Employee;
import com.employee.service.HomeService;

@RestController
public class HomeController
{
		@Autowired
		HomeService hs;
		
		
	@RequestMapping(value = "/register",method = RequestMethod.POST)  //http://localhost:8080/register
	public String registerData(@RequestBody() Employee e)
	{
		hs.registerData(e);
		
		return "You have Registered Successfully";
	}
	
	@RequestMapping(value="/getList" , method = RequestMethod.GET)  //http://localhost:8080/getList
	public List<Employee> displayEmplist()
	{
		List<Employee> list= hs.displayAllData();
		
		return list;
	}

	@RequestMapping(value="/softdelete/{id}" , method = RequestMethod.DELETE)  //http://localhost:8080/softdelete/2
	public List<Employee> softDeleteEmp(@PathVariable("id") int id)
	{
		List<Employee>emplist=hs.softDeleteData(id);
		
		return emplist;
	}
	@RequestMapping(value="/delete/{id}" , method = RequestMethod.DELETE)    //http://localhost:8080/delete/2
	public String deleteEmp(@PathVariable("id") int id)
	{
		hs.deleteData(id);
		
		return "Data Deleted";
	}
	@RequestMapping(value="/getSingleData/{id}" , method = RequestMethod.GET)  //http://localhost:8080/getSingleData/1
	public Employee singleData(@PathVariable("id") int id)
	{
		Employee emp=hs.displaySingleData(id);
		
		return emp;
	}

	@RequestMapping(value="/update",method = RequestMethod.PUT)  //http://localhost:8080/update
	public Employee saveorupdateEmp(@RequestBody Employee e)
	{
		hs.saveEmpData(e);
			return e;
	}
	
	@RequestMapping(value="/getSingleData/{username}/{password}" , method = RequestMethod.GET)  //http://localhost:8080/getSingleData/username/password
	public Employee singleDataUP(@PathVariable("username") String un,@PathVariable("password") String ps)
	{
		Employee emp=hs.displaySingleDataUP(un,ps);
		
		return emp;
	}


	@RequestMapping(value="/updateMinimum",method = RequestMethod.PATCH)   //http://localhost:8080/updateMinimum
	public Employee saveorupdateStuMin(@RequestBody Employee e)
	{
		hs.saveEmpData(e);
			return e;
	}
	@RequestMapping(value="/getMobileData/{mobileno}" , method = RequestMethod.GET)  //http://localhost:8080/getMobileData/mobileno
	public Employee mobileData(@PathVariable("mobileno") String mbn)
	{
		Employee e=hs.displayMobileData(mbn);
		
		return e;
	}
}

