package net.wmlabs.moria.repository;

import net.wmlabs.moria.domain.Authority;
import net.wmlabs.moria.domain.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;
import java.util.Set;


/**
 * @author Oliver Gierke
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-repositories.xml"})
public class CustomerRepositoryHsqlTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthorityRepository authorityRepository;


    @Before
    public void init() {
        userRepository.deleteAll();
        authorityRepository.deleteAll();
    }

    @After
    public void reset() {
        userRepository.deleteAll();
    }


    @Test
    public void createSimpleCustomer() {
        System.out.println("a>" + userRepository.count());
        System.out.println("a>" + authorityRepository.count());
        User user = new User();
        user.setUsername("KENNETH");
        user.setPassword("VITTRUP");
        user.setEnabled(true);
        Set<Authority> auths = new HashSet<Authority>();
        auths.add(new Authority("XXX"));
        user.setAuthorities(auths);
        userRepository.save(user);
        System.out.println("b>" + userRepository.count());
        System.out.println("b>" + authorityRepository.count());
        userRepository.delete(user);
        System.out.println("c>" + userRepository.count());
        System.out.println("c>" + authorityRepository.count());
    }
}
