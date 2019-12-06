import static org.junit.jupiter.api.Assertions.*;

import Organizador.XmppClient;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.sasl.SASLErrorException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.jxmpp.stringprep.XmppStringprepException;

@DisplayName("Pruebas de integración")
public class TestIntegracion {

    @Test
    @DisplayName("Dominio XMPP válido")
    void TestValidServer() {
        assertDoesNotThrow(()-> new XmppClient("binarylamp.cl", null, null));
    }

    @Test
    @DisplayName("Dominio XMPP inválido")
    void TestInvalidServer() {
        assertThrows(SmackException.class,
                () -> new XmppClient("wwwfail", "testing", "testing21"));
    }

    @Test
    @DisplayName("Dominio XMPP NULL")
    void TestNullServer() {
        assertThrows(XmppStringprepException.class,
                ()-> new XmppClient(null,"testing", "testing21"));
    }

    @Test
    @DisplayName("Contraseña NULL")
    void TestNullPass() {
        assertThrows(SmackException.class,
                ()-> new XmppClient("binarylamp.cl", "testing", null).makeConnection());
    }

    @Test
    @DisplayName("Contraseña inválida")
    void TestInvalidPass() {
        assertThrows(SASLErrorException.class,
                ()-> new XmppClient("binarylamp.cl", "user", "fail").makeConnection());
    }

    @Test
    @DisplayName("Usuario NULL")
    void TestNullUser() {
        assertThrows(IllegalArgumentException.class,
                ()-> new XmppClient("binarylamp.cl", null, "testing21").makeConnection());
    }

    @Test
    @DisplayName("Usuario inválido")
    void TestInvalidUser() {
        assertThrows(SASLErrorException.class,
                ()-> new XmppClient("binarylamp.cl", "fail", "testing21").makeConnection());
    }

    @Test
    @DisplayName("Conexión válida")
    void TestValidConnection() {
        assertDoesNotThrow(()-> new XmppClient("binarylamp.cl", "testing", "testing21").makeConnection());
    }

}
