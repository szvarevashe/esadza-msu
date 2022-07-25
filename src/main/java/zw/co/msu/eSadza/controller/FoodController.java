package zw.co.msu.eSadza.controller;

import zw.co.msu.eSadza.service.FoodService;
import zw.co.msu.eSadza.service.FoodServiceImpl;
import zw.co.msu.eSadza.model.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
public class FoodController {

	private final FoodService foodService;

	@Autowired
	public FoodController(FoodService foodService) {

		this.foodService = foodService;
	}

	@RequestMapping(value = "/menu")
	public List<Food> getMenu(Model model) {

		List<Food> foodItems;
		foodItems = foodService.getFoodList();
		return foodItems;
	}


}
