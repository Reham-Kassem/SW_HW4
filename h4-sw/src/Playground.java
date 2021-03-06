

import java.util.ArrayList;
import java.util.Scanner;

/*
 * This class allows the  playground owner  to add a playground and slot of this playground  
 * attributes of this class: playgroundname, description,Price_Per_Hour,PlaygroundNumber,
 * PlaygroundSlot,ListOFplayground,Status
 * 
 * @author Esraa Mosaad zaky
 */
 
public class Playground {
    Scanner input = new Scanner(System.in);
    private String playgroundname;
    private String description;
    private int Price_Per_Hour;
    public static int itsLastIndex = 0;
    public int PlaygroundNumber = 0;
    private Timeslote PlaygroundSlot= new Timeslote();
    public static ArrayList<Playground> ListOFplayground = new ArrayList<Playground>();
    private boolean Status;

    /**
     * The AddPlayground method  allows the playground owner to add 
     * @param name is the playground name
     * @param playgroundData is the description for the playground
     * @param price is the price per hour for the playground
     */

    public void AddPlayground(String name, String playgroundData, int price) {
        Playground obj = new Playground();
        obj.playgroundname = name;
        obj.description = playgroundData;
        obj.Price_Per_Hour = price;
        PlaygroundNumber++;
        obj.PlaygroundNumber = PlaygroundNumber;
        obj.Status = true;
    
        ListOFplayground.add(itsLastIndex, obj);
        itsLastIndex++;

    }
    /**
     * The deletePlayground method  allows the playground owner to delete  playground 
     * @param id is the id of playground
     */
    public void deletePlayground(int id) {
        Playground obj;

        for (int i = 0; i < ListOFplayground.size(); i++) {
            obj = ListOFplayground.get(i);
            if (id == obj.PlaygroundNumber) {
                ListOFplayground.remove(i);

                itsLastIndex--;

            }
        }

    }
    /**
     * The check method  check if this playground active or not by given play ground Id 
     * @param id is the id of playground
     * @return returns true or false
     */

    public boolean check(int id) {

        Playground obj;
        for (int i = 0; i < ListOFplayground.size(); i++) {
            obj = ListOFplayground.get(i);
            if (id == obj.PlaygroundNumber) {
                if (obj.Status == false) {
                    return true;
                }

            }
        }
        return false;

    }
    /**
     * The AddSlotToPlayground method  add slot to the playground
     * @param id is the id of playground
     * 
     */

    public void AddSlotToPlayground(int id) {
        Playground obj;

        obj = ListOFplayground.get(id - 1);
        if (id == obj.PlaygroundNumber && obj.Status == true) {


            System.out.println("Add slot for " + obj.playgroundname);
            System.out.println("Enter day");
            int day = input.nextInt();
            System.out.println("Enter month ");
            int month = input.nextInt();
            System.out.println("Enter year");
            int year = input.nextInt();
            System.out.println("Enter start time");
            int Startat = input.nextInt();
            System.out.println("Enter end time ");
            int Endat = input.nextInt();

            obj.PlaygroundSlot.AddSlote(day, month, year, Startat, Endat);

        } else {
            System.out.println("Playground not active");
        }

    }
    /**
     * The bookplayground method  allows the player to book a slot from playground
     * @param playgroundnum is the id of playground
     * @param slotid is the id of playground
     */

    public void bookplayground(int playgroundnum, int slotid) {

        Playground obj = ListOFplayground.get(playgroundnum - 1);

        if (obj.PlaygroundSlot.check(slotid)) {
            obj.PlaygroundSlot.bookit(slotid);

        } else System.out.println("invalid id");
            
        
    }
   /**
     * The  getListOFPlaygrounds method  play all the playground
     */
    public void getListOFPlaygrounds() {
        Playground obj;
        for (int i = 0; i < ListOFplayground.size(); i++) {
           
        	obj = ListOFplayground.get(i);

            System.out.println(
                    "******  " + obj.playgroundname + " [ " + obj.PlaygroundNumber + " ] ******");
            System.out.println("obj Description:"+obj.description);
            System.out.println("Price_Per_Hour " + obj.Price_Per_Hour);
            if( obj.Status) {
            	System.out.println("Playground Status: Active ");
            	if(obj.PlaygroundSlot.SlotID>=0) {
            		System.out.println("Playground slot");
            	obj.PlaygroundSlot.getListOFAppointments();
            	}
            	else System.out.println("No slot for this playground");
            	
            }
            else System.out.println("Playground Status: not Active ");
           
            
            
            
            System.out.println("-----------------------------------------------------------------------------------------");


        }
    }
   
   /**
     * The  getplayground method  Prints the information of the playground which have the id in the function argument.
     *  @param id is the id of playground
     */
    
    public void getplayground(int id) {
        Playground obj = ListOFplayground.get(id - 1);

        System.out.println(
                "******  " + obj.playgroundname + " [ " + obj.PlaygroundNumber + " ] ******");
        System.out.println(obj.description);
        System.out.println("Price_Per_Hour " + obj.Price_Per_Hour);
        System.out.println("Playground slot");
        obj.PlaygroundSlot.getListOFAppointments();
        System.out.println("-----------------------------------------------------------------------------------------");

    }
     /**
     * The  displayPlayground method  Prints the information of the playground which have the id in the function argument.
     * @param prise is the prise per hour of playground
     */
    public void displayPlayground(int prise) {
        Playground obj;
        for (int i = 0; i < ListOFplayground.size(); i++) {
            obj = ListOFplayground.get(i);
            if (prise == obj.getPlaygroundPrice_Per_Hour()) {

                obj.getplayground(obj.PlaygroundNumber);

            }

        }
    }
   /**
     * The  returnplayground method  return obj from type playground
     * @param id is the id of playground
     * @return obj frome type Playground 
     */
    public Playground returnplayground(int id) {
        Playground obj = ListOFplayground.get(id - 1);

        return obj;
    }
 

    public void setStatus(boolean status) {
        Status = status;
    }

    public void setPlaygroundName(String name) {
        playgroundname = name;
    }

    public void setPlaygroundDescription(String data) {
        description = data;
    }

    public void setPlaygroundPrice_Per_Hour(int prise) {
        Price_Per_Hour = prise;
    }


    public String getPlaygroundName() {
        return playgroundname;
    }

    public String getPlaygroundDescription() {
        return description;
    }

    public int getPlaygroundPrice_Per_Hour() {

        return Price_Per_Hour;
    }


    public void printsbookedslot(int id) {
        Playground obj = ListOFplayground.get(id - 1);
        obj.PlaygroundSlot.getbookedslot();
    }


}
