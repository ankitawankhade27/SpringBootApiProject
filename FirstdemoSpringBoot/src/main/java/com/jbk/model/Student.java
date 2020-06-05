package com.jbk.model;

import java.io.Serializable;

public class Student implements Serializable {
		/**
	 * 
	 */
	private static final long serialVersionUID = 2432970315984088713L;
	
	private int id;
		private String name;
		private String address;
		private int age;
        
        
		public Student() {
			super();
		}


		public Student(String name, String address, int age) {
			super();
			this.name = name;
			this.address = address;
			this.age = age;
		}


		public Student(int id, String name, String address, int age) {
			super();
			this.id = id;
			this.name = name;
			this.address = address;
			this.age = age;
		}


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public String getAddress() {
			return address;
		}


		public void setAddress(String address) {
			this.address = address;
		}


		public int getAge() {
			return age;
		}


		public void setAge(int age) {
			this.age = age;
		}

		@Override
		public String toString() {
			return "Student [name=" + name + ", address=" + address + ", age=" + age + "]";
		}
		
		

     }

