package net.ebondark.moria.wicket;

import net.ebondark.moria.felix.FelixSpringBean;
import net.ebondark.moria.felix.api.FileUploadPlugin;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.upload.FileUpload;
import org.apache.wicket.markup.html.form.upload.FileUploadField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.util.lang.Bytes;
import org.osgi.util.tracker.ServiceTracker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

//import net.wmlabs.ebondark.felix.FelixSpringBean;
//import net.wmlabs.ebondark.plugin.api.FileUploadPlugin;


/**
 * Upload example.
 *
 * @author Eelco Hillenius
 */
@SuppressWarnings("serial")
public class UploadPage extends WebPage {


    @SpringBean
    private FelixSpringBean felixSpringBean;

    /*
    @SpringBean
    private JackrabbitSpringBean jackrabbitSpringBean;
    */

    /*
    @SpringBean
    private ActivemqService activemqService;
    */

//    @SpringBean
//    UserRepository userRepository;

    /**
     * Form for uploads.
     */
    private class FileUploadForm extends Form<Void> {
        private FileUploadField fileUploadField;

        /**
         * Construct.
         *
         * @param name Component name
         */
        public FileUploadForm(String name) {
            super(name);

            // set this form to multipart mode (allways needed for uploads!)
            setMultiPart(true);

            // Add one file input field
            add(fileUploadField = new FileUploadField("fileInput"));

            // Set maximum size to 100K for demo purposes
            setMaxSize(Bytes.kilobytes(100));
        }

        /**
         * @see org.apache.wicket.markup.html.form.Form#onSubmit()
         */
        @Override
        protected void onSubmit() {
            FileUpload upload = fileUploadField.getFileUpload();
            String filename = upload.getClientFileName();
            String extension = filename.toLowerCase().substring(filename.lastIndexOf(".") + 1);
            try {
                File file = upload.writeToTempFile();
                handleUploadedFile(extension, file);
                file.delete();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void handleUploadedFile(String extension, File file) {
        ServiceTracker serviceTracker = felixSpringBean.getFelixContainer().getServices().get(FileUploadPlugin.class);
        Object[] services = serviceTracker.getServices();

        for (int i = 0; (services != null) && (i < services.length); i++) {
            try {
                FileUploadPlugin plugin = (FileUploadPlugin) services[i];
                if (plugin.extensions().contains(extension)) {
                    plugin.uploaded(file);
                }
            } catch (Exception ex) {
                System.err.println(ex);
            }
        }

        /*
        try {
            activemqService.start();
        } catch (JMSException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        */
    }

    /**
     * Log.
     */
    private static final Logger log = LoggerFactory.getLogger(UploadPage.class);

    /**
     * Reference to listview for easy access.
     */
//    private final FileListView fileListView;

    /**
     * Constructor.
     */
    public UploadPage() {

//        System.out.println("felix --> " + felixSpringBean.getFelixContainer());
//        System.out.println("jackrabbit --> " + jackrabbitSpringBean.getJackrabbitRepository());
//        try {
//            jackrabbitSpringBean.testLogin();
//        } catch (RepositoryException e) {
//            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//        }
//        System.out.println("activemq --> " + activemqService);

//        System.out.println("userRepository #1--> " + userRepository.count());
//        userRepository.save(new User("kenneth", "vittrup", true));
//        System.out.println("userRepository #2--> " + userRepository.count());

        // Create feedback panels
        final FeedbackPanel uploadFeedback = new FeedbackPanel("uploadFeedback");

        // Add uploadFeedback to the page itself
        add(uploadFeedback);

        // Add simple upload form, which is hooked up to its feedback panel by
        // virtue of that panel being nested in the form.
        final FileUploadForm simpleUploadForm = new FileUploadForm("simpleUpload");
        add(simpleUploadForm);
    }
}