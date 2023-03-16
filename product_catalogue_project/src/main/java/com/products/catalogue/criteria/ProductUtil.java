package com.products.catalogue.criteria;

import java.util.List;

import org.springframework.stereotype.Service;

import com.products.catalogue.beans.Items;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Service
public class ProductUtil {
	@PersistenceContext
	private EntityManager em;
	
	public int getAvgFromCat(String cat, String value) {
		CriteriaBuilder cbavg1 = em.getCriteriaBuilder();
		CriteriaQuery<Items> cq = cbavg1.createQuery(Items.class);
		Root<Items> items = cq.from(Items.class);
		Predicate predicate = cbavg1.equal(items.get(cat), value);
		cq.where(predicate);
		TypedQuery<Items> itParent = em.createQuery(cq);
		List<Items> resultList = itParent.getResultList();
		int k = 0;
		int sum = 0;
		for (Items it : resultList) {
			k++;
			sum += (Integer.parseInt(it.getMrpPrice()));
		}
		return sum / k;
	}	
	
	public List<String> fetchUnique(String uniq) {
		CriteriaQuery<String> cq = em.getCriteriaBuilder().createQuery(String.class);
		Root<Items> root = cq.from(Items.class);

		cq.select(root.get(uniq)).distinct(true);
		TypedQuery<String> tq = em.createQuery(cq);
		List<String> resultList = tq.getResultList();
		resultList.forEach(System.out::println);
		return resultList;
	}

	public CriteriaQuery<Items> criteriaQ(CriteriaBuilder code, String col, String val) {
		CriteriaQuery<Items> cq = code.createQuery(Items.class);
		Root<Items> items = cq.from(Items.class);
		Predicate predicate = code.equal(items.get(col), val);
		cq.where(predicate);
		return cq;
	}
}
