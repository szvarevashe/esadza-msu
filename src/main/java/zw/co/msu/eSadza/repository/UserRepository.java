package zw.co.msu.eSadza.repository;

import zw.co.msu.eSadza.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
