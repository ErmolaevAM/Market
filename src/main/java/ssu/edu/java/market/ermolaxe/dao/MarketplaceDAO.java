package ssu.edu.java.market.ermolaxe.dao;

import ssu.edu.java.market.ermolaxe.model.Good;
import ssu.edu.java.market.ermolaxe.model.User;

import java.util.List;

/**
 * Created by Александр on 11.05.2017.
 */
public interface MarketplaceDAO {
    List<User> getAllUsers();

    User getUserByName(String username);

    User getUserById(int id);

    List<Good> getAllGoods();

    Good getGoodByName(String goodname);

    Good getGoodById(int id);

}
