package ssu.java.ermolaxe.service;

import ssu.java.ermolaxe.model.Customer;

import java.util.List;

/**
 * Created by Александр on 02.06.2017.
 */
public interface CustomerService {

    void save(Customer customer);

    List<Customer> getAllCustomers();
}
