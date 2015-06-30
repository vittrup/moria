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
public class RepositoriesManagerTest {

    @Autowired
    RepositoriesManager repositoriesManager;

    @Before
    public void init() {
        repositoriesManager.getUserRepository().deleteAll();
    }

    @After
    public void reset() {
        repositoriesManager.getUserRepository().deleteAll();
    }


    @Test
    public void createSimpleCustomer() {
        assertEquals("Unexpected log message", repositoriesManager.getUserRepository().count(), 0);
        User user = new User();
        user.setUsername("KENNETH");
        user.setPassword("VITTRUP");
        user.setEnabled(true);
        repositoriesManager.getUserRepository().save(user);
        assertEquals("Unexpected log message", repositoriesManager.getUserRepository().count(), 1);
    }
}
