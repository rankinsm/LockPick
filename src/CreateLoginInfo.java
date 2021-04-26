import java.util.Scanner ;
/**
 * 
 */

/**
 * 
 *
 * @author williamss12
 * @version 1.0.0 2021-04-05 Initial implementation
 *
 *
 */
public class CreateLoginInfo
    {
    public static void main (String args[]) {
    	
        Scanner s = new Scanner(System.in);
        
        System.out.println ("Please enter the name of the application you want to store login info for)");
        String appName = s.nextLine();
        
        System.out.println ("Now enter your username and password for this application");
        System.out.print ("username: ");
        String username = s.nextLine();
        
        System.out.print ("password: ");
        String password = s. nextLine();
        
        LoginInfo appInfo = new LoginInfo(appName, username, password);
        System.out.println ("Your Login info for " + appInfo.getSiteName() + " has been stored into LockPick");
        
        s.close();
        }
    }
	// end class CreateLoginInfo