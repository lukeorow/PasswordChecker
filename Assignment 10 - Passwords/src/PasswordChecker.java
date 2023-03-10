import java.util.Scanner;

public class PasswordChecker {

    public static boolean validatePass(String password) {
        // Checks the length of pass
        if (password.length() <= 7 || password.length() >= 17) {
            return false;
        }
        
        // Checks for uppercase, lowercase, a digit, and some kind of symbol
        int categories = 0;
        boolean lowercase = false, uppercase = false, digit = false, symbol = false;
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);

            if (Character.isLowerCase(c)) {
                lowercase = true;
            } 
            else if (Character.isUpperCase(c)) {
                uppercase = true;
            } 
            else if (Character.isDigit(c)) {
                digit = true;
            } 
            else if ("~!@#$%^&*()-=+_".indexOf(c) != -1) {
                symbol = true;
            }
        }
        if (lowercase) {
            categories++;
        }
        if (uppercase) {
            categories++;
        }
        if (digit) {
            categories++;
        }
        if (symbol) {
            categories++;
        }
        
        return categories >= 3;
    }
    
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        // gets the password input from the user
        System.out.print("Enter a password to check: ");
        String password = scnr.nextLine();

        // calls validatePass with the variable password that is 
        // inputted by user to check if password valid or not
        boolean isValid = validatePass(password);
        if (isValid) {
           System.out.println("Password is valid.");
        } 
        else {
           System.out.println("Password not valid. Please read over the rules and try again!");
        }
   }
   
}

