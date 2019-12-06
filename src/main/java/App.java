import Organizador.PropertiesManager;
import Organizador.XmppClient;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;

import java.io.File;
import java.io.IOException;

public class App {
    private static File file = new File(System.getProperty("user.dir") + "/config.properties");
    private static XmppClient xmppClient = null;
    private static PropertiesManager propertiesManager = null;
    private static boolean checkOwner;

    public static void main(String[] args) {
        String domain = "binarylamp.cl";
        String user = "testing";
        String password = "testing21";

        if (!file.exists()) {
            //Si el archivo NO existe trata de inicializar una instancia de XmppClient y PropertiesManager,
            //Después intenta inicializar la conexión al servidor XMPP
            try {
                xmppClient = new XmppClient(domain, user, password);
                propertiesManager = new PropertiesManager(domain, user, password);

                xmppClient.generateAccount();
                xmppClient.makeConnection();
            } catch (Exception e) {
                file.delete();
                e.printStackTrace();
                System.out.println("ERROR: Ha ocurrido un problema, por favor intente más tarde");
            }
        } else {
            //Si el archivo existe, llamar cargar los datos desde el archivo, y inicializar la conexión
            try {
                if (xmppClient == null) {
                    propertiesManager = new PropertiesManager();
                    xmppClient = new XmppClient(
                            propertiesManager.getDomain(),
                            propertiesManager.getUser(),
                            propertiesManager.getPassword()
                    );

                    xmppClient.makeConnection();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SmackException e) {
                e.printStackTrace();
            } catch (XMPPException e) {
                e.printStackTrace();
            }
        }
    }
}
