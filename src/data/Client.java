package data;

/**
 * A class that defines a client's account.
 *
 * @author Alzer Casiño
 */
public class Client implements java.io.Serializable {
    
    private String firstName;
    private String lastName;
    private final int ticketNum;
    private PlaneSchedule sched;
    
    public Client(int tn, String fn, String ln, PlaneSchedule s) {
        ticketNum = tn;
        firstName = fn;
        lastName = ln;
        sched = s;
    }
    
    public int getTicketNum() {
        return ticketNum;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public PlaneSchedule getSched() {
        return sched;
    }
    
    public void setFirstName(String fn) {
        firstName = fn;
    }
    
    public void setLastName(String ln) {
        lastName = ln;
    }
    
    public void setSched(PlaneSchedule s) {
        sched = s;
    }
}
