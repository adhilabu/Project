package com.products.catalogue.criteria;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.products.catalogue.beans.Items;
import com.products.catalogue.repo.ItemsRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

@Service
public class ProductFetch {

	@Autowired
	ItemsRepository repo;

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	ProductUtil productUtil;

	public String fetchParent(String pr) {
		String pc;
		Items citem = null;
		Items nitem = null;

		CriteriaBuilder name = em.getCriteriaBuilder();
		CriteriaBuilder code = em.getCriteriaBuilder();

		CriteriaQuery<Items> itName = productUtil.criteriaQ(name, "itemName", pr);
		CriteriaQuery<Items> itCode = productUtil.criteriaQ(code, "itemCode", pr);

		try {
			nitem = em.createQuery(itName).getResultList().get(0);
		} catch (Exception e) {
		}

		try {
			citem = em.createQuery(itCode).getResultList().get(0);
		} catch (Exception e) {
		}

		if ((nitem == null) && (citem == null)) {
			return "not present";
		}
		if (nitem == null) {
			pc = citem.getParentCode();
		} else {
			pc = nitem.getParentCode();
		}
		if (pc.isBlank())
		{
			pc = citem.getItemName();
		}
		CriteriaBuilder pcode = em.getCriteriaBuilder();
		CriteriaQuery<Items> PName = productUtil.criteriaQ(pcode, "itemCode", pc);
		Items itParent = em.createQuery(PName).getResultList().get(0);

		System.out.println(itParent.getItemName());
		return itParent.getItemName();
	}

	public List<String> getChildren(String parent) {
		CriteriaBuilder cbChild = em.getCriteriaBuilder();
		CriteriaQuery<Items> PName = productUtil.criteriaQ(cbChild, "parentCode", parent);
		TypedQuery<Items> itParent = em.createQuery(PName);
		List<Items> resultList = itParent.getResultList();
		List<String> list = new ArrayList<String>();
		for (Items it : resultList) {
			list.add(it.getItemCode());
		}
		List<String> sortedList = list.stream().sorted().collect(Collectors.toList());
		return sortedList;
	}

	public int[] getEnabled() {
		int[] val = new int[2];
		CriteriaBuilder active = em.getCriteriaBuilder();
		CriteriaBuilder nonActive = em.getCriteriaBuilder();

		CriteriaQuery<Items> itY = productUtil.criteriaQ(active, "enabled", "Y");
		CriteriaQuery<Items> itYes = productUtil.criteriaQ(active, "enabled", "Yes");

		CriteriaQuery<Items> itN = productUtil.criteriaQ(nonActive, "enabled", "NO");
		CriteriaQuery<Items> itNo = productUtil.criteriaQ(nonActive, "enabled", "N");
		TypedQuery<Items> itYes1 = em.createQuery(itYes);
		TypedQuery<Items> itY1 = em.createQuery(itY);
		TypedQuery<Items> itNo1 = em.createQuery(itNo);
		TypedQuery<Items> itN1 = em.createQuery(itN);

		val[0] = itYes1.getResultList().size() + itY1.getResultList().size();
		val[1] = itNo1.getResultList().size() + itN1.getResultList().size();
		System.out.println(val[0] + " " + val[1]);
		return val;
	}

	public HashMap<String, Integer> getAvgPrice() {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		List<String> ls1 = productUtil.fetchUnique("categoryL1");
		List<String> ls2 = productUtil.fetchUnique("categoryL2");
		for (String s1 : ls1) {
			if(!(s1.isBlank())) {
			int avg1 = productUtil.getAvgFromCat("categoryL1",s1);
			map.put("Category 1 : " + s1 + " ", avg1);}
		}
		for (String s2 : ls2) {
			if(!(s2.isBlank())) {
			int avg2 = productUtil.getAvgFromCat("categoryL2",s2);
			map.put("Category 2 : " + s2 + " ", avg2);}
		}

		return map;
	}

}
