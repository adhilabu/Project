package com.example.data.controller;

public class Employee {

	int id;
	int salary;
	public Employee(int i,int s) {
		this.id = i;
		this.salary = s;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	

}
