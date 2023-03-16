package com.example.data.controller;

import java.util.ArrayList;

public class Test {


	public static void main(String[] args) {
		Employee e1 = new Employee(1,100);
		Employee e2 = new Employee(2,200);
		Employee e3 = new Employee(3,150);
		Employee e4 = new Employee(4,300);
		ArrayList<Employee> list = new ArrayList<>();
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
	}

}
