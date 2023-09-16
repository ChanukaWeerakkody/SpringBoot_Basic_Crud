package lk.ijse.gdse.Hello.dao;

import lk.ijse.gdse.Hello.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : Chanuka Weerakkody
 * @since : 20.1.1
 **/

public interface CustomerDAO extends JpaRepository<Customer,String> {
}
