package net.ebondark.moria.repositories;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Kenneth Vittrup
 */
public class RepositoriesManager {

    @Autowired
    UserRepository userRepository;

    public UserRepository getUserRepository() {
        return userRepository;
    }

}
