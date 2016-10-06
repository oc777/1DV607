package view;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author olgachristensen
 */
public class UserInput {
    
    final Scanner scan;
    
    public UserInput() {
        scan = new Scanner(System.in);
    }
    
    public int getInteger() throws InputMismatchException {
        int i = scan.nextInt();
        clearBuffer();
        
        return i;
    }
    
    public String getString() {
        return scan.nextLine();
    }
    
    public void clearBuffer() {
        scan.nextLine();
    }
    
    public void closeScanner() {
        scan.close();
    }
    
}
