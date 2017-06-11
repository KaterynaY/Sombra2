package ua.com.clothes_shop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import ua.com.clothes_shop.entity.Brand;

public interface BrandDao extends JpaRepository<Brand, Integer>, JpaSpecificationExecutor<Brand>{
	
	Brand findByBrandName(String brandName);
	
	@Query("SELECT distinct b FROM Brand b left join fetch b.itemsOfClothing i WHERE i.targetAudience.id = ?1 and i.typeOfClothing.id = ?2")
	List<Brand> findByTargetAudienceAndType (int targetAudienceId, int typeOfClothingId);

//    void save(Brand brand);
//	
//	List<Brand> findAll();
//	
//	Brand findOne(int id);
//	
//	Brand findByBrandName(String brandName);
//	
//	void delete(int id);
//	
//	void update (Brand brand);
//	
//	List<Brand> findByTargetAudienceAndType (int targetAudienceId, int typeOfClothingId);
		
}
