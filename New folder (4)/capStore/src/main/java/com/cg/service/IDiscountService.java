package com.cg.service;

import com.cg.entity.Discount;
import com.cg.entity.Product;

public interface IDiscountService {
	
	public Integer checkDiscountOnProductById(Integer productId);
	
	public Integer applyDiscountOnProduct(Integer productId);
	
	public void addProduct(Product p);
	public void addDiscount(Discount d);
	
	
}