package repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import model.Item;

public interface ItemRepository extends PagingAndSortingRepository<Item, Long> {

	@Query("SELECT obj FROM Item obj WHERE obj.id = :id")
	List<Item> findById(@Param("id") int id, Pageable pageable);

	@Query("SELECT item FROM Item item join item.categorys cat where cat.name = :category")
	List<Item> findByCategory(@Param("category") String category, Pageable pageable);
}
