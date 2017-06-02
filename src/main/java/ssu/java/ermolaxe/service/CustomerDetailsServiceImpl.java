package ssu.java.ermolaxe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ssu.java.ermolaxe.model.Customer;
import ssu.java.ermolaxe.repository.CustomerRepository;

import java.util.ArrayList;

/**
 * Created by Александр on 02.06.2017.
 */
@Service
public class CustomerDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByLogin(username);

        return new User(customer.getLogin(), customer.getPassword(), true, true, true, true, new ArrayList<GrantedAuthority>());
    }
}
