package ua.com.clothes_shop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.com.clothes_shop.entity.Color;

public interface ColorDao extends JpaRepository<Color, Integer>, JpaSpecificationExecutor<Color>{
	
//	@Query("select c from Color c left join fetch c.itemsOfClothing i where i.marking=:param")
//	Color fetchColorWithItemsOfClothing(@Param("param")int marking);
//	
//	@Query("SELECT c FROM Color c JOIN c.itemsOfClothing i WHERE i.id = ?1")
//	List<Color> findByItemOfClothingId(int id);
	
//	@Query("SELECT c FROM Color c left join fetch c.itemsOfClothing i left join fetch i.typesOfClothing t left join fetch i.targetAudiences a WHERE i.targetAudience.id = ?1 and i.typeOfClothing.id = ?2")
//	List<Color> findByTargetAudienceAndType (int targetAudienceId, int typeOfClothingId);
	
	@Query("SELECT distinct c FROM Color c left join fetch c.itemsOfClothing i WHERE i.targetAudience.id = ?1 and i.typeOfClothing.id = ?2")
	List<Color> findByTargetAudienceAndType (int targetAudienceId, int typeOfClothingId);
	
	Color findByColor(String color);
}
