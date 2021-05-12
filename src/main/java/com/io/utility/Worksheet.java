package com.io.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.io.model.ProductData;

@Service
public class Worksheet {
		
	List<ProductData> allData=new ArrayList<>();
	public List<ProductData> getData(String path) throws IOException{
		
            FileInputStream file = new FileInputStream(new File(path));
  
            // Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);
  
            // Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);
  
            boolean flag=true;
            
            // Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
         	   
            	
            	//For dont't getting headers
         	   if(flag==true) {
         		   rowIterator.next();
         		   flag=false;
         	   }

         	   Row row = rowIterator.next();
                
                // For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();
                
                ProductData productData=new ProductData();
                productData.setProduct_name(String.valueOf(cellIterator.next()));
                productData.setModel_name(String.valueOf(cellIterator.next()));
                productData.setProduct_serial_number(String.valueOf(cellIterator.next()));
                productData.setGroup_associated(String.valueOf(cellIterator.next()));
                productData.setProduct_MRP(String.valueOf(cellIterator.next()));
                
                
                //adding data into List
                allData.add(productData);
               
            }
            workbook.close();
            return allData;
		}  
}     	 
