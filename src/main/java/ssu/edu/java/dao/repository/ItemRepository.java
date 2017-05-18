package ssu.edu.java.dao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ssu.edu.java.model.Item;

import java.util.List;

/**
 * Created by Александр on 18.05.2017.
 */
@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
    List<Item> findAll();
}
