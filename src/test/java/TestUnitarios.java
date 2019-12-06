import Stubs.StubAccountManager;
import Stubs.StubConfiguration;
import Stubs.StubXMPPConnection;
import Stubs.StubXMPPServer;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestUnitarios {
    StubConfiguration configuration;
    StubXMPPConnection connection;
    StubXMPPServer xmppServer;
    StubAccountManager accountManager;

    @BeforeEach
    public void ConfigTest() {
        configuration = new StubConfiguration("binarylamp.cl","testing","testing21");
        connection = new StubXMPPConnection(configuration);
        xmppServer = new StubXMPPServer(true, true, true);
        accountManager = new StubAccountManager(connection);
    }

    @Test
    @DisplayName("ConfiguracionManager")
    public void TestXMPPConfiguration() {
        assertNotEquals(1234, configuration.getUser());
        assertNotEquals("TESTING", configuration.getUser());
        assertNotEquals(4567, configuration.getPassword());
        assertNotEquals("asdf45", configuration.getPassword());
        assertNotEquals("test.cl",configuration.getDomain());
    }

    @Test
    @DisplayName("XMPP Connection")
    public void TestXMPPConnection() {
        assertEquals("testing", connection.getUser());
        assertEquals("testing21", connection.getPassword());
        assertNotSame("admin", connection.getPassword());
        assertNotSame("admin", connection.getUser());
    }

    @Test
    @DisplayName("AccountManager")
    public void TestGenerateAccount() {
        assertEquals(accountManager.getUser(), connection.getUser());
        assertEquals(accountManager.getPassword(), connection.getPassword());
    }
}
