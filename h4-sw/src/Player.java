

import java.util.ArrayList;
/**
 * A {@code Player} class that inhert from class User and have the attributes of the Player.
 */
public class Player extends User {
    public static Playground playground=new Playground();
    private ArrayList<Timeslote> Requests;
    private Timeslote timeslote;
    private Address address;
    private int timeslotendex = 0;
    protected eWallet ewallet;
/**
 * A {@code Player} defulte constructor.
 */
    public Player() {
        UserName = "";
        Email = "";
        Password = "";
        PhoneNumber = "";
        address = null;
        
    }
 /**
     * A paramaterized constructor for the {@code Player} 
     * @param email email of the player
     * @param password password of the player
     * @param un username of the player
     * @param phonenumber mobile number of the plyer
     * @param add address of the player
     */
    
    public Player(String username, String email, String password, String un, String phonenumber, Address add) {
        UserName = username;
        Email = email;
        Password = password;
        PhoneNumber = phonenumber;
        address = add;

    }
//This function is responsible for viewing all the playgrounds.
 /**
 * A
 */
    public void getplayground() {
        //getListOFPlaygrounds is a function implemented in the playground class.
        playground.getListOFPlaygrounds();
    }


    //  public void filterplaygrounds(int price) {
    //        playground.displayPlayground(price);
    //  }
    //
    //This function is responsible for bookings - player books a playground-.
    
    public void addrequest(int playgroundid, int timesloteid) {
    	
    	playground.bookplayground(playgroundid, timesloteid);
    }

    public void cancelrequest(int timesloteid) {
        Timeslote obj;
        for (int i = 0; i < Requests.size(); i++) {
            obj = Requests.get(i);
            if (timesloteid == obj.SlotID) {

                obj.setStatus(false);
                Requests.remove(i);
            }
        }

    }

    public void seebookings() {
        Timeslote obj;
        for (int i = 0; i < Requests.size(); i++) {
            obj = Requests.get(i);
            if (obj.getStatus() == true) {

                obj.getslote(obj.SlotID);
            }
        }
    }


    /*
        public void reportPlaygroundd(int id) {
            Playground obj = new Playground();
            Playground obj2 = obj.returnplayground(id);
            if (obj2.check(id)) {
                obj2.reportplayground();
            }
        }

     */
    public eWallet getewallet() {
        return ewallet;
    }
}
