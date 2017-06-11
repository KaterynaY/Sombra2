//package ua.com.clothes_shop.dao.impl;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//
//import org.springframework.stereotype.Repository;
//
//import ua.com.clothes_shop.dao.BrandDao;
//import ua.com.clothes_shop.entity.Brand;
//import ua.com.clothes_shop.entity.ItemOfClothing;
//
//@Repository
//public class BrandDaoImpl implements BrandDao{
//	
//	final EntityManager manager;
//
//	public BrandDaoImpl(EntityManager manager) {
//		super();
//		this.manager = manager;
//	}
//	
//	@Override
//	public void save(Brand brand) {
//		manager.getTransaction().begin();
//		manager.persist(brand);
//		manager.getTransaction().commit();
//
//	}
//	
//	@Override
//	public List<Brand> findAll() {
//
//		List<Brand> brands = manager.createQuery("from Brand").getResultList();
//
//		return brands;
//	}
//	
//	@Override
//	public Brand findOne(int id) {
//		Brand brand = (Brand) manager.createQuery("select b from Brand b where b.id =:param")
//				.setParameter("param", id).getSingleResult();
//		return brand;
//	}
//	
//	@Override
//	public Brand findByBrandName(String brandName) {
//
//		Brand brand = (Brand) manager.createQuery("select b from Brand b where b.brandName =:param")
//				.setParameter("param", brandName).getSingleResult();
//
//		return brand;
//
//	}
//	
//	@Override
//	public void delete(int id) {
//		manager.getTransaction().begin();
//		manager.remove(findOne(id));
//		manager.getTransaction().commit();
//	}
//
//	@Override
//	public void update(Brand brand) {
//		manager.getTransaction().begin();
//		manager.persist(brand);
//		manager.getTransaction().commit();
//	}
//
//	@Override
//	public List<Brand> findByTargetAudienceAndType(int targetAudienceId, int typeOfClothingId) {
//		
//		List<Brand> brands = manager.createQuery("select b from Brand b where b.brandName =:param").getResultList();
//
//		return brands;
//   
//	}
//	
////	public void addBrandToItemOfClothing(String brandName, int marking){
////		manager.getTransaction().begin();
////		
////		ItemOfClothing itemOfClothing = (ItemOfClothing) manager.
////				createQuery("select i from ItemOfClothing i where i.marking =:param").
////				setParameter("param", marking).
////				getSingleResult();
////		
////		
////		Brand brand = (Brand) manager.
////				createQuery("select b from Brand b where b.brandName =:param").
////				setParameter("param", brandName)
////				.getSingleResult();
////		
////		itemOfClothing.setBrand(brand);
////		
////		
////		manager.getTransaction().commit();
////	}
//
//}
