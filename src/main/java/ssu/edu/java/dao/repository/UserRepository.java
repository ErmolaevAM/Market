package ssu.edu.java.dao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ssu.edu.java.model.User;

/**
 * Created by Александр on 18.05.2017.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findUserByName(String name);

}
