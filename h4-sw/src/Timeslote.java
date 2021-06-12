
import java.util.ArrayList;
/**
 * This class  allows the owner of the playground to add a slot time that has this
 * attributes: day, month ,year,starting ,ending,
 * Status,ListOFAppointments,itsLastIndex,SlotID
 * 
 * @author Esraa Mosaad zaky
 */
public class Timeslote {
    private int day;
    private int month;
    private int year;
    private int starting;
    private int ending;
    private boolean Status;
    private ArrayList<Timeslote> ListOFAppointments;

    public static int itsLastIndex = 0;
    public int SlotID = 0;

    /**
     * Class  default constructor
     */
    public Timeslote() {
        ListOFAppointments = new ArrayList<Timeslote>();
    }

    /**
     * The AddSlote method  allows the playground owner to add a slot to the appointments list
     *
     * @param Day
     * @param Year
     * @param Month
     * @param Starting is the start time for this slot
     * @param Ending   is the end time for this slot
     */

    public void AddSlote(int Day, int Month, int Year, int Starting, int Ending) {

        Timeslote obj = new Timeslote();
        obj.day = Day;
        obj.month = Month;
        obj.year = Year;
        obj.starting = Starting;
        obj.ending = Ending;
        obj.Status = false;
        SlotID++;
        obj.SlotID = SlotID;

        AddToAppointments(obj);


    }

    /**
     * The AddToAppointments  method add a given object "slot" to the  list
     *
     * @param obj is object of class TimeSlot.
     */

    public void AddToAppointments(Timeslote obj) {

        //System.out.println("" + SlotID + ""+itsLastIndex);
        ListOFAppointments.add(itsLastIndex, obj);

    }

    /**
     * The deleteSlot method  delete a slot from the  list by given SlotId
     *
     * @param id is the id of slot
     */

    public void deleteSlot(int id) {
        Timeslote obj;
        for (int i = 0; i < ListOFAppointments.size(); i++) {
            obj = ListOFAppointments.get(i);
            if (id == obj.SlotID) {
                ListOFAppointments.remove(i);

            }
        }
    }

    /**
     * The bookit method  allows the player to book a slot from the appointments list by SlotId
     *
     * @param id is the id of slot
     */
    public void bookit(int id) {
        Timeslote obj;
        for (int i = 0; i < ListOFAppointments.size(); i++) {
            obj = ListOFAppointments.get(i);
            if (id == obj.SlotID) {
                if (obj.Status == false) {
                    obj.Status = true;
                    System.out.println("Done");
                    break;
                } else
                    System.out.println("Sorry,it is Unavailable");

            }
        }


    }

    /**
     * The check method  check if this slot available or not by given SlotId
     *
     * @param id is the id of slot
     * @return returns true or false
     */
    public boolean check(int id) {

        Timeslote obj;
        for (int i = 0; i < ListOFAppointments.size(); i++) {
            obj = ListOFAppointments.get(i);
            if (id == obj.SlotID) {
                if (obj.Status == false) {
                    return true;
                }

            }
        }
        return false;


    }

    public Timeslote getslote(int sloteid) {
        Timeslote obj;
        obj = ListOFAppointments.get(sloteid);
        return obj;
    }

    public void setStatus(boolean bool) {
        Status = bool;
    }

    public boolean getStatus() {
        return Status;
    }

    /**
     * The  getListOFAppointments method  play all the slot
     */

    public void getListOFAppointments() {
        Timeslote obj;
        for (int i = 0; i < ListOFAppointments.size(); i++) {
            obj = ListOFAppointments.get(i);

            //System.out.println(ListOFAppointments[i]);

            System.out.println(
                    "****** Slote " + obj.SlotID + " ******");
            System.out.println(
                    obj.day + ":" + obj.month + ":" + obj.year);
            System.out.println(
                    "start at: " + obj.starting + "  --->  end at: " + obj.ending);
            if (obj.Status == false) {
                System.out.println("status: Available \n");
            } else
                System.out.println("status:Unavailable \n");

        }
    }

    public void getbookedslot() {
        Timeslote obj;
        for (int i = 0; i < ListOFAppointments.size(); i++) {
            obj = ListOFAppointments.get(i);

            //System.out.println(ListOFAppointments[i]);


            if (obj.Status == false) {
                System.out.println(
                        "****** Slote " + obj.SlotID + " ******");
                System.out.println(
                        obj.day + ":" + obj.month + ":" + obj.year);
                System.out.println(
                        "start at: " + obj.starting + "  --->  end at: " + obj.ending);
            }

        }
    }
}
