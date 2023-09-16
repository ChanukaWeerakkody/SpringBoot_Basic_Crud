package lk.ijse.gdse.Hello.service;

import lk.ijse.gdse.Hello.dto.CustomerDTO;

import java.util.List;

/**
 * @author : Chanuka Weerakkody
 * @since : 20.1.1
 **/

public interface CustomerService {
    void saveCustomer(CustomerDTO dto);
    void deleteCustomer(String id);
    void updateCustomer(CustomerDTO dto);
    CustomerDTO searchCustomer(String id);
    List<CustomerDTO> getAllCustomer();
}
