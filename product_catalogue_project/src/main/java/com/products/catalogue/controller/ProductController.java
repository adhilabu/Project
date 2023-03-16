package com.products.catalogue.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.products.catalogue.beans.Items;
import com.products.catalogue.criteria.ProductFetch;
import com.products.catalogue.repo.ItemsRepository;
import com.products.catalogue.service.IExcelDataService;
import com.products.catalogue.service.IProductService;

@Controller
public class ProductController {

	@Autowired
	IProductService productservice;

	@Autowired
	IExcelDataService excelservice;

	@Autowired
	ItemsRepository repo;

	@Autowired
	ProductFetch productfetch;

	@GetMapping("/")
	public String index() {
		return "1_UploadPage";
	}

	@PostMapping("/uploadFile")
	public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {

		productservice.uploadFile(file);

		redirectAttributes.addFlashAttribute("message",
				"You have successfully uploaded '" + file.getOriginalFilename() + "' !");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/";
	}

	@GetMapping("/saveData")
	public String saveExcelData(Model model) {

		List<Items> excelDataAsList = excelservice.getExcelDataAsList();
		int noOfRecords = excelservice.saveExcelData(excelDataAsList);
		model.addAttribute("noOfRecords", noOfRecords);
		return "2_SaveData";
	}

	@PostMapping("/fetchParent")
	public String fetchParentFromProduct(@RequestParam("val") String val, Model model) {
		model.addAttribute("parent", productfetch.fetchParent(val));
		return "3_FetchParentResult";
	}

	@PostMapping("/fetchChildren")
	public ModelAndView fetchChildrenFromParentCode(@RequestParam("va") String va) {
		List<String> ts = productfetch.getChildren(va);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("4_FetchChildrenResult");
		modelAndView.addObject("ts", ts);
		return modelAndView;
	}

	@GetMapping("/getEnabledValues")
	public ModelAndView getActvieValues(Model model) {
		List<String> en = new ArrayList<>();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("5_GetEnabled");
		int[] arr = productfetch.getEnabled();
		en.add("active = " + arr[0]);
		en.add("non active = " + arr[1]);
		modelAndView.addObject("en", en);
		return modelAndView;
	}

	@GetMapping("getAvgCatPrice")
	public ModelAndView getAvgPrice() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("6_GetAvgPrice");
		modelAndView.addObject("map", productfetch.getAvgPrice());
		return modelAndView;
	}

}