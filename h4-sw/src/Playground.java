

import java.util.ArrayList;
import java.util.Scanner;

public class Playground {
    Scanner input = new Scanner(System.in);
    private String playgroundname;
    private String description;
    private int Price_Per_Hour;
    public static int itsLastIndex = 0;
    public int PlaygroundNumber = 0;
    private Timeslote PlaygroundSlot;
    public static ArrayList<Playground> ListOFplayground = new ArrayList<Playground>();
    private boolean Status;

    Playground() {
       // ListOFplayground = new ArrayList<Playground>();
        PlaygroundSlot = new Timeslote();
    }

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


    public void bookplayground(int playgroundnum, int slotid) {

        Playground obj = ListOFplayground.get(playgroundnum - 1);

        if (obj.PlaygroundSlot.check(slotid)) {
            obj.PlaygroundSlot.bookit(slotid);

        } else System.out.println("invalid id");
            
        
    }

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

    //Prints the information of the playground which have the id in the function argument.
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

    public void displayPlayground(int prise) {
        Playground obj;
        for (int i = 0; i < ListOFplayground.size(); i++) {
            obj = ListOFplayground.get(i);
            if (prise == obj.getPlaygroundPrice_Per_Hour()) {

                obj.getplayground(obj.PlaygroundNumber);

            }

        }
    }

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
