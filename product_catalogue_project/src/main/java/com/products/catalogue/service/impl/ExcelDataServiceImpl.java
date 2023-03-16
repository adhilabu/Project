package com.products.catalogue.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.products.catalogue.beans.Items;
import com.products.catalogue.repo.ItemsRepository;
import com.products.catalogue.service.IExcelDataService;

@Service
public class ExcelDataServiceImpl implements IExcelDataService {

	@Value("${app.upload.file:${user.home}}")
	public String EXCEL_FILE_PATH;

	@Autowired
	ItemsRepository repo;

	Workbook workbook;

	public List<Items> getExcelDataAsList() {

		List<String> list = new ArrayList<String>();

		// Create a DataFormatter to format and get each cell's value as String
		DataFormatter dataFormatter = new DataFormatter();

		// Create the Workbook
		try {
			workbook = WorkbookFactory.create(new File(EXCEL_FILE_PATH));
		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}

		// Retrieving the number of sheets in the Workbook
		System.out.println("-------Workbook has '" + workbook.getNumberOfSheets() + "' Sheets-----");

		// Getting the Sheet at index zero
		Sheet sheet = workbook.getSheetAt(0);

		// Getting number of columns in the Sheet
		int noOfColumns = sheet.getRow(0).getLastCellNum();
		System.out.println("-------Sheet has '"+noOfColumns+"' columns------");

		// Using for-each loop to iterate over the rows and columns
		for (Row row : sheet) {
			for (Cell cell : row) {
				String cellValue = dataFormatter.formatCellValue(cell);
				list.add(cellValue);
			}
		}

		// filling excel data and creating list as List<Invoice>
		List<Items> invList = createList(list, noOfColumns);

		// Closing the workbook
		try {
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return invList;
	}

	private List<Items> createList(List<String> excelData, int noOfColumns) {

		ArrayList<Items> itelist = new ArrayList<Items>();

		int i = noOfColumns;
		do {
			Items inv = new Items();
			// setting each value in the object
			inv.setItemCode(excelData.get(i));
			inv.setItemName(excelData.get(i + 1));
			inv.setCategoryL1(excelData.get(i + 2));
			inv.setCategoryL2(excelData.get(i + 3));
			inv.setUpc(excelData.get(i + 4));
			inv.setParentCode(excelData.get(i + 5));
			inv.setMrpPrice((excelData.get(i + 6)));
			inv.setSize(excelData.get(i + 7));
			inv.setEnabled(excelData.get(i + 8));
			itelist.add(inv);
			i = i + (noOfColumns);

		} while (i < excelData.size());
		return itelist;
	}

	@Override
	public int saveExcelData(List<Items> items) {
		items = repo.saveAll(items);
		return items.size();
	}

}
