package ssu.java.ermolaxe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ssu.java.ermolaxe.model.Customer;
import ssu.java.ermolaxe.repository.CustomerRepository;

import java.util.List;

/**
 * Created by Александр on 02.06.2017.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void save(Customer customer) {
//        customer.setPassword(bCryptPasswordEncoder.encode(customer.getPassword()));
        customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerByLogin(String username) {
        return customerRepository.findByLogin(username);
    }
}
