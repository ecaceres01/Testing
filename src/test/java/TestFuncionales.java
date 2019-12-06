import Stubs.StubAccountManager;
import Stubs.StubConfiguration;
import Stubs.StubXMPPConnection;
import Stubs.StubXMPPServer;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.jxmpp.stringprep.XmppStringprepException;

public class TestFuncionales {
    StubConfiguration configuration;
    StubXMPPConnection connection;
    StubXMPPServer xmppServer;
    StubAccountManager accountManager;

    @BeforeEach
    public void ConfigTest() {
        configuration = new StubConfiguration("binarylamp.cl","testing","testing21");
        connection = new StubXMPPConnection(configuration);
        xmppServer = new StubXMPPServer(true, false, false);
        accountManager = new StubAccountManager(connection);
    }

    @Test
    @DisplayName("Creación correcta de cuenta y login")
    public void TestRightAccountCreation() throws XmppStringprepException {
        assertEquals(configuration.getDomain(), connection.getDomain());
        connection.makeConnection();
        xmppServer.setConnectionStatus(true);
        assertEquals(connection.isConnected(), xmppServer.connectionStatus());
        accountManager.createAccount(connection.getUser(), connection.getPassword());
        accountManager.isAccountCreated();
        xmppServer.setAccountStatus(true);
        assertEquals(accountManager.isAccountCreated(), xmppServer.accountStatus());
        connection.login(configuration.getUser(), configuration.getPassword(), "test");
    }

    @Test
    @DisplayName("Creación de cuenta ya existente")
    public void TestAccountAlreadyExisted() {
        assertEquals(configuration.getDomain(), connection.getDomain());
        connection.makeConnection();
        xmppServer.setConnectionStatus(true);
        assertEquals(connection.isConnected(), xmppServer.connectionStatus());
        accountManager.createAccount(connection.getUser(), connection.getPassword());
        accountManager.isAccountCreated();
        assertNotSame(accountManager.isAccountCreated(), xmppServer.accountStatus());
    }

    @Test
    @DisplayName("login de cuenta ya creada")
    public void TestLogIn() throws XmppStringprepException {
        xmppServer.setAccountStatus(true);
        assertEquals(configuration.getDomain(), connection.getDomain());
        connection.makeConnection();
        xmppServer.setConnectionStatus(true);
        assertEquals(connection.isConnected(), xmppServer.connectionStatus());
        connection.login(configuration.getUser(), configuration.getPassword(), "test");
    }

}
