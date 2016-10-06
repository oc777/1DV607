package model;

import java.io.Serializable;

/**
 *
 * @author olgachristensen
 */
public class Boat implements Serializable {
  
    public enum BoatType {
        Sailboat, Motorsailer, Canoe, Other
    }
    
    private BoatType type;
    private int length;
    
    public Boat(BoatType t, int l) {
        type = t;
        length = l;
    }
    
    
    public BoatType getType() {
        return type;
    }

    public void setType(BoatType t) {
        type = t;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int l) {
        length = l;
    }
    
    @Override
    public String toString() {
        return type + " " + length + " m";
    }
    
    
}
