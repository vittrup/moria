package net.ebondark.moria.felix;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

/**
 * Created by IntelliJ IDEA.
 * User: nebulus
 * Date: 14-06-11
 * Time: 01:05
 * To change this template use File | Settings | File Templates.
 */
public class HostActivatorWrapper implements BundleActivator {

    private BundleContext context = null;

    private String clazz;

    private Object service;

    private ServiceRegistration serviceRegistration = null;

    public HostActivatorWrapper(String clazz, Object service) {
        this.clazz = clazz;
        this.service = service;
    }

    public void start(BundleContext context) {
        this.context = context;
        serviceRegistration = context.registerService(clazz, service, null);
        System.out.println("Registered service: " + service + " as " + clazz);
    }

    public void stop(BundleContext context) {
        serviceRegistration.unregister();
        context = null;
    }
}
