package com.cg.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Discount;
import com.cg.entity.Merchant;
import com.cg.entity.Product;
import com.cg.service.DiscountService;

@RestController
@RequestMapping("/discount")
public class DiscountController {

	@Autowired
	private DiscountService discountService;
	
	@GetMapping("/add")
	public void add()
	{
		Product p=new Product("ABc", 5000,100);
		Product p1=new Product("ABCD",6000,101);
		Product p2=new Product("ABcdef",8000,102);
		
		
		Discount d=new Discount(p1, 50.0, null, null);
		Discount d1=new Discount(p, 40.0, null, null);
		Discount d2=new Discount(p2, 80.0, null, null);
		
	discountService.addProduct(p);

//		discountService.addProduct(p1);

//		discountService.addProduct(p2);
		
		discountService.addDiscount(d);
		discountService.addDiscount(d1);
		discountService.addDiscount(d2);
		
		
	}
	
	@GetMapping("/check/{productId}")
	public Integer checkDiscountOnProductById(@PathVariable Integer productId) {
		return discountService.checkDiscountOnProductById(productId);
	}
	
	@GetMapping("/apply/{productId}")
	public Integer applyDiscountOnProductById(@PathVariable Integer productId) {
		return discountService.applyDiscountOnProduct(productId);
	}
}
