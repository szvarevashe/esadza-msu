package zw.co.msu.eSadza.repository;

import zw.co.msu.eSadza.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FoodRepository extends JpaRepository<Food,String> {

}
