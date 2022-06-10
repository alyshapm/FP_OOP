/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author alyshapm
 */
public class ManageStudents extends javax.swing.JFrame {

    /**
     * Creates new form ManageBooks
     */
    
    String studentName, course, branch;
    int studentId;
    DefaultTableModel model;
    
    public ManageStudents() {
        initComponents();
        displayStudentsToTable();
    }
    
    // display book data into table
    public void displayStudentsToTable(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from student_details");
            
            while(rs.next()){
                int studentId = rs.getInt("student_id"); // gets book id from DB
                String studentName = rs.getString("name");
                String course = rs.getString("course");
                String branch = rs.getString("branch");
                
                Object[] obj = {studentId, studentName, course, branch};
                model =(DefaultTableModel) tbl_studentDetails.getModel(); // create a model which creates a row 
                model.addRow(obj);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    // add student to table
    public boolean addStudent(){
        boolean isAdded = false;
        studentId = Integer.parseInt(txt_studentId.getText());
        studentName = txt_studentName.getText();
        course = combo_courseName.getSelectedItem().toString();
        branch = combo_branch.getSelectedItem().toString();
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "insert into student_details values(?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, studentId);
            pst.setString(2, studentName);
            pst.setString(3, course);
            pst.setString(4, branch);
            
            int rowCount = pst.executeUpdate();
            if (rowCount > 0) {
                isAdded = true;
            } else {
                isAdded = false;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return isAdded;
    }
    
    // update student details
    public boolean updateStudent(){
        boolean isUpdated = false;
        studentId = Integer.parseInt(txt_studentId.getText());
        studentName = txt_studentName.getText();
        course = combo_courseName.getSelectedItem().toString();
        branch = combo_branch.getSelectedItem().toString();
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "update student_details set name = ?, course = ?, branch = ? where student_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, studentName);
            pst.setString(2, course);
            pst.setString(3, branch);
            pst.setInt(4, studentId);
            
            int rowCount = pst.executeUpdate();
            if (rowCount > 0) {
                isUpdated = true;
            } else {
                isUpdated = false;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return isUpdated;
    }
    
    // delete student
    public boolean deleteStudent(){
        boolean isDeleted = false;
        studentId = Integer.parseInt(txt_studentId.getText());
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "delete from student_details where student_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, studentId);
            
            int rowCount = pst.executeUpdate();
            if (rowCount > 0) {
                isDeleted = true;
            } else {
                isDeleted = false;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isDeleted;
    }
    
    // clear table -- used to display table when new information is added
    public void clearTable(){
        DefaultTableModel model = (DefaultTableModel) tbl_studentDetails.getModel();
        model.setRowCount(0);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_studentId = new app.bolivia.swing.JCTextField();
        txt_studentName = new app.bolivia.swing.JCTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        rSMaterialButtonRectangle1 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle2 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle3 = new rojerusan.RSMaterialButtonRectangle();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_bookId1 = new app.bolivia.swing.JCTextField();
        txt_bookName1 = new app.bolivia.swing.JCTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        rSMaterialButtonRectangle4 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle5 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle6 = new rojerusan.RSMaterialButtonRectangle();
        combo_courseName = new javax.swing.JComboBox<>();
        combo_branch = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_studentDetails = new rojeru_san.complementos.RSTableMetro();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Back");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Student ID");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, -1, -1));

        txt_studentId.setBackground(new java.awt.Color(102, 102, 255));
        txt_studentId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        txt_studentId.setForeground(new java.awt.Color(255, 255, 255));
        txt_studentId.setPlaceholder("Enter student ID...");
        txt_studentId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentIdFocusLost(evt);
            }
        });
        jPanel1.add(txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 350, 30));

        txt_studentName.setBackground(new java.awt.Color(102, 102, 255));
        txt_studentName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        txt_studentName.setForeground(new java.awt.Color(255, 255, 255));
        txt_studentName.setPlaceholder("Enter name...");
        txt_studentName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentNameFocusLost(evt);
            }
        });
        jPanel1.add(txt_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 350, 30));

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Select course");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 370, -1, -1));

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Select branch");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 460, -1, -1));

        rSMaterialButtonRectangle1.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonRectangle1.setText("delete");
        rSMaterialButtonRectangle1.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        rSMaterialButtonRectangle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle1ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonRectangle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 600, 120, 50));

        rSMaterialButtonRectangle2.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        rSMaterialButtonRectangle2.setLabel("Add");
        rSMaterialButtonRectangle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle2ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonRectangle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 600, 120, 50));

        rSMaterialButtonRectangle3.setBackground(new java.awt.Color(255, 255, 255));
        rSMaterialButtonRectangle3.setForeground(new java.awt.Color(102, 102, 255));
        rSMaterialButtonRectangle3.setText("UPDATE");
        rSMaterialButtonRectangle3.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        rSMaterialButtonRectangle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle3ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonRectangle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 600, 120, 50));

        jPanel3.setBackground(new java.awt.Color(102, 102, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Back");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Student ID");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, -1, -1));

        txt_bookId1.setBackground(new java.awt.Color(102, 102, 255));
        txt_bookId1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        txt_bookId1.setForeground(new java.awt.Color(255, 255, 255));
        txt_bookId1.setPlaceholder("Enter student ID...");
        txt_bookId1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookId1FocusLost(evt);
            }
        });
        jPanel3.add(txt_bookId1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 350, 30));

        txt_bookName1.setBackground(new java.awt.Color(102, 102, 255));
        txt_bookName1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        txt_bookName1.setForeground(new java.awt.Color(255, 255, 255));
        txt_bookName1.setPlaceholder("Enter name...");
        txt_bookName1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookName1FocusLost(evt);
            }
        });
        jPanel3.add(txt_bookName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 350, 30));

        jLabel9.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Name");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, -1, -1));

        jLabel10.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Select course");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 370, -1, -1));

        jLabel11.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Select branch");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 460, -1, -1));

        rSMaterialButtonRectangle4.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonRectangle4.setText("delete");
        rSMaterialButtonRectangle4.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        rSMaterialButtonRectangle4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle4ActionPerformed(evt);
            }
        });
        jPanel3.add(rSMaterialButtonRectangle4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 600, 120, 50));

        rSMaterialButtonRectangle5.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        rSMaterialButtonRectangle5.setLabel("Add");
        rSMaterialButtonRectangle5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle5ActionPerformed(evt);
            }
        });
        jPanel3.add(rSMaterialButtonRectangle5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 600, 120, 50));

        rSMaterialButtonRectangle6.setBackground(new java.awt.Color(255, 255, 255));
        rSMaterialButtonRectangle6.setForeground(new java.awt.Color(102, 102, 255));
        rSMaterialButtonRectangle6.setText("UPDATE");
        rSMaterialButtonRectangle6.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        rSMaterialButtonRectangle6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle6ActionPerformed(evt);
            }
        });
        jPanel3.add(rSMaterialButtonRectangle6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 600, 120, 50));

        combo_courseName.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        combo_courseName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Computer Science", "International Business", "Business, Management and Marketing", "Graphic Design", "Fashion", "Business Information System", "Communication", "Finance" }));
        jPanel3.add(combo_courseName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, 350, 30));

        combo_branch.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        combo_branch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "JWC", "f(X)" }));
        jPanel3.add(combo_branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 500, 350, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 830));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 830));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N

        tbl_studentDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Name", "Course", "Branch"
            }
        ));
        tbl_studentDetails.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        tbl_studentDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_studentDetails.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tbl_studentDetails.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tbl_studentDetails.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        tbl_studentDetails.setFuenteFilas(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        tbl_studentDetails.setFuenteFilasSelect(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        tbl_studentDetails.setFuenteHead(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        tbl_studentDetails.setRowHeight(40);
        tbl_studentDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_studentDetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_studentDetails);
        if (tbl_studentDetails.getColumnModel().getColumnCount() > 0) {
            tbl_studentDetails.getColumnModel().getColumn(2).setResizable(false);
            tbl_studentDetails.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 760, 470));

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Conference_26px.png"))); // NOI18N
        jLabel2.setText(" Manage Students");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 950, 830));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        Homepage home = new Homepage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void txt_studentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentIdFocusLost
//        if (checkDuplicateUser() == true) { // if username already exists, prompt error message
//            JOptionPane.showMessageDialog(this, "Username already exists");
//        }
    }//GEN-LAST:event_txt_studentIdFocusLost

    private void txt_studentNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentNameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentNameFocusLost

    private void rSMaterialButtonRectangle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle1ActionPerformed
        if (deleteStudent() == true){
            JOptionPane.showMessageDialog(this, "Student deleted");
            clearTable(); // avoids duplication of data when displayStudentsToTable is called
            displayStudentsToTable();
        } else {
            JOptionPane.showMessageDialog(this, "Failed deletion");
        }
    }//GEN-LAST:event_rSMaterialButtonRectangle1ActionPerformed

    private void rSMaterialButtonRectangle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle2ActionPerformed
        if (addStudent() == true){
            JOptionPane.showMessageDialog(this, "Student Added");
            clearTable(); // avoids duplication of data when displayStudentsToTable is called
            displayStudentsToTable();
        } else {
            JOptionPane.showMessageDialog(this, "Failed");
        }
    }//GEN-LAST:event_rSMaterialButtonRectangle2ActionPerformed

    private void rSMaterialButtonRectangle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle3ActionPerformed
        if (updateStudent() == true){
            JOptionPane.showMessageDialog(this, "Student Updated");
            clearTable(); // avoids duplication of data when displayStudentsToTable is called
            displayStudentsToTable();
        } else {
            JOptionPane.showMessageDialog(this, "Update failed");
        }
    }//GEN-LAST:event_rSMaterialButtonRectangle3ActionPerformed

    private void tbl_studentDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_studentDetailsMouseClicked
        int rowNo = tbl_studentDetails.getSelectedRow();
        TableModel model = tbl_studentDetails.getModel();
        
        txt_studentId.setText(model.getValueAt(rowNo, 0).toString());
        txt_studentName.setText(model.getValueAt(rowNo, 1).toString());
        combo_courseName.setSelectedItem(model.getValueAt(rowNo, 2).toString());
        combo_branch.setSelectedItem(model.getValueAt(rowNo, 3).toString());
        
    }//GEN-LAST:event_tbl_studentDetailsMouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseClicked

    private void txt_bookId1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookId1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookId1FocusLost

    private void txt_bookName1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookName1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookName1FocusLost

    private void rSMaterialButtonRectangle4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonRectangle4ActionPerformed

    private void rSMaterialButtonRectangle5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonRectangle5ActionPerformed

    private void rSMaterialButtonRectangle6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonRectangle6ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageStudents().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo_branch;
    private javax.swing.JComboBox<String> combo_courseName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle1;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle2;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle3;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle4;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle5;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle6;
    private rojeru_san.complementos.RSTableMetro tbl_studentDetails;
    private app.bolivia.swing.JCTextField txt_bookId1;
    private app.bolivia.swing.JCTextField txt_bookName1;
    private app.bolivia.swing.JCTextField txt_studentId;
    private app.bolivia.swing.JCTextField txt_studentName;
    // End of variables declaration//GEN-END:variables
}
