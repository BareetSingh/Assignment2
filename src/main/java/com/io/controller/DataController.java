package com.io.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.io.repository.Repo;
import com.io.utility.Worksheet;

@RestController
public class DataController {
	
	@Autowired
	Worksheet worksheet;   //This service return return all data from the Excel sheet in the form of List
		
	@Autowired
	private Repo repo; //This Repo object is using to insert data into the database;	
	
	//Path of ExcelSheet
	String path="C:\\Users\\Dell\\Desktop\\Internshala\\beginner_assignment01.xlsx";
	
	//You have to call this API for operation(-->http://localhost:8080/copy-data)
	@RequestMapping("/copy-data")
	public String addData() throws IOException {
		repo.saveAll(worksheet.getData(path));
		
		//Successful msg on browser screen
		return "<h1>Data copied from Excel to Database(MongoDb) Successfully.......</h1>";
	}
}
