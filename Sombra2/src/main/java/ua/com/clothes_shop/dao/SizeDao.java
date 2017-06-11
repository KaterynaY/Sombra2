package ua.com.clothes_shop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import ua.com.clothes_shop.entity.Size;

public interface SizeDao extends JpaRepository<Size, Integer>, JpaSpecificationExecutor<Size>{
	
	Size findBySize(String size);
	
	@Query("SELECT distinct s FROM Size s left join fetch s.itemsOfClothing i WHERE i.targetAudience.id = ?1 and i.typeOfClothing.id = ?2")
	List<Size> findByTargetAudienceAndType (int targetAudienceId, int typeOfClothingId);

}
