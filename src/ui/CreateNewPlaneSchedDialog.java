/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

/**
 *
 * @author Acer
 */
public class CreateNewPlaneSchedDialog extends javax.swing.JDialog {

    /**
     * A return status code - returned if Cancel button has been pressed
     */
    public static final int RET_CANCEL = 0;
    /**
     * A return status code - returned if OK button has been pressed
     */
    public static final int RET_OK = 1;

    /**
     * Creates new form CreateNewPlaneSchedDialog
     */
    public CreateNewPlaneSchedDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        // Close the dialog when Esc is pressed
        String cancelName = "cancel";
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), cancelName);
        ActionMap actionMap = getRootPane().getActionMap();
        actionMap.put(cancelName, new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                doClose(RET_CANCEL);
            }
        });
    }

    /**
     * @return the return status of this dialog - one of RET_OK or RET_CANCEL
     */
    public int getReturnStatus() {
        return returnStatus;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        createButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        nameLabel = new javax.swing.JLabel();
        destinationLabel = new javax.swing.JLabel();
        departTimeLabel = new javax.swing.JLabel();
        departDateLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        destinationField = new javax.swing.JTextField();
        departTimeField = new javax.swing.JTextField();
        departDateField = new javax.swing.JTextField();
        nameStatusLabel = new javax.swing.JLabel();
        destinationStatusLabel = new javax.swing.JLabel();
        departTimeStatusLabel = new javax.swing.JLabel();
        departDateStatusLabel = new javax.swing.JLabel();
        scheduleLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Create Flight Schedule");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });
        getContentPane().setLayout(null);

        createButton.setText("Create");
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonActionPerformed(evt);
            }
        });
        getContentPane().add(createButton);
        createButton.setBounds(45, 458, 146, 47);
        getRootPane().setDefaultButton(createButton);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        getContentPane().add(cancelButton);
        cancelButton.setBounds(503, 458, 146, 47);

        nameLabel.setText("Flight Name          :");
        getContentPane().add(nameLabel);
        nameLabel.setBounds(45, 130, 179, 30);

        destinationLabel.setText("Flight Destination   :");
        getContentPane().add(destinationLabel);
        destinationLabel.setBounds(45, 169, 179, 30);

        departTimeLabel.setText("Departure Time     :");
        getContentPane().add(departTimeLabel);
        departTimeLabel.setBounds(45, 208, 179, 30);

        departDateLabel.setText("Departure Date       :");
        getContentPane().add(departDateLabel);
        departDateLabel.setBounds(45, 247, 179, 30);
        getContentPane().add(nameField);
        nameField.setBounds(239, 132, 223, 26);
        getContentPane().add(destinationField);
        destinationField.setBounds(239, 171, 223, 26);
        getContentPane().add(departTimeField);
        departTimeField.setBounds(239, 210, 223, 26);
        getContentPane().add(departDateField);
        departDateField.setBounds(239, 249, 223, 26);
        getContentPane().add(nameStatusLabel);
        nameStatusLabel.setBounds(480, 130, 169, 30);
        getContentPane().add(destinationStatusLabel);
        destinationStatusLabel.setBounds(480, 169, 169, 30);
        getContentPane().add(departTimeStatusLabel);
        departTimeStatusLabel.setBounds(480, 208, 169, 0);
        getContentPane().add(departDateStatusLabel);
        departDateStatusLabel.setBounds(480, 247, 169, 0);

        scheduleLabel.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        scheduleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        scheduleLabel.setText("Create New Schedule");
        getContentPane().add(scheduleLabel);
        scheduleLabel.setBounds(264, 45, 220, 22);

        setSize(new java.awt.Dimension(726, 606));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonActionPerformed
        if(nameField.getText().isEmpty()) {
            nameStatusLabel.setText("Field cannot be empty");
            destinationStatusLabel.setText("");
            departTimeStatusLabel.setText("");
            departDateStatusLabel.setText("");
            throw new EmptyFieldException();
        }
        if(destinationField.getText().isEmpty()) {
            nameStatusLabel.setText("");
            destinationStatusLabel.setText("Field cannot be empty");
            departTimeStatusLabel.setText("");
            departDateStatusLabel.setText("");
            throw new EmptyFieldException();
        }
        if(departTimeField.getText().isEmpty()) {
            nameStatusLabel.setText("");
            destinationStatusLabel.setText("");
            departTimeStatusLabel.setText("Field cannot be empty");
            departDateStatusLabel.setText("");
            throw new EmptyFieldException();
        }
        if(departDateField.getText().isEmpty()) {
            nameStatusLabel.setText("");
            destinationStatusLabel.setText("");
            departTimeStatusLabel.setText("");
            departDateStatusLabel.setText("Field cannot be empty");
            throw new EmptyFieldException();
        }
        String name = nameField.getText();
        String destination = destinationField.getText();
        String departTime = departTimeField.getText();
        String departDate = departDateField.getText();
        data.PlaneSchedule newPlane = new data.PlaneSchedule(name, destination, departTime, departDate);
        data.StaticData.planeData.addLast(newPlane);
        doClose(RET_OK);
        ScheduleCreatedDialog success = new ScheduleCreatedDialog(data.StaticData.frame, true);
        success.setVisible(true);
    }//GEN-LAST:event_createButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        doClose(RET_CANCEL);
    }//GEN-LAST:event_cancelButtonActionPerformed

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        doClose(RET_CANCEL);
    }//GEN-LAST:event_closeDialog
    
    private void doClose(int retStatus) {
        returnStatus = retStatus;
        setVisible(false);
        dispose();
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton createButton;
    private javax.swing.JTextField departDateField;
    private javax.swing.JLabel departDateLabel;
    private javax.swing.JLabel departDateStatusLabel;
    private javax.swing.JTextField departTimeField;
    private javax.swing.JLabel departTimeLabel;
    private javax.swing.JLabel departTimeStatusLabel;
    private javax.swing.JTextField destinationField;
    private javax.swing.JLabel destinationLabel;
    private javax.swing.JLabel destinationStatusLabel;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel nameStatusLabel;
    private javax.swing.JLabel scheduleLabel;
    // End of variables declaration//GEN-END:variables

    private int returnStatus = RET_CANCEL;
}
