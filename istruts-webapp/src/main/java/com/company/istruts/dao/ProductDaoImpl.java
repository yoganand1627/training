package com.company.istruts.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class ProductDaoImpl implements ProductDao{

	@Override
	public String create(Product product) throws Exception {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trax = session.beginTransaction();
		try{
			session.saveOrUpdate(product);
			trax.commit();
		}catch(Exception e){
			trax.rollback();
		}
		return null;
	}

	@Override
	public String update(Product product) throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.saveOrUpdate(product);
		return null;
	}

	@Override
	public List<Product> searchByProduct(Product product) throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria crit = session.createCriteria(Product.class);
		crit.add(Restrictions.eq("productName", product.getProductName()));
		
		
		crit.setFirstResult(20);
		crit.setMaxResults(10);
		
		List productList = crit.list();
		return productList;
	}

	@Override
	public Product viewByProductCode(String productCode) throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria crit = session.createCriteria(Product.class);
		crit.add(Restrictions.eq("productCode", productCode));
		
		List productList = crit.list();
		if(productList.size() == 1){
			return (Product)productList.get(0);
		}else{
			return null;
		}
	}
	
	public Product viewbyProductId(long productId){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Product product1 = (Product)session.get(Product.class, productId);
		
		Product product2 = (Product)session.load(Product.class, productId);
		
		return null;
	}

}
