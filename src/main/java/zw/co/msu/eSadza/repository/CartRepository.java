package zw.co.msu.eSadza.repository;

import zw.co.msu.eSadza.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Integer> {
}
