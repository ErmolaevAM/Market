package ssu.java.ermolaxe.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ssu.java.ermolaxe.model.Customer;
import ssu.java.ermolaxe.repository.CustomerRepository;

import java.util.List;
import java.util.logging.Level;

/**
 * Created by Александр on 02.06.2017.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Autowired
    private CustomerRepository customerRepository;

    /*@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;*/

    public void save(Customer customer) {
//        customer.setPassword(bCryptPasswordEncoder.encode(customer.getPassword()));
//        customer.setPassword(String.valueOf(customer.getPassword().hashCode()));
        customerRepository.save(customer);

        StringBuilder msg = new StringBuilder();
        msg.append("Customer [").append(customer.getId()).append(", ").append(customer.getLogin()).append("] save into database");
        LOGGER.info(msg.toString(), Level.INFO);
    }

    public List<Customer> getAllCustomers() {
        StringBuilder msg = new StringBuilder();
        msg.append("User requested a list of all customers");
        LOGGER.info(msg.toString(), Level.INFO);

        return customerRepository.findAll();
    }

    public Customer getCustomerByLogin(String username) {
        StringBuilder msg = new StringBuilder();
        msg.append("User requested customer with login [").append(username).append("]");
        LOGGER.info(msg.toString(), Level.INFO);

        return customerRepository.findByLogin(username);
    }
}
