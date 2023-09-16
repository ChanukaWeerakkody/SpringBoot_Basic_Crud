package lk.ijse.gdse.Hello.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.Hello.dao.CustomerDAO;
import lk.ijse.gdse.Hello.dto.CustomerDTO;
import lk.ijse.gdse.Hello.entity.Customer;
import lk.ijse.gdse.Hello.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : Chanuka Weerakkody
 * @since : 20.1.1
 **/
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDAO customerDAO;

    @Autowired
    ModelMapper mapper;


    @Override
    public void saveCustomer(CustomerDTO dto) {
        if(!customerDAO.existsById(dto.getId())){
            customerDAO.save(mapper.map(dto, Customer.class));
        }else{
            throw new RuntimeException("Customer id is exists!");
        }
    }

    @Override
    public void deleteCustomer(String id) {
        if(customerDAO.existsById(id)){
            customerDAO.deleteById(id);
        }else{
            throw new RuntimeException("Customer id is not found!");
        }
    }

    @Override
    public void updateCustomer(CustomerDTO dto) {
        if(customerDAO.existsById(dto.getId())){
            customerDAO.save(mapper.map(dto, Customer.class));
        }else{
            throw new RuntimeException("Customer id is not found!");
        }
    }

    @Override
    public CustomerDTO searchCustomer(String id) {
        if (customerDAO.existsById(id)) {
            Customer customer = customerDAO.findById(id).get();
            return new CustomerDTO(customer.getId(), customer.getName(), customer.getCity(), customer.getEmail());
        }else{
            throw new RuntimeException("Customer id is not found!");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        List<Customer> all = customerDAO.findAll();
        return mapper.map(all,new TypeToken<CustomerDTO>(){}.getType());
    }
}
