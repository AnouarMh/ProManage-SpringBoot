package tn.spring.springboot.entities;

public class JwtResponse {
    private Account account;
    private String jwtToken;

    public JwtResponse(Account account, String jwtToken) {
        this.account = account;
        this.jwtToken = jwtToken;
    }

    public Account getUser() {
        return account;
    }

    public void setUser(Account account) {
        this.account = account;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
