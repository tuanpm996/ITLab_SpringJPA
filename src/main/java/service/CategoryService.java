package service;
import java.util.List;

import org.springframework.stereotype.Service;

import model.Category;
@Service
public interface CategoryService {
	List<Category> findByType(String type, int pageIndex, int pageSize);

	void update(Integer id, String name);
}
