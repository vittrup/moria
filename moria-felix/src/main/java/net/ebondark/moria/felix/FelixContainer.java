package net.ebondark.moria.felix;

import net.ebondark.moria.felix.api.FileUploadPlugin;
import net.ebondark.moria.repositories.RepositoriesManager;
import org.apache.felix.framework.Felix;
import org.apache.felix.framework.util.StringMap;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleException;
import org.osgi.util.tracker.ServiceTracker;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.*;

public class FelixContainer {

    /**
     * The directory for OSGI bundles enabled for the Felix OSGI container.
     * These will be installed and started on server startup.
     */
//    @Autowired
    private String directory = "C:\\Users\\kenneth.vittrup\\idea\\moria\\moria-felix-bundle\\target";

//    @Autowired
    private String cacheDirectory = "target";;

    private Felix m_felix = null;

    private Map<Class, ServiceTracker> services;

    @Autowired
    private RepositoriesManager repositoriesManager;

    /**
     * @param directory the directory for the OSGI bundles to enable
     */
    public void setDirectory(String directory) {
        this.directory = directory;
    }

    /**
     * @param cacheDirectory the cache directory to use for the OSGI container
     */
    public void setCacheDirectory(String cacheDirectory) {
        this.cacheDirectory = cacheDirectory;
    }

    public Map<Class, ServiceTracker> getServices() {
        return services;
    }

    /**
     * Initialize felix
     */
    public void startFelixContainer() {

        try {
            StringMap felixConfiguration = new StringMap();

            felixConfiguration.put("org.osgi.framework.storage", cacheDirectory);
            felixConfiguration.put("org.osgi.framework.storage.clean", "onFirstInit");

            felixConfiguration.put("osgi.shell.telnet.ip", "127.0.0.1");
            felixConfiguration.put("osgi.shell.telnet.port", "5555");
            felixConfiguration.put("osgi.shell.telnet.maxconn", "2");
            felixConfiguration.put("osgi.shell.telnet.socketTimeout", "0");

            StringBuilder bldr = new StringBuilder();
            bldr.append("net.ebondark.moria; version=1.0.0,");
            bldr.append("net.ebondark.moria.repositories; version=1.0.0,");
            bldr.append("net.ebondark.moria.activemq; version=1.0.0,");
            bldr.append("net.ebondark.moria.felix.api; version=1.0.0,");
            bldr.append("org.osgi.framework; version=1.1.0");

            felixConfiguration.put("org.osgi.framework.system.packages.extra", bldr.toString());

            List<BundleActivator> list = new ArrayList<BundleActivator>();
//            HostActivatorWrapper accountRepositoryHostActivator = new HostActivatorWrapper("net.wmlabs.ebondark.repository.AccountRepository", repositoriesManager.getAccountRepository());
//            list.add(accountRepositoryHostActivator);

            HostActivatorWrapper userRepositoryHostActivator = new HostActivatorWrapper("net.ebondark.moria.repositories.UserRepository", repositoriesManager.getUserRepository());
            list.add(userRepositoryHostActivator);

//            HostActivatorWrapper customerRepositoryHostActivator = new HostActivatorWrapper("net.wmlabs.ebondark.repository.CustomerRepository", repositoriesManager.getCustomerRepository());
//            list.add(customerRepositoryHostActivator);

            HostActivator activator = new HostActivator();
            list.add(activator);
            felixConfiguration.put("felix.systembundle.activators", list);

            m_felix = new Felix(felixConfiguration);
            System.out.println("Starting Felix OSGI container");

            m_felix.start();

            services = new HashMap<Class, ServiceTracker>();
            services.put(FileUploadPlugin.class, new ServiceTracker(activator.getContext(), FileUploadPlugin.class.getName(), null));
            services.get(FileUploadPlugin.class).open();

//            File shell = new File(directory + "/org.apache.felix.shell-1.4.2.jar");
//            System.out.println("Installing plugin #" + shell.getName());
//            m_felix.getBundleContext().installBundle("file:" + shell.getAbsolutePath()).start();
//
//            File remote = new File(directory + "/org.apache.felix.shell.remote-1.1.2.jar");
//            System.out.println("Installing plugin #" + remote.getName());
//            m_felix.getBundleContext().installBundle("file:" + remote.getAbsolutePath()).start();
//
            File openoffice = new File(directory + "/plugin-felix-bundle-1.0-SNAPSHOT.jar");
            System.out.println("Installing plugin #" + openoffice.getName());
            m_felix.getBundleContext().installBundle("file:" + openoffice.getAbsolutePath()).start();


        } catch (Exception ex) {
            System.out.println("Could not start Felix OSGI container");
            ex.printStackTrace();
        }
    }

    public void stopFelixContainer() {
        if (m_felix != null) {

            System.out.println("Stopping All Tracked Services");
            for (ServiceTracker serviceTracker : services.values()) {
                serviceTracker.close();
            }

            try {
                System.out.println("Stopping Felix OSGI container");
                m_felix.stop();
                m_felix.waitForStop(0);
            } catch (BundleException e) {
                System.out.println("Could not stop Felix OSGI container");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

//    class PropertiesFilenameFilter implements FilenameFilter {
//        @Override
//        public boolean accept(File file, String name) {
//            return name.toLowerCase().endsWith(".properties");
//        }
//    }
//
//    class ArchiveFilenameFilter implements FilenameFilter {
//        @Override
//        public boolean accept(File file, String name) {
//            return name.toLowerCase().endsWith(".jar");
//        }
//    }

    public Felix getFelix(){
        return m_felix;
    }

    public void setRepositoriesManager(RepositoriesManager repositoriesManager) {
        this.repositoriesManager = repositoriesManager;
    }
}
