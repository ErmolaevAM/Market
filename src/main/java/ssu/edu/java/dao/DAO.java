package ssu.edu.java.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ssu.edu.java.dao.repository.ItemRepository;
import ssu.edu.java.dao.repository.UserRepository;
import ssu.edu.java.model.Item;
import ssu.edu.java.model.User;

import java.util.List;

/**
 * Created by Александр on 18.05.2017.
 */
@Component
public class DAO {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ItemRepository itemRepository;

    public User getUserById(long id) {
        return userRepository.findOne(id);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User getUserByName(String name) {
        return userRepository.findUserByName(name);
    }

    public Item getItemById(long id) {
        return itemRepository.findOne(id);
    }

    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    public void buy(User user, Item item) {
        item.setBuyer(user);
        item.setBought(true);
        itemRepository.save(item);
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

}
