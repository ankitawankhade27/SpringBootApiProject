package com.jbk.FirstdemoSpringBoot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.model.Student;

@RestController
public class WebSericesForApiTestingWithJdbc {

	@GetMapping("studentlist")
	public ArrayList<Student> getStudentList() throws ClassNotFoundException, SQLException{
		System.out.println(1111);
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println(2222);
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/firstdemospringboot","root","root");
		System.out.println(3333);
		PreparedStatement ps = con.prepareStatement("select * from student");
		System.out.println(4444);
	    ResultSet rs = ps.executeQuery();
	   Student s=null;
	   ArrayList<Student> sl=new ArrayList<>();
	   while (rs.next()) {
		   s = new Student(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getInt(4));
		   sl.add(s);
			}
		return sl;
}
}
