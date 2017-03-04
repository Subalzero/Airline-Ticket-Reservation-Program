package data;

import ui.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * All static fields and methods are defined in this class.
 *
 * @author Lord Alzer Casiño
 */
public class StaticData {
    
    /**
     * Do not let anyone instantiate this class.
     */
    private StaticData() {}
    
    //Static Declarations
    public static MainFrame frame;                      //reference to the main frame.
    public static Login loginPanel;                     //static reference to the login Panel.
    public static LinkedList<Client> clientData;        //reference to the data for all client information.
    public static int nAcc = 0;                         //number of the latest ticket number.
    public static LinkedList<PlaneSchedule> planeData;  //reference to the data for all airplane information.
    public static int planeCount = 0;                   //number of plane entries.
    
    /**
     * Writes the client data into the file specified.
     */
    public static void saveClients() {
        try(ObjectOutputStream write = new ObjectOutputStream(new FileOutputStream("clients.dat"))) {
            write.writeObject(clientData);
        }
        catch(IOException e) {
            System.out.println(e);
        }   
    }
    
    /**
     * Reads the client data from the file specified.
     */
    public static void getClients() {
        try(ObjectInputStream read = new ObjectInputStream(new FileInputStream("clients.dat"))) {
            clientData = (LinkedList<Client>) read.readObject();
        }
        catch(IOException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }
    
    /**
     * Writes the flight data into the file specified.
     */
    public static void savePlaneScheds() {
        try(ObjectOutputStream write = new ObjectOutputStream(new FileOutputStream("planes.dat"))) {
            write.writeObject(planeData);
        }
        catch(IOException e) {
            System.out.println(e);
        }
    }
    
    /**
     * Reads the flight data from the file specified.
     */
    public static void getPlaneScheds() {
        try(ObjectInputStream read = new ObjectInputStream(new FileInputStream("planes.dat"))) {
            planeData = (LinkedList<PlaneSchedule>) read.readObject();
        }
        catch(IOException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }
}
