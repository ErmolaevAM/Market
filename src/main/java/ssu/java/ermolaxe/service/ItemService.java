package ssu.java.ermolaxe.service;

import ssu.java.ermolaxe.model.Customer;
import ssu.java.ermolaxe.model.Item;

import java.util.List;

/**
 * Created by Александр on 02.06.2017.
 */
public interface ItemService {
    void save(Item item);

    List<Item> getAllItems();
    List<Item> getBySeller(Customer customer);
    List<Item> getByBuyer(Customer customer);

    List<Item> getAllItemsByNullBuyer();

    void buy(Customer customer, Item item);
}
