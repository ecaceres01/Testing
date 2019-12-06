package Organizador;

import org.jivesoftware.smack.AbstractXMPPConnection;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration;
import org.jivesoftware.smackx.iqregister.AccountManager;
import org.jxmpp.jid.parts.Localpart;
import org.jxmpp.jid.parts.Resourcepart;
import org.jxmpp.stringprep.XmppStringprepException;

import java.io.IOException;

public class XmppClient {
    private String domain, user, password; //Datos básicos necesarios
    private XMPPTCPConnectionConfiguration configuration; //Clase para configurar la conexión XMPP
    private AbstractXMPPConnection connection; // Clase abstracta para realizar conexión TCP o BOSH


    public XmppClient(String domain, String user, String password) throws IOException, InterruptedException, XMPPException, SmackException {
        this.domain = domain;
        this.user = user;
        this.password = password;

        configuration = XMPPTCPConnectionConfiguration.builder()
                .setXmppDomain(domain)
                .setSecurityMode(ConnectionConfiguration.SecurityMode.disabled)
                .enableDefaultDebugger()
                .build();

        connection = new XMPPTCPConnection(configuration);
        connection.connect();

        System.out.println("INFO: Conectanse a " + connection.getXMPPServiceDomain().toString());
    }

    public void makeConnection() throws IOException, InterruptedException, SmackException, XMPPException {
        System.out.println("INFO: Intentando conexión...");
        connection.login(user, password, Resourcepart.from("test"));
        System.out.println("INFO: Ingresando a servidor como usuario " + connection.getUser());
    }

    public void generateAccount() throws XmppStringprepException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException, SmackException.NoResponseException {
        System.out.println("INFO: Generando cuenta en el servidor...");
        AccountManager accountManager = AccountManager.getInstance(connection);
        accountManager.sensitiveOperationOverInsecureConnection(true);
        accountManager.createAccount(Localpart.from(user), password);
        System.out.println("INFO: Cuenta generada");
    }

}
