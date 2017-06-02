package ssu.java.ermolaxe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssu.java.ermolaxe.model.Customer;
import ssu.java.ermolaxe.model.Item;
import ssu.java.ermolaxe.repository.ItemRepository;

import java.util.List;

/**
 * Created by Александр on 02.06.2017.
 */
@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private ItemRepository itemRepository;

    public void save(Item item) {
        itemRepository.save(item);
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public List<Item> getBySeller(Customer customer) {
        return itemRepository.findBySeller(customer);
    }

    public List<Item> getByBuyer(Customer customer) {
        return itemRepository.findByBuyer(customer);
    }

    public void buy(Customer customer, Item item) {
        item.setBuyer(customer);
        item.setSold(true);
        itemRepository.save(item);
    }
}
