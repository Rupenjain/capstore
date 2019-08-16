package com.cg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cg.dao.DiscountDAO;
import com.cg.dao.ProductDAO;
import com.cg.entity.Discount;
import com.cg.entity.Product;

@Service
public class DiscountService implements IDiscountService {
	@Autowired DiscountDAO discountDao;
	@Autowired ProductDAO productDao;

	@Transactional(readOnly = true)
	public Integer checkDiscountOnProductById(Integer productId) {
		// TODO Auto-generated method stub
		Product product=productDao.findById(productId).get();
		return discountDao.checkDiscountOnProductById(product);
	}

	@Transactional(readOnly = true)
	public Integer applyDiscountOnProduct(Integer productId) {
		Product product=productDao.findById(productId).get();
		int discount = discountDao.checkDiscountOnProductById(product);
		int price = productDao.getProductPrice(productId);
		return price - discount;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void addProduct(Product p) {
		// TODO Auto-generated method stub
		productDao.saveAndFlush(p);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void addDiscount(Discount d) {
		discountDao.save(d);
		// TODO Auto-generated method stub
		
	}

}
