package com.example.data.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.data.bean.DataHandleRequestBean;
import com.example.data.service.DataHandleService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class DataHandleController {
	
	@Autowired
	DataHandleService dataHandleService;
	
	@GetMapping(value ="/g")
	public String getMapp()
	{
		return "hiii";
	}
	
	@PostMapping(value ="/p")
	public String getPost(@RequestBody HttpServletRequest request)
	{
		
		String in = (String) request.getAttribute("in");
		DataHandleRequestBean dataHandleRequestBean = new DataHandleRequestBean();
		dataHandleRequestBean.setCount(Integer.parseInt(in));
//        final byte[] requestContent;
//        requestContent = IOUtils.toByteArray(request.get);
//        String resp = new String(requestContent, StandardCharsets.UTF_8);
        return dataHandleService.fetchData(in);

		
	}

}
