package view;

/**
 *
 * @author olgachristensen
 */
public class Menu {
    
    private MenuActions action;
    private ErrorMessages err;
    
    public Menu() {
        action = new MenuActions();
        err = new ErrorMessages();
    }
    
    // initial start
    public void start() {
        printIntro();
        showMenu();
    }
    
    // name of the application
    public void printIntro() {
        System.out.println("---Boat Club Regystry--- \n");
    }
    
    // main menu
    public void showMenu() {
        printDivider();
        
        System.out.println("MAIN MENU \n");
        
        System.out.println("10. " + authenticated());
        
        System.out.println(
            
            "1.  List all members (compact view) \n" +
            "2.  List all members (verbose view) \n" + 
            "3.  Add new member \n" +
            "4.  View member \n" +
            "5.  Edit member \n" +
            "6.  Delete member \n" +
            "7.  Add new boat \n" +
            "8.  Edit boat \n" + 
            "9.  Delete boat \n" + 
            "11. Simple search \n" +
            "12. Complex search \n" +
            "0.  Quit application"
                        
        );
        
        System.out.println("\n \n");
        
        int response = action.getMenuResponse();
        menuResult(response);
    }
    
    private String authenticated() {
        String command;
        
        if (!action.loggedin()) {
            command = "Login";
        } else {
            command = "Logout";            
        }
        
        return command;
    }
    
    // menu responses
    public void menuResult(int i) {        
        switch(i) {
            case 0:
                quit();
                break;
            case 1:
                System.out.println("\n *** Compact member list *** \n\n");
                action.printMembers(true);
                break;
            case 2:                
                System.out.println("\n *** Verbose member list *** \n\n");
                action.printMembers(false);
                break;
            case 3:
                if (action.loggedin()) {
                    System.out.println("\n *** Add new memeber *** \n\n");
                    action.addMemeber();
                }
                else {
                    err.notLoggedinMsg();
                }
                break;
            case 4:
                System.out.println("\n *** View memeber *** \n\n");
                action.viewMember(true);
                break;
            case 5:
                if (action.loggedin()) {
                    System.out.println("\n *** Edit memeber *** \n\n");
                    action.editMember(); 
                }
                else {
                    err.notLoggedinMsg();
                }
                break;
            case 6:
                if (action.loggedin()) {
                    System.out.println("\n *** Delete memeber *** \n\n");
                    action.deleteMemeber();
                }
                else {
                    err.notLoggedinMsg();
                }
                break;
            case 7:
                if (action.loggedin()) {
                    System.out.println("\n *** Add boat *** \n\n");
                    action.addBoat();
                }
                else {
                    err.notLoggedinMsg();
                }
                break;
            case 8:
                if (action.loggedin()) {
                    System.out.println("\n *** Edit boat *** \n\n");
                    action.editBoat();
                }
                else {
                    err.notLoggedinMsg();
                }
                break;
            case 9:
                if (action.loggedin()) {
                    System.out.println("\n *** Delete boat *** \n\n");
                    action.deleteBoat();
                }
                else {
                    err.notLoggedinMsg();
                }
                break;
            case 10:
                if (!action.loggedin()) {
                    System.out.println("\n *** Login *** \n \n");
                    action.login();
                } else {
                    System.out.println("\n *** Logout *** \n \n");
                    action.logout();
                }
                break;
            case 11:
                System.out.println("\n *** Simple search *** \n \n");
                action.simpleSearch();
                break;
            case 12:
                System.out.println("\n *** Complex search *** \n \n");
                action.complexSearch();
                break;
            default:
                err.noSuchOptMsg(i);
                break;
        }
        
        showMenu();
    }
    
    public void printDivider() {
        System.out.println(
            "\n"  +
            "------------------------------------------------" +
            "\n"
        );
    }
    
    // quit application
    private void quit() {
        //ui.closeScanner();
        System.exit(0);
    }
    
}
