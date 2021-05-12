package com.io.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document()
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductData {
	
	@Id
	private String product_serial_number;
	private String product_name;
	private String model_name;
	private String group_associated;
	private String product_MRP; 
	
}
