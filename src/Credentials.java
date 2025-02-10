package org.example;

public class Credentials {
    private String email;
    private String password;

    public Credentials() {
        setEmail("");
        setPassword("");
    }

    public Credentials(String email, String password) {
        setEmail(email);
        setPassword(password);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
