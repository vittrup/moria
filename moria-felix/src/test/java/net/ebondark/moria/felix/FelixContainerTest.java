package net.ebondark.moria.felix;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * @author Kenneth Vittrup
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-felix.xml", "classpath:applicationContext-repositories.xml"})
public class FelixContainerTest {

    @Autowired
    FelixContainer felixContainer;

//    @Before
//    public void init() {
//        repositoriesManager.getUserRepository().deleteAll();
//    }
//
//    @After
//    public void reset() {
//        repositoriesManager.getUserRepository().deleteAll();
//    }
//
//
//    @Test
//    public void createSimpleCustomer() {
//        assertEquals("Unexpected log message", repositoriesManager.getUserRepository().count(), 0);
//        User user = new User();
//        user.setUsername("KENNETH");
//        user.setPassword("VITTRUP");
//        user.setEnabled(true);
//        repositoriesManager.getUserRepository().save(user);
//        assertEquals("Unexpected log message", repositoriesManager.getUserRepository().count(), 1);
//    }

    @Test
    public void startFelixContainer() {
        System.out.println(felixContainer.getFelix().getBundleContext().getBundles()[0]);
    }
}
