package ssu.java.ermolaxe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ssu.java.ermolaxe.model.Customer;
import ssu.java.ermolaxe.model.Item;

import java.util.List;

/**
 * Created by Александр on 02.06.2017.
 */
public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findBySeller(Customer customer);
    List<Item> findByBuyer(Customer customer);
}
