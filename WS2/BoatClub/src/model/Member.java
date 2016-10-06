package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author olgachristensen
 */
public class Member implements Serializable {
    
    private int ID;
    private String fName;
    private String lName;
    private String ssn;
    public ArrayList<Boat> boats;
    
    public Member(int n, String firstName, String lastName, String pn) {
        ID = n;
        fName = firstName;
        lName = lastName;
        ssn = pn;
        boats = new ArrayList<>();
    }
    
    
    public int getAmountBoats() {
        return boats.size();
    }
    
    public void addBoat(Boat b) {
        boats.add(b);
    }
    
    public ArrayList<Boat> getBoats() {
        return boats;
    }
    
    public void setBoats(ArrayList<Boat> b) {
        boats = b;
    }
    
    public int getID() {
        return ID;
    }
    
    public String getFName() {
        return fName;
    }
    
    public void setFName(String name) {
        fName = name;
    }
    
    public String getLName() {
        return lName;
    }
    
    public void setLName(String name) {
        lName = name;
    }
    
    public String getSSN() {
        return ssn;
    }
    
    public void setSSN(String n) {
        ssn = n;
    }
    
    @Override
    public String toString() {
        return "ID: " + ID + " " + getFName() + " " + getLName() + " - " + getAmountBoats() + " boats";
    }
    
    /*
    @Override
    public boolean equals(Object obj) {
        boolean equals = false;
        
        if (obj != null && obj instanceof Member) {
            Member m = (Member) obj;
            equals = getID() == m.getID();
        }
        
        return equals;
    }
    */
    
}
