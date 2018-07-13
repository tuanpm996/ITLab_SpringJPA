package service;

import java.util.List;

import model.Item;

public interface ItemService {
	List<Item> findByCategory(String category, int pageIndex, int pageSize);
}
