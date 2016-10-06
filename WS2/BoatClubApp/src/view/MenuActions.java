package view;

import java.util.InputMismatchException;
import model.Boat;
import model.Member;
import model.Registry;

/**
 *
 * @author olgachristensen
 */
public class MenuActions {
    
    private UserInput ui;
    private Registry club;
    
    private int ID;
    private int amountBoats;
    private String [] memberInfo;
    private Boat.BoatType boatType;
    
    public MenuActions() {
        ui = new UserInput();
        club = new Registry();
        memberInfo = new String[3];
    }
    
    
    /* MENU CONTROLLER */
    
    // get input from user
    public int getMenuResponse() {
        int i = -100;
         
        do {
            try {
                i = ui.getInteger();
            } catch (InputMismatchException e)    {
                ui.clearBuffer();
                System.out.println("Integers only");
            }  
        } while (i == -100);
                        
        return i;
    }
    
    // get input from user
    public String getOptionsResponse() {
        return ui.getString();
    }
    
    
    /* MEBER LISTS */
    
    // list all members compact or verbose view
    public void printMembers(boolean compact) {
        if (club.isEmpty()) {
            System.out.println("Registry is empty.");
        }
        else {
            for (int id : club.ids) {
                Member m = club.getMember(id);
                printMemberInfo(compact, m);
            }
        }
    }
    
    
    /* MEMBER CONTROLLER */
    
    // register new member
    public void addMemeber() {
        getMemberInfo();
        
        club.addMember(memberInfo[0], memberInfo[1], memberInfo[2]);
        
        System.out.println("Member was registered.");
    }
    
    // get member ID and show member info
    public void viewMember(boolean compact) {
        getMemberID();
        printMember(compact);
    }
    
    // get member ID from user
    private void getMemberID() {
        ID = 0;
        
        do {
            System.out.println("Enter Member ID:  ");

            try {
                ID = ui.getInteger();
            }
            catch (InputMismatchException e) {
                ui.clearBuffer();
                System.out.println("Integers only");
            }
        } while (ID == 0);
        
    }
    
    // show member info in compact or verbose view
    private void printMember(boolean compact) {
        if(club.memberExists(ID)) {
            Member m = club.getMember(ID);
            amountBoats = m.getAmountBoats();
            printMemberInfo(compact, m);
        } 
        else {
            System.out.println("Member ID:"+ ID + " doesn't exist");  
            viewMember(compact);
        }
    }
    
    // edit existing member
    public void editMember() {
        viewMember(true);
        
        System.out.println("To edit this member...");
        getMemberInfo();
        
        club.editMember(ID, memberInfo[0], memberInfo[1], memberInfo[2]);
        System.out.println("Member was updated");
        
    }
    
    // delete existing member
    public void deleteMemeber() {
        viewMember(true);
        
        System.out.println("To delete this member press Y ");
        
        if(ui.getString().equalsIgnoreCase("Y")) {
            club.deleteMember(ID);
            System.out.println("Member was deleted");
        }
        
        
    }
    
    // print out of member info compact or verbose view
    private void printMemberInfo(boolean compact, Member m) {
        //compact view
        String str = "ID: " + m.getID() + " " + m.getFName() + " " 
                + m.getLName() + " - " + m.getAmountBoats() + " boats \n";
        
        //verbose view
        if(!compact) {
            if (!m.boats.isEmpty()) {
                for (int i = 0; i < m.boats.size(); i++) {
                    int n = i+1;
                    str += n + " ";
                    str += m.boats.get(i).toString();
                    str += "\n";
                }
            }
        }
        
        System.out.println(str);    
    }
    
    // get user input for member info
    private void getMemberInfo() {
        
        System.out.println("Enter First name:  ");
        String fName = ui.getString();
        memberInfo[0] = fName;
        
        System.out.println("Enter Last name:  ");
        String lName = ui.getString();
        memberInfo[1] = lName;
        
        System.out.println("Enter Social Security Number:  ");
        String ssn = ui.getString();
        memberInfo[2] = ssn;
        
    }
    
    
    /* BOAT CONTROLLER */
    
    
    // add boat to specific user
    public void addBoat() {
        viewMember(false);
        
        System.out.println("To add boat for this member... ");
        
        boatType = selectBoatType();
        
        int length = getBoatLength();
        
        club.addBoat(ID, boatType, length);
        
        System.out.println("Boat was added.");
        
    }
    
    // edit specific boat of specific user
    public void editBoat() {
        viewMember(false);
        
        if(amountBoats != 0) {
            int id = getBoatID();
            boatType = selectBoatType();
            int length = getBoatLength();

            club.editBoat(ID, id, boatType, length);

            System.out.println("Boat was updated.");
        } else {
            System.out.println("This member has no boats registered.");
        }
    }
    
    // delete specific boat of specific user
    public void deleteBoat() {
        viewMember(false);
        
        if(amountBoats != 0) {
            int id = getBoatID();

            System.out.println("To delete this boat press Y ");

            if(ui.getString().equalsIgnoreCase("Y")) {
                club.deleteBoat(ID, id);
                System.out.println("Boat was deleted.");
            }
        } else {
            System.out.println("This member has no boats registered.");
        }

    }
    
    
    // add / edit boat type
    private Boat.BoatType selectBoatType() {
        System.out.println("Step 1. Choose boat type: ");
        
        showBoatTypes();
        getBoatType();
        
        return boatType;
    }
    
    // show user boat type options
    private void showBoatTypes() {
        
        System.out.println(
            "1. Sailboat \n" +
            "2. Motorsailer \n" + 
            "3. Canoe \n" +
            "4. Other \n" 
        );
    }
    
    // get user input for boat type
    private void getBoatType() {
        int i;
        //i = 0;
        
        try{
            i = ui.getInteger();
            
            switch(i) {
                case 1:
                    boatType = Boat.BoatType.Sailboat;
                    break;
                case 2:
                    boatType = Boat.BoatType.Motorsailer;
                    break;
                case 3:
                    boatType = Boat.BoatType.Canoe;
                    break;
                case 4:
                    boatType = Boat.BoatType.Other;
                    break;
                default:
                    System.out.println(i + " - No such option");
                    selectBoatType();
                    break;
            }
        } catch (InputMismatchException e)    {
            ui.clearBuffer();
            System.out.println("Integers only");
            selectBoatType();
        }
        
    }
    
    // add/edit boat length
    private int getBoatLength() {
        
        int l = 0;
        
        do {
            System.out.println("Step 2. Enter boat's length in meters");
        try {
            l = ui.getInteger();
            //ui.clearBuffer();
        } catch (InputMismatchException e) {
            ui.clearBuffer();
            System.out.println("Integers only");

        }
        } while (l <=0 );
        
        return l;
    }
    
    
    // edit / delete specific boat by ID
    private int getBoatID() {
        int idBoat = 0;
        
        do {
            System.out.println("Enter ID of boat ");
            try {
                int i = ui.getInteger();
                
                if (club.boatExists(ID, i)) {
                    idBoat = i;
                } 
                
            } catch (InputMismatchException e) {
                ui.clearBuffer();
                System.out.println("Integers only");
            }
        } while (idBoat ==0 );
        
        return idBoat;
    }
   
    
}
