package view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import model.Authentication;
import model.Boat;
import model.Member;
import model.Registry;
import model.search.*;

/**
 *
 * @author olgachristensen
 */
public class MenuActions {
    
    private ErrorMessages err;
    
    private Authentication login;
    private boolean admin;

    private UserInput ui;
    private Registry club;
    private Search search;
    
    private int ID;
    private int amountBoats;
    private String [] memberInfo;
    private Boat.BoatType boatType;
    private ISimpleSearchStrategy simpleSearchStrategy;
    private IComplexSearchStrategy complexSearchStrategy;
    private ArrayList<Member> searchResults1;
    private ArrayList<Member> searchResults2;;
    
    public MenuActions() {
        err = new ErrorMessages();
        login = new Authentication();
        ui = new UserInput();
        club = new Registry();
        search = new Search();
        memberInfo = new String[3];
        admin = false;
        searchResults1 = new ArrayList();
        searchResults2 = new ArrayList();
    }
    
    public boolean loggedin() {
        return admin;
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
                err.intOnlyMsg();
            }  
        } while (i == -100);
                        
        return i;
    }
    
    
    /* AUTHENTICATION */
    
    public void login() {
        System.out.println("Your Username:");
        String un = ui.getString();
        
        System.out.println("Your Password:");
        String pswd = ui.getString();
        
        admin = login.authenticate(un, pswd);
        
        if (admin) {
            System.out.println("You are logged in");
        } else {
            err.loginFailedMsg();
        }
         
    }
    
    public void logout() {
        System.out.println("To logout press Y ");
        
        if(ui.getString().equalsIgnoreCase("Y")) {
            admin = false;
            System.out.println("You are now logged out");
        }
        
    }
    
    
    /* SEARCH */
    
    private void printSearchResults(ArrayList<Member> searchResults) {
        if (!searchResults.isEmpty()) {
            for (Member m : searchResults) {
                printMemberInfo(false, m);
            }
        } else {
            err.nothingFoundMsg();
        }
    }
    
    private ArrayList<Member> searchMembers(ArrayList<Member> members) {
        return simpleSearchStrategy.search(members);
    }
    
    
    /* SIMPLE SEARCH */
    
    public void simpleSearch() {
        ArrayList<Member> allMembers = club.getAllMembers();
        selectSimpleSearchOption();
        ArrayList<Member> searchResults = searchMembers(allMembers);
        
        printSearchResults(searchResults);
    }
    
    private void selectSimpleSearchOption() {
        System.out.println("Choose search option");
        showSimpleSearchOptions();
        getSimpleSearchStrategy();
        
    }
    
    private void showSimpleSearchOptions() {
        for (Search.SimpleSearch opt : Search.SimpleSearch.values()) {
            int i = opt.ordinal() + 1;
            System.out.println(i + ": " + opt.toString());
        }
        
        System.out.println("");
    }
    
    private void getSimpleSearchStrategy() {
        int i;
        
        try {
            i = ui.getInteger();
            Search.SimpleSearch s;
            
            try {
                s = Search.SimpleSearch.values()[i - 1];
                
                switch (Search.SimpleSearch.values()[i - 1]) {
                case LAST_NAME_CONTAINS:
                    searchLastNameContains();
                    break;
                case HAS_BOAT_TYPE:
                    searchHasBoatType();
                    break;
                default:
                    err.noSuchOptMsg(i);
                    break;
                }
                
            } catch (Exception e) {
                err.noSuchOptMsg(i);
                selectSimpleSearchOption();
            }
        } catch (InputMismatchException e) {
            ui.clearBuffer();
            err.intOnlyMsg();
            selectSimpleSearchOption();
        }
    }
    
    private void searchLastNameContains() {
        System.out.println("Provide (part of) last name to search for ");
        String name = ui.getString();
        simpleSearchStrategy = search.lNameCotains(name);
    }
    
    private void searchHasBoatType() {
        boatType = selectBoatType();
        simpleSearchStrategy = search.hasBoatType(boatType);
    }
    
    
    /* COMPLEX SEARCH */
    
    public void complexSearch() {
        selectComplexSearchOption();
        ArrayList<Member> searchResult = complexSearchStrategy.search(searchResults1, searchResults2);
        printSearchResults(searchResult);
    }
    
    private void selectComplexSearchOption() {
        System.out.println("Choose complex search option");
        showComplexSearchOptions();
        getComplexSearchStrategy();
    }
    
    private void showComplexSearchOptions() {
        for (Search.ComplexSearch opt : Search.ComplexSearch.values()) {
            int i = opt.ordinal() + 1;
            System.out.println(i + ": " + opt.toString());
        }
        
        System.out.println("");
    }
    
    private void getComplexSearchStrategy() {
        int i;
        
        try {
            i = ui.getInteger();
            Search.ComplexSearch s;
            
            try {
                s = Search.ComplexSearch.values()[i - 1];
                
                switch (Search.ComplexSearch.values()[i - 1]) {
                case AND:
                    complexSearchStrategy = search.andSearch();
                    
                    break;
                case OR:
                    complexSearchStrategy = search.orSearch();
                    //getSearchResults();
                    break;
                default:
                    err.noSuchOptMsg(i);
                    selectComplexSearchOption();
                    break;
                }
            } catch (Exception e) {
                err.noSuchOptMsg(i);
                selectComplexSearchOption();
            }
            
            getSearchResults();
        } catch (InputMismatchException e)    {
            ui.clearBuffer();
            err.intOnlyMsg();
            selectComplexSearchOption();
        }
    }
    
    private void getSearchResults() {
        ArrayList<Member> allMembers = club.getAllMembers();
        
        System.out.println("First ...");
        selectSimpleSearchOption();
        searchResults1 = searchMembers(allMembers);
        
        System.out.println("Second ...");
        selectSimpleSearchOption();
        searchResults2 = searchMembers(allMembers);   
    }
    
    
    /* MEMBER LISTS */
    
    // list all members compact or verbose view
    public void printMembers(boolean compact) {
        if (club.isEmpty()) {
            err.emptyRegistryMsg();
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
                err.intOnlyMsg();
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
            err.noSuchMemberMsg(ID);
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
            str += "SSN: " + m.getSSN() + "\n";
            if (!m.boats.isEmpty()) {
                for (int i = 0; i < m.boats.size(); i++) {
                    int n = i+1;
                    str += n + " ";
                    str += m.boats.get(i).toString();
                    str += "\n";
                }
                
            }
            
        }
        str += "\n";
        
        System.out.print(str);    
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
            err.nothingFoundMsg();
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
            err.nothingFoundMsg();
        }

    }
    
    // add / edit boat type
    private Boat.BoatType selectBoatType() {
        System.out.println("Choose boat type: ");
        
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
                    err.noSuchOptMsg(i);
                    selectBoatType();
                    break;
            }
        } catch (InputMismatchException e)    {
            ui.clearBuffer();
            err.intOnlyMsg();
            selectBoatType();
        }
        
    }
    
    // add/edit boat length
    private int getBoatLength() {
        
        int l = 0;
        
        do {
            System.out.println("Enter boat's length in meters");
        try {
            l = ui.getInteger();
            //ui.clearBuffer();
        } catch (InputMismatchException e) {
            ui.clearBuffer();
            err.intOnlyMsg();

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
                err.intOnlyMsg();
            }
        } while (idBoat ==0 );
        
        return idBoat;
    }
    
}
