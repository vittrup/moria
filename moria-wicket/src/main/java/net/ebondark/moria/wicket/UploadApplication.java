package net.ebondark.moria.wicket;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.apache.wicket.util.file.Folder;


/**
 * Application class for org.apache.wicket.examples.upload example.
 *
 * @author Eelco Hillenius
 */
public class UploadApplication extends WebApplication {
    private Folder uploadFolder = null;

    /**
     * Constructor.
     */
    public UploadApplication() {
    }


    /**
     * @see org.apache.wicket.Application#getHomePage()
     */
    @Override
    public Class<? extends Page> getHomePage() {
        return UploadPage.class;
    }

    /**
     * @return the folder for uploads
     */
    public Folder getUploadFolder() {
        return uploadFolder;
    }

    public void init() {
        super.init();
        getComponentInstantiationListeners().add(new SpringComponentInjector(this));
    }

}