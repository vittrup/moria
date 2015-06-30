package net.ebondark.moria.repositories;

import net.ebondark.moria.domain.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.Assert.assertEquals;


/**
 * @author Kenneth Vittrup
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-repositories.xml"})
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Before
    public void init() {
        userRepository.deleteAll();
    }

    @After
    public void reset() {
        userRepository.deleteAll();
    }


    @Test
    public void createSimpleCustomer() {
        assertEquals("Unexpected log message", userRepository.count(), 0);
        User user = new User();
        user.setUsername("KENNETH");
        user.setPassword("VITTRUP");
        user.setEnabled(true);
        userRepository.save(user);
        assertEquals("Unexpected log message", userRepository.count(), 1);
    }
}
