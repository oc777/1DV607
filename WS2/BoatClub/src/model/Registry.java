package model;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author olgachristensen
 */
public class Registry {
    
    private FileHandler fh;        
    public ArrayList<Integer> ids;
 
    
    public Registry() {
        fh = new FileHandler();
        ids = fh.listAllFiles();
    }
    
    // checks if club registry is empty
    public boolean isEmpty() {
        return ids.isEmpty();
    }
    
    // finds ID of last registered member
    private int getLastID() {
        int id = 0;
        
        if(!ids.isEmpty()) {
            Collections.sort(ids);
            id = ids.get(ids.size()-1);
        }
        return id;
    }
    
    // register new member
    public void addMember(String firstName, String lastName, String ssn) {
        int id = getLastID() + 1;
        Member m = new Member(id, firstName, lastName, ssn);
        
        ids.add(id);
        fh.serialize(m);
        
    }
    
    // checks if member with specific ID is already registered
    public boolean memberExists(int id) {
        return ids.contains(id);
    }
    
    
    // returns Member object with specific ID
    public Member getMember(int id) {
        Member m = null;
        
        if(memberExists(id)) {
            m = fh.deserialize(id);
        }
        
        return m;
    }
    
    // delete member with specific ID
    public void deleteMember(int id) {
        if(memberExists(id)) {
            fh.deleteFile(id);
            ids.remove(ids.indexOf(id));
        }
        
    }
    
    // update specific member info
    public void editMember(int id, String firstName, String lastName, String ssn) {
        if(memberExists(id)) {
            Member m = fh.deserialize(id);
            Member mNew = new Member(id, firstName, lastName, ssn);
            mNew.setBoats(m.getBoats());
            
            fh.serialize(mNew);
        }
    }
    
    // add boat to specific member
    public void addBoat(int id, Boat.BoatType bt, int l) {
        if(memberExists(id)) {
            Member m = getMember(id);
            m.addBoat(new Boat(bt, l));
            fh.serialize(m);
        }
    }
    
    // edit specific boat of specific member
    public void editBoat(int idMember, int idBoat, Boat.BoatType bt, int l) {
        if (boatExists(idMember, idBoat)) {
            Member m = getMember(idMember);
            ArrayList<Boat> boats = m.getBoats();
            boats.remove(idBoat-1);
            boats.add(idBoat-1, new Boat(bt, l));
            fh.serialize(m);
        }
    }
    
    // delete specific boat of specific member
    public void deleteBoat(int idMember, int idBoat) {
        
        if (boatExists(idMember, idBoat)) {
            Member m = getMember(idMember);
            ArrayList<Boat> boats = m.getBoats();
            boats.remove(idBoat-1);
            fh.serialize(m);
        }
        
    }
    
    // checks if specific member has boat with specific ID
    public boolean boatExists(int idMember, int idBoat) {
        boolean boat = false;
        
        if(memberExists(idMember)) {
            Member m = getMember(idMember);
            if(m.getAmountBoats() > 0 && idBoat <= m.getAmountBoats()) {
                boat = true;
            }
        }
        
        return boat;
    }
    
    
    
}
