package com.jbk.FirstdemoSpringBoot;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.model.Student;

@RestController
public class WebServiceForTesting {
	
	@RequestMapping("welcome")
	public String WelcomeService() {
		return "Welcome to Welcome Service...";
	}

	@RequestMapping("hobbies")
	public String[] Hobbies() {
		String hobbies[]=new String[3];
		hobbies[0]="Reading";
		hobbies[1]="Writing";
		hobbies[2]="Singing";
		return hobbies;
	}
	
	
	@RequestMapping("employee")
	public ArrayList<String> employeeName(){
		ArrayList<String> al=new ArrayList<>();
		al.add("Ankita");
		al.add("Surabhi");
		al.add("Onkar");
		return al;
	}
	
	
	@RequestMapping("student")
	public ArrayList<Student> studentList(){
		Student s1=new Student("Ankita","pune",26);
		Student s2=new Student("Surabhi","Amravti",25);
		ArrayList<Student> sl=new ArrayList<>();
		sl.add(s1);
		sl.add(s2);
	return sl;
	}
}
