package model;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author olgachristensen
 */
public class FileHandler {
    final String dir = "data" + File.separator;
    //final String dir = "src/data/";          // use when running in IDE
    final String ext = ".ser";
    
    //save object in .ser file
    public void serialize(Member m) {
        String path = dir + m.getID() + ext;
        
        try {
            FileOutputStream fileOut = new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(m);
            out.close();
            fileOut.close();
            //System.out.println("Serialized data is saved");
        }catch(IOException e) {
            //System.out.println("Serialized data is NOT saved");
            e.printStackTrace();
      }
        
    }
    
    //get object outof .ser file
    public Member deserialize(int id) {
        Member m = null;
        String path = dir + id + ext;
        
        try {
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            m = (Member) in.readObject();
            in.close();
            fileIn.close();
        }catch(IOException | ClassNotFoundException e) {
            //System.out.println("Deserialize err");
            e.printStackTrace();
        }
        
        return m;
    }
    
    //list all registered member IDs in ascending order
    public ArrayList<Integer> listAllFiles() {
        ArrayList<Integer> files = new ArrayList<>();
        
        File[] list = new File(dir).listFiles();

        if (list != null) {
            for (File f : list) {
                if (f.isFile()) {
                    String fName = f.getName();
                    fName = fName.substring(0, fName.length()-4);
                    files.add(Integer.parseInt(fName));
                }
            }

            Collections.sort(files); 
        }
        
        return files;
    }
    
    //delete file from directory
    public void deleteFile(int id) {
        String path = dir + id + ext;
        
        try {
            File f = new File(path);
            f.delete();
        } catch (Exception x) {
            x.printStackTrace();
        } 
    }
    
}
