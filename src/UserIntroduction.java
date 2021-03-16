import java.util.Scanner ;
/**
 * @author williamss12
 * @version 1.0.0 2021-03-07 Initial implementation
 *          1.1.0 added emailIsValid, passwordIsValid, and pinIsValid
 */
public class UserIntroduction
    {
    public static void main (String args[]) {
    Scanner s = new Scanner(System.in);
    System.out.println("Welcome to LockPick. Please enter your email.");
    String email = s.nextLine();
    while (!emailIsValid(email)) {
        System.out.println("Invalid email. Please re-enter your email, (should contain a domain suffix):");
        email = s.nextLine();
    }
    System.out.println("Please enter personal username and password." +
" Make sure your password is more than 8 characters long and contains at least one number, one letter, and one symbol");
    String username = s.nextLine();
    String password = s.nextLine();
    while (!passwordIsValid(password)) {
        System.out.println("Invalid password. Please enter a valid password");
        password = s.nextLine();
    }
    System.out.println("Please enter a 6 digit PIN. This PIN will allow you to access your personal account information.");
    String PIN = s.nextLine();
    while (!pinIsValid(PIN)) {
        System.out.println("Invalid PIN. Please enter a valid PIN number");
        PIN = s.nextLine();
    }
    System.out.println ("Your account has been set up, Thank you for using LockPick.");
    s.close();
    
    }
/*returns false if email does not contain a domain suffix.
*/
private static boolean emailIsValid (String e) {
        return e.contains("@") &&( e.contains(".com") || e.contains(".org") || e.contains(".net") || e.contains(".edu"));
        }
/*checks the length of the password is greater than 8
 *  and if the password has at least 1 symbol, letter and number. 
 *  Returns true if all previous stated conditions are met. False if otherwise.
 */
private static boolean passwordIsValid (String e) {
        boolean result = false;
        boolean hasLetter = false;
        boolean hasNumber = false;
        boolean hasSymbol = false;
        char[] charChecker = e.toCharArray();
        if (e.length() >= 8) {
            for (int i = 0; i < charChecker.length; i++) {
                if (Character.isDigit(charChecker[i])) {
                hasNumber = true;
                }
                else if (Character.isLetter(charChecker[i])) {
                hasLetter = true;
                }
                else {
                hasSymbol = true;
                }
            }
            result = hasLetter && hasNumber && hasSymbol;
        }
        return result;
    }
/* Checks the length of the pin is six and contains only digits.
 */
private static boolean pinIsValid (String e) {
    boolean result = e.length() == 6;
    if (result) {
        char[] charChecker = e.toCharArray();
        for (int i = 0; i < charChecker.length; i++) {
            if (!Character.isDigit(charChecker[i])) {
                result = !result;
            }
        }
    }
        return result;
}

    }
	// end class UserIntroduction
