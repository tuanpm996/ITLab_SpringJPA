package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import model.Category;
import repository.CategoryReposity;
import service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryReposity categoryReposity;

	@Override
	public List<Category> findByType(String type, int pageIndex, int pageSize) {
		return categoryReposity.findByType(type, PageRequest.of(pageIndex, pageSize));
	}

	@Override
	public void update(Integer id, String name) {
		categoryReposity.update(id, name);

	}

}
