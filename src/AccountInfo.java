
/**
 * 
 */

/**
 * 
 *
 * @author williamss12
 * @version 1.0.0 2021-04-10 Initial implementation
 *
 */
public class AccountInfo
{
    private String email;
    private String[] usernames;
    private String password;
    private String[] PINS;
    
    public AccountInfo () {
        email = "";
        usernames = new String[8];
        password = "";
    }
    public AccountInfo (String e, String p, String u, String i) {
    email = e;
    password = p;
    usernames[0] = u;
    PINS[0] = i;
    }
    public String getEmail () {
    return email;
    }
    public String getUsernames (int i) {
    return usernames[i];
    }
    public String getPassword () {
    return password;
    }
    public String getPINS (int i) {
    return PINS[i];
    }
    public void setEmail (String s) {
    email = s;
    }
    public void setUsernames (String u, int i) {
    usernames[i] = u;
    }
    public void setPassword (String p) {
    password = p;
    }
    public void setPINS (String p, int i) {
    PINS[i] = p;
    }
}
	// end class LockPickLoginInfo