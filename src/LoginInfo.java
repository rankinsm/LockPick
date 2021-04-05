
/**
 * 
 */

/**
 * 
 *
 * @author williamss12
 * @version 1.0.0 2021-04-05 Initial implementation
 *
 */
public class LoginInfo
    {
        private String siteName;
        private String username;
        private String password;
        
        public LoginInfo () {
            siteName = "";
            username = "";
            password = "";
        }
        public LoginInfo (String s, String u, String p) {
        siteName = s;
        username = u;
        password = p;
        }
        public String getSiteName () {
        return siteName;
        }
        public String getUsername () {
        return username;
        }
        public String getPassword () {
        return password;
        }
        public void setSiteName (String s) {
            siteName = s;
        }
        public void setUsername (String u) {
        username = u;
        }
        public void setPassword (String p) {
        password = p;
        }   
    }
	// end class LoginInfo