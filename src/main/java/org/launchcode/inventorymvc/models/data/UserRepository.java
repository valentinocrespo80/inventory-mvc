package org.launchcode.inventorymvc.models.data;


import org.launchcode.inventorymvc.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository <User, Long> {
    User findByEmail(String email);
}
