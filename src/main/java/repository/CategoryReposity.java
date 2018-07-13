package repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import model.Category;

public interface CategoryReposity extends PagingAndSortingRepository<Category, Integer> {
	@Query("SELECT category FROM Category category join category.type type where type.name = :type")
	List<Category> findByType(@Param("type") String type, Pageable pagable);

	@Transactional
	@Modifying
	@Query("UPDATE Category cat SET cat.name = :name WHERE cat.id = :id")
	void update(@Param("id") Integer id, @Param("name") String name);
}
