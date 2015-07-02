package net.ebondark.moria.wicket;

import org.apache.wicket.protocol.http.WebApplication;

public class WicketApplication extends WebApplication {
    /**
     * @see org.apache.wicket.Application#getHomePage()
     */
    @Override
    public Class<HomePage> getHomePage() {
        return HomePage.class;
    }
}