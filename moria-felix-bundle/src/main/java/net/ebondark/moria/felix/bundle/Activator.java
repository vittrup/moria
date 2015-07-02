package net.ebondark.moria.felix.bundle;

import net.ebondark.moria.felix.api.FileUploadPlugin;
import net.ebondark.moria.repositories.UserRepository;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class Activator implements BundleActivator {
    ServiceReference userRepositoryServiceReference;

    public void start(BundleContext context) throws Exception {
        userRepositoryServiceReference = context.getServiceReference(UserRepository.class.getName());
//        CustomerRepository customerRepository = (CustomerRepository) context.getService(customerRepositoryServiceReference);
        System.out.println("CustomerRepository >> " + userRepositoryServiceReference);

//        accountRepositoryServiceReference = context.getServiceReference(AccountRepository.class.getName());
//        AccountRepository accountRepository = (AccountRepository) context.getService(accountRepositoryServiceReference);
//        accountRepository.deleteAll();
//        accountRepository.save(new Account());
//        accountRepository.save(new Account());
//        accountRepository.save(new Account());
//        System.out.println("AccountRepository >> " + accountRepository.count());

//        activemqServiceReference = context.getServiceReference(ActivemqService.class.getName());
//        ActivemqService activemqService = (ActivemqService) context.getService(activemqServiceReference);
//        System.out.println("ActivemqService >> " + activemqService);
//        activemqService.start();


        context.registerService(FileUploadPlugin.class.getName(), new FileUploadPlugin() {

                    @Override
                    public void uploaded(File file) {
                        System.out.println("Plugin 'plugin-bundle' handling file: " + file.getName());
                    }

                    @Override
                    public Set<String> extensions() {
                        Set<String> extensions = new HashSet<String>();
                        extensions.add("txt");
                        return extensions;
                    }
                }, null);

//        context.registerService(WicketPlugin.class.getName(), new WicketPlugin() {
//
//                    @Override
//                    public String getHeader() {
//                        return "SAMPLE";
//                    }
//                }, null);
    }

    public void stop(BundleContext context) throws Exception {
        context.ungetService(userRepositoryServiceReference);
    }
}
