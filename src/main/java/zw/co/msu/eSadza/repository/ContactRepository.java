package zw.co.msu.eSadza.repository;

import zw.co.msu.eSadza.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact,Integer> {
}
