package net.ebondark.moria.wicket;

import net.ebondark.moria.repositories.RepositoriesManager;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.spring.injection.annot.SpringBean;

public class HomePage extends WebPage {
    private static final long serialVersionUID = 1L;

    @SpringBean
    RepositoriesManager domainRepositoriesManager;


//	@SpringBean
//	private FelixContainer felixContainer;

    public HomePage() {
        add(new Label("version", Long.toString(domainRepositoriesManager.getUserRepository().count())));
//		add(new Label("version", Integer.toString(felixContainer.getServiceTracker().getTrackingCount())));
//
//		try {
//			Exporter exporter = (Exporter) felixContainer.getServiceTracker().getServices()[0];
//			File file = exporter.getExportFile();
//			DownloadLink linkWithStateChange = new DownloadLink("link1", file);
//			add(linkWithStateChange);
//		} catch (IOException e) {
//			add(new ExternalLink("link1","http://google.com","1"));
//		}
//
//		try {
//			Exporter exporter = (Exporter) felixContainer.getServiceTracker().getServices()[1];
//			File file = exporter.getExportFile();
//			DownloadLink linkWithStateChange = new DownloadLink("link2", file);
//			add(linkWithStateChange);
//		} catch (IOException e) {
//			add(new ExternalLink("link2","http://google.com","2"));
//		}
    }
}
