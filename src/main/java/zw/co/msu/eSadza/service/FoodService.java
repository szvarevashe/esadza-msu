package zw.co.msu.eSadza.service;

import zw.co.msu.eSadza.model.Food;

import java.util.List;

public interface FoodService {

	public List<Food> getFoodList();
	public Food validateFoodInfo(String productId);

}
