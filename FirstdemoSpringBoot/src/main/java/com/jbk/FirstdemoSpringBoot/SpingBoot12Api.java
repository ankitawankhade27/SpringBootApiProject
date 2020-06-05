package com.jbk.FirstdemoSpringBoot;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.DbConnection.DbUtil;
import com.jbk.model.Country;
import com.jbk.model.EmployeeJDBC;

@RestController
@CrossOrigin
@RequestMapping("api")
public class SpingBoot12Api {
	
	@GetMapping("showallemployee")
	public ArrayList<EmployeeJDBC> getShowallEmployee() throws SQLException{
		ArrayList<EmployeeJDBC> al=new ArrayList<>();
	
		Connection con=DbUtil.getCon();
		PreparedStatement ps = con.prepareStatement("select * from employee");
	    ResultSet rs = ps.executeQuery();
	 while (rs.next())
	 {
			EmployeeJDBC    e = new EmployeeJDBC(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),
				   rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10));
			 al.add(e);
	}
	return al;	
	}
	
	@GetMapping("/status/{status}")
	public ArrayList<EmployeeJDBC> getStatusActive(@PathVariable("status") String status) throws SQLException{
		ArrayList<EmployeeJDBC> al=new ArrayList<>();
		
		Connection con=DbUtil.getCon();
		PreparedStatement ps = con.prepareStatement("select * from employee where status=?");
		ps.setString(1,status);
	    ResultSet rs = ps.executeQuery();
	   
	 while (rs.next())
	 {
		 EmployeeJDBC    e = new EmployeeJDBC(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),
				   rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10));
			 al.add(e);
	}
	return al;	
		
	}
	
	@GetMapping("/eid/{id}")
	public ArrayList<EmployeeJDBC> getEmployeebyId(@PathVariable("id") int id) throws SQLException{
		ArrayList<EmployeeJDBC> al=new ArrayList<>();
		
		Connection con=DbUtil.getCon();
		PreparedStatement ps = con.prepareStatement("select * from employee where id=?");
		ps.setInt(1,id);
	    ResultSet rs = ps.executeQuery();
	   
	 while (rs.next())
	 {
		 EmployeeJDBC    e = new EmployeeJDBC(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),
				   rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10));
			 al.add(e);
	}
	return al;	
		
	}
	
	@GetMapping("/ename/{name}")
	public ArrayList<EmployeeJDBC> getEmployeebyName(@PathVariable("name") String name) throws SQLException{
		ArrayList<EmployeeJDBC> al=new ArrayList<>();
		
		Connection con=DbUtil.getCon();
		PreparedStatement ps = con.prepareStatement("select * from employee where name=?");
		ps.setString(1,name);
	    ResultSet rs = ps.executeQuery();
	   
	 while (rs.next())
	 {
		 EmployeeJDBC    e = new EmployeeJDBC(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),
				   rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10));
			 al.add(e);
	}
	return al;	
		
	}
	
	@GetMapping("/listofempbeforetoday/{createddtm}")
	public ArrayList<EmployeeJDBC> getEmployeesOfToday(@PathVariable("createddtm") String ddtm) throws SQLException{
		ArrayList<EmployeeJDBC> al=new ArrayList<>();
		
		Connection con=DbUtil.getCon();
		PreparedStatement ps = con.prepareStatement("select * from employee where createddtm=?");
		ps.setString(1,ddtm);
	    ResultSet rs = ps.executeQuery();
	   
	 while (rs.next())
	 {
		 EmployeeJDBC    e = new EmployeeJDBC(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),
				   rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10));
			 al.add(e);
	}
	return al;	
		}
	
	@PostMapping("/addemployee")
	public String addEmployee(@RequestBody EmployeeJDBC emp) throws SQLException{
		System.out.println(emp);
		Connection con=DbUtil.getCon();
		String sql="insert into employee(name,phoneno,departmentit,status,createddtm,createdby,updateddtm,updatedby,cid) values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1,emp.getName());
		ps.setString(2,emp.getPhoneno());
		ps.setString(3,emp.getDepartmentit());
		ps.setString(4,emp.getStatus());
		ps.setString(5,emp.getCreateddtm());
		ps.setString(6,emp.getCreatedby());
		ps.setString(7,emp.getUpdateddtm());
		ps.setString(8,emp.getUpdatedby());
		ps.setInt(9,emp.getCid());
	  int result=ps.executeUpdate();
	   if(result>0) {
		   
		   return "Employee Added Successfully";	
	   }
	   
	   else {
		   return "Something went wrong";
	   }
	}   
	   @PostMapping("/addcountry")
		public String addcountry(@RequestBody Country country) throws SQLException{
			System.out.println(country);
			Connection con=DbUtil.getCon();
			String sql="insert into country(cname) values(?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,country.getCname());
			
		  int result=ps.executeUpdate();
		   if(result>0) {
			   
			   return "Country Added Successfully";	
		   }
		   
		   else {
			   return "Something went wrong";
		   }
	 }
	   
	   @PutMapping("/updatecountryname")
		public String updatecountryname(@RequestBody Country country) throws SQLException{
			System.out.println(111);
			Connection con=DbUtil.getCon();
			String sql="update country SET cname=? where cid=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,country.getCname());
			ps.setInt(2,country.getCid());
			
		  int result=ps.executeUpdate();
		   if(result>0) {
			   
			   return "Country Updated Successfully";	
		   }
		   
		   else {
			   return "Something went wrong";
		   }
	   }
	   
	   @DeleteMapping("/deletebycountryname/{cname}")
		public String deletebycountryname(@PathVariable("cname") String cname) throws SQLException{
			System.out.println(111);
			Connection con=DbUtil.getCon();
			String sql="delete from country where cname=?  ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,cname);
			
			
		  int result=ps.executeUpdate();
		   if(result>0) {
			   
			   return "Country deleted by name Successfully";	
		   }
		   
		   else {
			   return "Something went wrong";
		   }
	   }
		   
		   @DeleteMapping("/deleteemployeebyid/{id}")
			public String deletebyEmployeeId(@PathVariable("id") int id) throws SQLException{
				System.out.println(111);
				Connection con=DbUtil.getCon();
				String sql="delete from employee where id=?  ";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1,id);
				
				
			  int result=ps.executeUpdate();
			   if(result>0) {
				   
				   return "Employee deleted by id Successfully";	
			   }
			   
			   else {
				   return "Something went wrong";
			   }
	   }
		  
	

}
