package com.Prizy.Pricer.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.Prizy.Pricer.Domain.Product;
import com.Prizy.Pricer.Domain.ProductSurvey;

@Transactional
@Repository
public class ProductRepository extends RepositoryDAO {
	

	@PersistenceContext
	private EntityManager ent;
			
	public List<Product> getAllProducts(){
		return executeQuery("from Product");
	}
	
	public List<Product> getProductByBarcode(String barcode){
		Query query = ent.createQuery("from Product where productBarcode =: barcode ");
		query.setParameter("barcode", barcode);		
		return query.getResultList();
	}
	
	public List<ProductSurvey> getProductSurveyData(String barcode){
		Query query = ent.createQuery("from ProductSurvey where product.productBarcode =: barcode ");
		query.setParameter("barcode", barcode);
		return query.getResultList();
	}
	
	public ProductSurvey saveProductServey(ProductSurvey ps) {
		save(ps);
		return ps;
	}

}
