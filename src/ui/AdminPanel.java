package ui;
import data.*;

/**
 *
 * @author Acer
 */
public class AdminPanel extends javax.swing.JPanel {

    /**
     * Creates new form AdminPanel
     */
    public AdminPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        clientInfoPane = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        clientModel = new javax.swing.table.DefaultTableModel();
        dataSheet = new javax.swing.JTable();
        flightInfoPane = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        flightModel = new javax.swing.table.DefaultTableModel();
        flightTable = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        addFlightBtn = new javax.swing.JButton();
        saveBtn = new javax.swing.JButton();
        delAllBtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setBackground(java.awt.SystemColor.inactiveCaption);
        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, java.awt.Color.darkGray), "Admin's Info", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18), java.awt.Color.darkGray)); // NOI18N
        setFocusable(false);
        setLayout(null);

        jTabbedPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTabbedPane1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        clientInfoPane.setBackground(java.awt.Color.lightGray);

        jScrollPane1.setBackground(new java.awt.Color(204, 255, 204));
        jScrollPane1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        data.Client[] clients = new data.Client[data.StaticData.clientData.size()];
        for(int i = 0; i < clients.length; i++) {
            clients[i] = (data.Client) data.StaticData.clientData.search(i);
        }
        clientModel.setColumnIdentifiers(new Object[] {"Ticket Number","First Name", "Last Name", "Flight Destination", "Flight Schedule", "Departure Date"});
        for(int i = 0; i < clients.length; i++) {
            clientModel.addRow(new Object[] {clients[i].getTicketNum(), clients[i].getFirstName(), clients[i].getLastName(), clients[i].getSched().getDestination(), clients[i].getSched().getTime(), clients[i].getSched().getDate()});
        }
        dataSheet.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        dataSheet.setModel(clientModel);
        jScrollPane1.setViewportView(dataSheet);

        javax.swing.GroupLayout clientInfoPaneLayout = new javax.swing.GroupLayout(clientInfoPane);
        clientInfoPane.setLayout(clientInfoPaneLayout);
        clientInfoPaneLayout.setHorizontalGroup(
            clientInfoPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clientInfoPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1097, Short.MAX_VALUE)
                .addContainerGap())
        );
        clientInfoPaneLayout.setVerticalGroup(
            clientInfoPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clientInfoPaneLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(149, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Client Information", clientInfoPane);

        flightInfoPane.setBackground(javax.swing.UIManager.getDefaults().getColor("CheckBox.darkShadow"));

        jScrollPane2.setBackground(new java.awt.Color(204, 255, 204));

        data.PlaneSchedule[] plane = new data.PlaneSchedule[data.StaticData.planeData.size()];
        flightModel.setColumnIdentifiers(new String[] {"Flight Name", "Flight Destination", "Flight Schedule", "Flight Date"});
        for(int i = 0; i < plane.length; i++) {
            plane[i] = (data.PlaneSchedule) data.StaticData.planeData.search(i);
            flightModel.addRow(new Object[] {plane[i].getName(), plane[i].getDestination(), plane[i].getTime(), plane[i].getDate()});
        }
        flightTable.setModel(flightModel);
        jScrollPane2.setViewportView(flightTable);

        jButton3.setText("Delete Selected");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        addFlightBtn.setText("Add");
        addFlightBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFlightBtnActionPerformed(evt);
            }
        });

        saveBtn.setText("Save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        delAllBtn.setText("Delete All");
        delAllBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delAllBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout flightInfoPaneLayout = new javax.swing.GroupLayout(flightInfoPane);
        flightInfoPane.setLayout(flightInfoPaneLayout);
        flightInfoPaneLayout.setHorizontalGroup(
            flightInfoPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(flightInfoPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1097, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(flightInfoPaneLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(addFlightBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(delAllBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );
        flightInfoPaneLayout.setVerticalGroup(
            flightInfoPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(flightInfoPaneLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addGroup(flightInfoPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addFlightBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delAllBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Flight Information", flightInfoPane);

        add(jTabbedPane1);
        jTabbedPane1.setBounds(85, 49, 1138, 547);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton1.setText("Logout");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(68, 614, 165, 37);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        StaticData.frame.remove(this);
        StaticData.loginPanel.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void addFlightBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFlightBtnActionPerformed
        // TODO add your handling code here:
        CreateNewPlaneSchedDialog sched = new CreateNewPlaneSchedDialog(data.StaticData.frame, true);
        sched.setVisible(true);
        if(sched.getReturnStatus() == 1) {
            data.PlaneSchedule[] plane = new data.PlaneSchedule[data.StaticData.planeData.size()];
            for(int i = 0; i < plane.length; i++) {
                plane[i] = data.StaticData.planeData.search(i);
            }
            int count = ++data.StaticData.planeCount;
            for(int i = count - 1; i < plane.length; i++) {
                flightModel.addRow(new Object[] {plane[i].getName(), plane[i].getDestination(), plane[i].getTime(), plane[i].getDate()});
            }
            flightTable.setModel(flightModel);
        }
        
    }//GEN-LAST:event_addFlightBtnActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        // TODO add your handling code here:
        data.StaticData.savePlaneScheds();
        SuccessDialog success = new SuccessDialog(data.StaticData.frame, true);
        success.setVisible(true);
    }//GEN-LAST:event_saveBtnActionPerformed

    private void delAllBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delAllBtnActionPerformed
        // TODO add your handling code here:
        AreYouSureDialog yes = new AreYouSureDialog(data.StaticData.frame, true);
        yes.setVisible(true);
        if(yes.getReturnStatus() == 1) {
            for(int i = flightModel.getRowCount(); i > 0; i--) {
                flightModel.removeRow(0);
            }
            flightTable.setModel(flightModel);
            data.StaticData.planeCount = 0;
        }
    }//GEN-LAST:event_delAllBtnActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int row = flightTable.getSelectedRow();
        flightModel.removeRow(row);
        data.StaticData.planeData.delete(row);
        data.StaticData.planeCount--;
        flightTable.setModel(flightModel);
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addFlightBtn;
    private javax.swing.JPanel clientInfoPane;
    private javax.swing.table.DefaultTableModel clientModel;
    private javax.swing.JTable dataSheet;
    private javax.swing.JButton delAllBtn;
    private javax.swing.JPanel flightInfoPane;
    private javax.swing.table.DefaultTableModel flightModel;
    private javax.swing.JTable flightTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton saveBtn;
    // End of variables declaration//GEN-END:variables
}
