/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


/**
 *
 * @author olgachristensen
 */
public class Options {
    
    public void printIntro() {
        System.out.println(
            "Boat Club Regystry \n" +
            "Chose the action you want to perform, \n enter it's ID and press Enter"
        );
    }
    
    
    public void printMainMenu() {
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
        
    }
    
    
    
    
    
}
