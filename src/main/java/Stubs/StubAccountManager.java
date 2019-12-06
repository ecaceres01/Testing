package Stubs;

public class StubAccountManager {
    private boolean accountCreated;
    private StubXMPPConnection connection;

    public StubAccountManager(StubXMPPConnection connection) {
        this.connection = connection;
    }

    public String getUser() {
        return connection.getUser();
    }

    public String getPassword() {
        return connection.getPassword();
    }

    public boolean isAccountCreated() {
        return this.accountCreated;
    }

    public void createAccount(String user, String password) {
        if (user == connection.getUser() && password == connection.getPassword()){
            this.accountCreated = true;
        } else { this.accountCreated = false; }
    }

}
