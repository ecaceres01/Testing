package Stubs;

public class StubConfiguration {
    private String domain, user, password;

    public StubConfiguration(String domain, String user, String password) {
        this.domain = domain;
        this.user = user;
        this.password = password;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
