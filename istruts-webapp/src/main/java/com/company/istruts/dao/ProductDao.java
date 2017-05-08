package com.company.istruts.dao;

import java.util.List;

public  interface ProductDao {

	public String create(Product product) throws Exception;
	
	public String update(Product product) throws Exception;

	public List<Product> searchByProduct(Product product) throws Exception;
	
	public Product viewByProductCode(String productCode) throws Exception;
	
}
