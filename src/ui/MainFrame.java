package ui;
import javax.swing.*;
import data.*;

/**
 *
 * @author Acer
 */
public class MainFrame extends JFrame {
      
    public MainFrame() {
        initComponents();
    }
    
    private void initComponents() {
        
        StaticData.loginPanel = new Login();
        
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1360, 768);
        setLocationRelativeTo(null);
        setTitle("Airline Ticket Reservation Queue");
        
        add(StaticData.loginPanel);
        StaticData.loginPanel.setVisible(true);
    }
    
    
    private static void setUILook() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
