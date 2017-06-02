package ssu.java.ermolaxe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ssu.java.ermolaxe.model.Customer;

/**
 * Created by Александр on 02.06.2017.
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
