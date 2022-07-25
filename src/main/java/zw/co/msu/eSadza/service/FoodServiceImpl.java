package zw.co.msu.eSadza.service;

import zw.co.msu.eSadza.model.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zw.co.msu.eSadza.repository.FoodRepository;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService{

	private final FoodRepository foodRepository;

	public FoodServiceImpl(FoodRepository foodRepository) {

		this.foodRepository = foodRepository;
	}


    public List<Food> getFoodList(){
        List<Food> food;
        food = foodRepository.findAll();
        return food;
    }

    public Food validateFoodInfo(String productId){
        Food food = null;
        food = foodRepository.findById(productId).get();
        return food;
    }
}

