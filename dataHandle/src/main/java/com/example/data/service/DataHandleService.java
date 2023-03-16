package com.example.data.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.data.bean.Data;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Service
public class DataHandleService {
	
	private EntityManager em;

	public String fetchData(String in)
	{
	
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Data> q = cb.createQuery(Data.class);
		Root<Data> data = q.from(Data.class);
		q.select(data);
		List<Predicate> predicates = new ArrayList<Predicate>();
		if (in != null) {
		    predicates.add(
		            cb.equal(data.get("name"), in));
		}
//		cb.where(predicates.toArray(new Predicate[]{}));
//
//		//Execute query and do something with result list
//		entityManager.createQuery(cq).getResultList();
//		
		return in;

	}

}


