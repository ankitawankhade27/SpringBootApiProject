package com.jbk.FirstdemoSpringBoot;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.UiPOJO.CountryUI;
import com.jbk.UiPOJO.EmployeeUI;
import com.jbk.hibernatePOJO.Country;
import com.jbk.hibernatePOJO.EmployeeHibernate;

@RestController
@CrossOrigin
@RequestMapping("apii")
public class Api {

	@Autowired
	SessionFactory sf;

	
	@SuppressWarnings("unchecked")
	@GetMapping("/showallemployeehb1")
	public ResponseEntity<List<EmployeeHibernate>> getShowallEmployee() {
		Session session = sf.openSession();
		Criteria criteria=session.createCriteria(EmployeeHibernate.class);
		List<EmployeeHibernate> list = criteria.list();
		System.out.println(list);
		return new ResponseEntity<List<EmployeeHibernate>>(list, HttpStatus.OK);
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/statushb1/{status}")
	public ResponseEntity<List<EmployeeHibernate>> getStatusActive(@PathVariable("status") String status){
		System.out.println("Url getting hit....");
		Session session = sf.openSession();
		Criteria criteria=session.createCriteria(EmployeeHibernate.class);
		criteria.add(Restrictions.eq("status", status));
		List<EmployeeHibernate> list = criteria.list();
		System.out.println(list);
		return new ResponseEntity<List<EmployeeHibernate>>(list, HttpStatus.OK);
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/eidhb1/{id}")
	public ResponseEntity<List<EmployeeHibernate>> getEmployeebyId(@PathVariable("id") int id) {
		
		Session session = sf.openSession();
		Criteria criteria=session.createCriteria(EmployeeHibernate.class);
		criteria.add(Restrictions.eq("id", id));
		List<EmployeeHibernate> list = criteria.list();
		System.out.println("list >>"+list);
		return new ResponseEntity<List<EmployeeHibernate>>(list, HttpStatus.OK);
		
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/enamehb1/{name}")
	public ResponseEntity<List<EmployeeHibernate>> getEmployeebyName(@PathVariable("name") String name){
		Session session = sf.openSession();
		Criteria criteria=session.createCriteria(EmployeeHibernate.class);
		criteria.add(Restrictions.eq("name", name));
		List<EmployeeHibernate> list = criteria.list();
		System.out.println("list >>"+list);
		return new ResponseEntity<List<EmployeeHibernate>>(list, HttpStatus.OK);
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/listofempbeforetodayhb1/{createddtm}")
	public ResponseEntity<List<EmployeeHibernate>> getEmployeesOfToday(@PathVariable("createddtm") String ddtm){
		Session session = sf.openSession();
		Criteria criteria=session.createCriteria(EmployeeHibernate.class);
		criteria.add(Restrictions.eq("createddtm", ddtm));
		List<EmployeeHibernate> list = criteria.list();
		System.out.println("list >>"+list);
		return new ResponseEntity<List<EmployeeHibernate>>(list, HttpStatus.OK);
	}
	
	@PostMapping("/addemployeehb1")
	public ResponseEntity<String> addEmployee(@RequestBody EmployeeUI emp) {
		System.out.println("Add emp api is hiting");
		System.out.println(emp);
		Country country=new Country(emp.getCid(),emp.getCname());
		EmployeeHibernate hb=new EmployeeHibernate(country,emp.getName(),emp.getPhoneno(),
				emp.getDepartment(),emp.getStatus(),emp.getCreateddtm(),emp.getCreatedby(),emp.getUpdateddtm(),emp.getUpdatedby());
		
		Session session = sf.openSession();
		Transaction tx=session.beginTransaction();
		session.save(hb);
		tx.commit();
		return new ResponseEntity<>("employee added Successfully", HttpStatus.OK);
		
	}
	
	@PostMapping("/addcountryhb1")
	public ResponseEntity<String> addCountry(@RequestBody CountryUI country) {
		System.out.println("Country api is hitting");
		System.out.println(country);
		Country con=new Country(country.getCname());
		Session session = sf.openSession();
		Transaction tx=session.beginTransaction();
		session.save(con);
		tx.commit();
		return new ResponseEntity<>("country added Successfully", HttpStatus.OK);
		
	}
	
	
	@PutMapping("updatecountrynamehb1")
		public  ResponseEntity<String> updateCountryName(@RequestBody CountryUI country) {
		System.out.println("update api is hitting");
		System.out.println(country);
		 Country con=new Country(country.getCid(),country.getCname());
		 Session session = sf.openSession();
			Transaction tx=session.beginTransaction();
			session.saveOrUpdate(con);
			tx.commit();
			return new ResponseEntity<>("country updatd successfully", HttpStatus.OK);
		 
	 }
	
	 @DeleteMapping("/deletebycountrynamehb1/{cname}")
		public ResponseEntity<String> deletebyCountryName(@PathVariable("cname") String cname,CountryUI country) {
		 System.out.println("Delete api is hitting");
		 System.out.println(country);
		 Country con=new Country(country.getCname());
		 Session session = sf.openSession();
		    Criteria criteria=session.createCriteria(Country.class);
			criteria.add(Restrictions.eq("cname", cname));
            Transaction tx=session.beginTransaction();
			session.delete(con);
			tx.commit();
		 return new ResponseEntity<>("country deleted by name successfully", HttpStatus.OK);
		 
	 }
	 @DeleteMapping("/deleteemployeebyidhb1/{id}")
		public ResponseEntity<String> deletebyEmployeeId(@PathVariable("id") int id,EmployeeHibernate emp){
		 Session session = sf.openSession();
		    Criteria criteria=session.createCriteria(Country.class);
			criteria.add(Restrictions.eq("id", id));
         Transaction tx=session.beginTransaction();
			session.delete(emp);
			tx.commit();
		 return new ResponseEntity<>("employee deleted by id successfully", HttpStatus.OK);
	 }

}
