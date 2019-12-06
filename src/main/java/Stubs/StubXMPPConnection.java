package Stubs;

import org.jxmpp.jid.parts.Resourcepart;
import org.jxmpp.stringprep.XmppStringprepException;

public class StubXMPPConnection {
    private StubConfiguration configuration;
    private boolean isConnected;
    private Resourcepart resourcepart;

    public StubXMPPConnection(StubConfiguration configuration) {
        this.configuration = configuration;
    }

    public void makeConnection() {
        if (configuration.getDomain() == this.getDomain()) {
            this.isConnected = true;
        } else { this.isConnected = false;}
    }

    public boolean isConnected() {
        return isConnected;
    }

    public void login(String user, String password, String resourcepart) throws XmppStringprepException {
        configuration.setUser(user);
        configuration.setPassword(password);
        this.resourcepart = Resourcepart.from(resourcepart);
    }

    public String getUser() {
        return configuration.getUser();
    }

    public String getPassword() {
        return configuration.getPassword();
    }

    public String getDomain() {
        return configuration.getDomain();
    }
}
