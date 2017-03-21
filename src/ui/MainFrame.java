package ui;
import javax.swing.*;
import data.*;
import java.awt.event.*;
import de.javasoft.plaf.synthetica.SyntheticaPlainLookAndFeel;
import java.text.ParseException;

/**
 *
 * @author Acer
 */
public class MainFrame extends JFrame {
    
    private JMenuBar menuBar;
    private JMenu helpMenu;
    private JMenuItem aboutMenu;
    
    public MainFrame() {
        initComponents();
    }
    
    private void initComponents() {
        
        menuBar = new JMenuBar();
        
        StaticData.loginPanel = new Login();
        
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1360, 768);
        setLocationRelativeTo(null);
        setTitle("Airline Ticket Reservation Queue");
        
        add(StaticData.loginPanel);
        StaticData.loginPanel.setVisible(true);
        
        helpMenu = new JMenu("Help");
        helpMenu .setMnemonic(KeyEvent.VK_N);
        helpMenu .getAccessibleContext().setAccessibleDescription(
            "This menu does nothing");
        
        aboutMenu = new JMenuItem("About");
        helpMenu.add(aboutMenu);
        
        menuBar.add(helpMenu);
        
        
        setJMenuBar(menuBar);
    }
    
    
    private static void setUILook() {
        try 
        {
            UIManager.setLookAndFeel(new SyntheticaPlainLookAndFeel());
        } 
        catch (ParseException | UnsupportedLookAndFeelException e) {}
    }
    
    public static void main(String[] args) {
        setUILook();
        StaticData.getClients();
        if(StaticData.clientData == null) {
            StaticData.clientData = new LinkedList<>();
        }
        try {
            StaticData.nAcc = StaticData.clientData.last().getTicketNum();
        }
        catch(NullPointerException e) {
            StaticData.nAcc = 0;
        }
        StaticData.getPlaneScheds();
        if(StaticData.planeData == null) {
            StaticData.planeData = new LinkedList<>();
        }
        try {
            StaticData.planeCount = StaticData.planeData.size();
        }
        catch(NullPointerException e) {
            StaticData.planeCount = 0;
        }
        StaticData.frame = new MainFrame();
        StaticData.frame.setVisible(true);
    }
}
