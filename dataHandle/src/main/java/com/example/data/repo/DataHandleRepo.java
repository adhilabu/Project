package com.example.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.data.bean.Data;

public interface DataHandleRepo extends JpaRepository<Data, Long>{
	
}