package org.launchcode.inventorymvc.Service;



import org.launchcode.inventorymvc.models.User;
import org.launchcode.inventorymvc.models.UserRegistration;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistration registration);
}
