package view;

/**
 *
 * @author olgachristensen
 */
public class Menu {
    
    private MenuActions action;
    
    public Menu() {
        action = new MenuActions();
        
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
        
        System.out.println(
            "1. List all members (compact view) \n" +
            "2. List all members (verbose view) \n" + 
            "3. Add new member \n" +
            "4. View member \n" +
            "5. Edit member \n" +
            "6. Delete member \n" +
            "7. Add new boat \n" +
            "8. Edit boat \n" + 
            "9. Delete boat \n" + 
            "0. Quit application"
                        
        );
        
        System.out.println("\n \n");
        
        int response = action.getMenuResponse();
        menuResult(response);
    }
    
    // menu responses
    public void menuResult(int i) {
        
        switch(i) {
            case 0:
                quit();
                break;
            case 1:
                action.printMembers(true);
                break;
            case 2:
                action.printMembers(false);
                break;
            case 3:
                System.out.println("Add new memeber.");
                action.addMemeber();
                break;
            case 4:
                System.out.println("View memeber. ");
                action.viewMember(true);
                break;
            case 5:
                System.out.println("Edit memeber. ");
                action.editMember(); 
                break;
            case 6:
                System.out.println("Delete member.");
                action.deleteMemeber();
                break;
            case 7:
                System.out.println("Add boat.");
                action.addBoat();
                break;
            case 8:
                System.out.println("Edit boat.");
                action.editBoat();
                break;
            case 9:
                System.out.println("Delete boat.");
                action.deleteBoat();
                break;
            default:
                System.out.println(i + " - No such option");
                break;
        }
        
        printDivider();
        showOptions();       
    }
    
    // options to quit program or view main menu
    private void showOptions() {
        System.out.println("To quit programm press Q");
        System.out.println("To view menu press M");
        
        String response = action.getOptionsResponse();
        optionsResult(response);

    }
    
    // options response 
    private void optionsResult(String str) {
        
        if (str.equalsIgnoreCase("Q")) {
            quit();
        }
        if (str.equalsIgnoreCase("M")) {
            showMenu();
        }
        else {
            System.out.println(str + " - No such option");
            showOptions();
        }
        
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

