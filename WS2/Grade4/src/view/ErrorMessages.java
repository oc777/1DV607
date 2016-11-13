package view;

/**
 *  ERRORS 
 *   
 * @author olgachristensen
 */

public class ErrorMessages {
    
    public void loginFailedMsg() {
        System.out.println("Error! Username or/and password do not match");
    }
    
    public void intOnlyMsg() {
        System.out.println("Error! Integers only");
    }
    
    public void notLoggedinMsg() {
        System.out.println("Error! You need to be logged in to perform this action.");
    }
    
    public void noSuchOptMsg(int i) {
        System.out.println("Error! " + i + " - No such option");
    }
    
    public void noSuchMemberMsg(int id) {
        System.out.println("Error! Member ID:"+ id + " doesn't exist");  
    }
    
    public void nothingFoundMsg() {
        System.out.println("No search results matched given criteria");
    }
    
    public void emptyRegistryMsg() {
        System.out.println("Registry is empty.");
    }
    
}
