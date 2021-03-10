import java.util.Scanner ;

/**
 * 
 */

/**
 * 
 *
 * @author williamss12
 * @version 1.0.0 2021-03-07 Initial implementation
 *
 */
public class UserIntroduction
    {
    public static void main (String[] args) {
        System.out.println("Welcome to LockPick. Please enter your email");
        Scanner s = new Scanner(System.in);
        String email = s.nextLine();
        System.out.println("Please enter personal username and password./n" +
" Make sure your password is more than 8 characters long and contains at least one number or symbol");
        String username = s.nextLine();
        String password = s.nextLine();
        
        s.close();
        }

    }
	// end class UserIntroduction