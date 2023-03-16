package com.products.catalogue.service;

import java.util.List;

import com.products.catalogue.beans.Items;

public interface IExcelDataService {

	List<Items> getExcelDataAsList();
	
	int saveExcelData(List<Items> invoices);
}
