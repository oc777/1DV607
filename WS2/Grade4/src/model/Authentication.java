package model;

/**
 *
 * @author olgachristensen
 */
public class Authentication {
    
    private String username;
    private String password;
    
    public Authentication() {
        username = "test";
        password = "test";
    }
    
    public boolean authenticate(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
    
    
}
