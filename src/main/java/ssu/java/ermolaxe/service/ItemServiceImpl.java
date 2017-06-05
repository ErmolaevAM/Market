package ssu.java.ermolaxe.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssu.java.ermolaxe.model.Customer;
import ssu.java.ermolaxe.model.Item;
import ssu.java.ermolaxe.repository.ItemRepository;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{
    private static final Logger LOGGER = LoggerFactory.getLogger(ItemServiceImpl.class);

    @Autowired
    private ItemRepository itemRepository;

    public void save(Item item) {
        itemRepository.save(item);

        StringBuilder msg = new StringBuilder();
        msg.append("Item [").append(item.toString()).append("] save into database");
        LOGGER.info(msg.toString(), Level.INFO);
    }

    public List<Item> getAllItems() {
        StringBuilder msg = new StringBuilder();
        msg.append("User requested a list of all items");
        LOGGER.info(msg.toString(), Level.INFO);

        return itemRepository.findAll();
    }

    public List<Item> getBySeller(Customer customer) {
        StringBuilder msg = new StringBuilder();
        msg.append("User requested a list of items by seller [").append(customer.getId()).append(", ").append(customer.getLogin()).append("]");
        LOGGER.info(msg.toString(), Level.INFO);

        return itemRepository.findBySeller(customer);
    }

    public List<Item> getByBuyer(Customer customer) {
        StringBuilder msg = new StringBuilder();
        msg.append("User requested a list of items by buyer [").append(customer.getId()).append(", ").append(customer.getLogin()).append("]");
        LOGGER.info(msg.toString(), Level.INFO);

        return itemRepository.findByBuyer(customer);
    }

    public List<Item> getAllItemsByNullBuyer() {
        StringBuilder msg = new StringBuilder();
        msg.append("User requested a list of items without buyer");
        LOGGER.info(msg.toString(), Level.INFO);

        return itemRepository.findByBuyerNull();
    }

    public void buy(Customer customer, Item item) {
        item.setBuyer(customer);
        item.setSold(true);
        itemRepository.save(item);

        StringBuilder msg = new StringBuilder();
        msg.append("User [")
                .append(customer.getId())
                .append(", ")
                .append(customer.getLogin())
                .append("] bought item [")
                .append(item.toString())
                .append("]");
        LOGGER.info(msg.toString(), Level.INFO);
    }
}
