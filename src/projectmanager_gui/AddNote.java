/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectmanager_gui;

import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Louis W.
 */
public class AddNote extends javax.swing.JFrame {
    private final  Integer selectedTask;

    /**
     * Creates new form ReportWin
     */
    public AddNote(ProjectManager a, LogWindow l, Integer selectedTask) {
        ana = a;
        log = l;
        this.selectedTask = selectedTask;
        initComponents();
        this.setLocationRelativeTo(null);
        info.update("task_notes", ana);
        initTable(1);   // without this, date column in assignments will be object with no type (instead of string object)
        /*
        No Tab key-pressed or key-released events are received by the key event listener. This is because the focus subsystem 
        consumes focus traversal keys, such as Tab and Shift Tab. To solve this, apply the following to the component that is 
        firing the key events 
        */
        table.setFocusTraversalKeysEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        scrollpane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jSubmit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jCancel = new javax.swing.JButton();
        jAddRow = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(550, 200));

        scrollpane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollpane.setMaximumSize(new java.awt.Dimension(260, 100));
        scrollpane.setMinimumSize(new java.awt.Dimension(130, 50));

        table.setAutoCreateRowSorter(true);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "noteID", "taskID", "submitter", "status_note", "status_date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tableKeyPressed(evt);
            }
        });
        scrollpane.setViewportView(table);

        jSubmit.setText("Submit");
        jSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSubmitActionPerformed(evt);
            }
        });

        jLabel1.setText("Table task_notes");

        jCancel.setText("Cancel");
        jCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCancelActionPerformed(evt);
            }
        });

        jAddRow.setText("+");
        jAddRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAddRowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollpane, javax.swing.GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jAddRow)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSubmit)
                        .addGap(18, 18, 18)
                        .addComponent(jCancel)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollpane, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSubmit)
                    .addComponent(jCancel)
                    .addComponent(jAddRow))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSubmitActionPerformed
        ProjectManagerDAO analyzerDao = new ProjectManagerDAO();
        try {
            analyzerDao.insert(table,columnNames,info, tableName,ana,log);
        } catch (SQLException ex) {
            Logger.getLogger(AddNote.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jSubmitActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
//        int row = table.getSelectedRow();
//        ResultSet rs = null;
//        try {
//            String sqlView = "select * from Suggestions where ID= " + table.getValueAt(row, 0) + ";";
//            //System.out.println(sqlView);
//            rs = stmt.executeQuery(sqlView);
//            /*int size= 0;
//             if (rs != null)   
//             {  
//             rs.beforeFirst();  
//             rs.last();  
//             size = rs.getRow();  
//             } */
//            rs.first();
//	    			//System.out.println(size);
//            //logwind.sendMessages(sqlChange);
//            rs.close();
//
//        } catch (SQLException ex) {
//	    			//logwind.sendMessages(ex.getMessage());
//            //logwind.sendMessages(ex.getSQLState() + "\n");
//            System.out.println("Error: " + ex);
//        } catch (Exception ex) {
//            System.out.println("Error: " + ex);
//            //logwind.sendMessages(ex.getMessage());
//        }
    }//GEN-LAST:event_tableMouseClicked

    private void jCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_jCancelActionPerformed

    private void jAddRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAddRowActionPerformed
        int rows = table.getRowCount();
        initTable(rows+1);
    }//GEN-LAST:event_jAddRowActionPerformed

    private void tableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableKeyPressed
        
        if (evt.getKeyChar() == KeyEvent.VK_TAB) {
            int row = table.getSelectedRow(), col = table.getSelectedColumn();

            if (row == 0 && table.getValueAt(row, info.getDateColumn()).toString().equals("")) {
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date date = new Date();
                String today = dateFormat.format(date);
                table.setValueAt(today, 0, info.getDateColumn());    // default daate input with today's date
            } else if (row > 0 && col != info.getDateColumn()) {
                table.setValueAt(table.getValueAt(row - 1, col), row, col);
            }
            if (col == info.getLastColumn() && table.getValueAt(row+1, info.getDateColumn()).toString().equals("")) {   // date auto filled at the beginning
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date date = new Date();
                String today = dateFormat.format(date);
                table.setValueAt(today, row+1, info.getDateColumn());    // default daate input with today's date
            
            } 
        }
    }//GEN-LAST:event_tableKeyPressed

    private void initTable(int rows) {
        tableName = "task_notes";
        Vector tableDefault, table0;    // default content of table which includes empty rows
        List list = new ArrayList();

        while (rows-- > 0) {    // add new empty rows
            String[] aaa = info.getEmptyRow();
            aaa[0]=String.valueOf(selectedTask);
            table0 = new Vector(Arrays.asList(aaa));
            list.add(table0);
        }
        columnNames = new Vector(Arrays.asList(info.getColumnTitles()));

        tableDefault = new Vector(list);
        
        DefaultTableModel model = new DefaultTableModel(tableDefault, columnNames);
        table.setModel(model);

    }
   
    private Statement stmt;
    private final String sqlC = "select * from Suggestions";
    private ProjectManager ana = new ProjectManager();
    private LogWindow log = new LogWindow();
    private Vector columnNames = new Vector();
    private String tableName;
    private AddRecordsTable info = new AddRecordsTable();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jAddRow;
    private javax.swing.JButton jCancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton jSubmit;
    private javax.swing.JScrollPane scrollpane;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}