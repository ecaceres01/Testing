package Stubs;

public class StubXMPPServer {
    private boolean serverStatus, accountStatus, connectionStatus;

    public StubXMPPServer(boolean serverStatus, boolean accountStatus, boolean connectionStatus) {
        this.serverStatus = serverStatus;
        this.accountStatus = accountStatus;
        this.connectionStatus = connectionStatus;
    }

    public boolean connectionStatus() {
        return connectionStatus;
    }

    public void setConnectionStatus(boolean connectionStatus) {
        this.connectionStatus = connectionStatus;
    }

    public boolean serverStatus() {
        return serverStatus;
    }

    public void setServerStatus(boolean serverStatus) {
        this.serverStatus = serverStatus;
    }

    public boolean accountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(boolean accountStatus) {
        this.accountStatus = accountStatus;
    }
}
