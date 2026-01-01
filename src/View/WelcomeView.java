package View;
import Controller.AppController;
import Model.Librarian;
import javax.swing.*;
import java.awt.*;
public class WelcomeView extends javax.swing.JFrame {
     private AppController appController;
       public WelcomeView(AppController appController) {
        this.appController = appController;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Library Management System - Login");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        g = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        UN = new javax.swing.JTextField();
        log = new javax.swing.JButton();
        admin = new javax.swing.JRadioButton();
        librarian = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        PS = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(0, 255, 153));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("            Library Management System");
        jLabel1.setOpaque(true);

        jLabel2.setText("Username:");

        jLabel3.setText("Password:");

        log.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        log.setForeground(new java.awt.Color(255, 0, 0));
        log.setText("login");
        log.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logActionPerformed(evt);
            }
        });

        admin.setText("Admin");

        librarian.setText("Librarian");

        jLabel4.setText("Login As:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(UN, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                            .addComponent(PS)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(jLabel4)
                        .addGap(56, 56, 56)
                        .addComponent(admin)
                        .addGap(63, 63, 63)
                        .addComponent(librarian))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addComponent(log, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(admin)
                    .addComponent(librarian)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(PS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addComponent(log, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logActionPerformed
  String username = UN.getText().trim();
        String password = new String(PS.getText()).trim();

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter username and password!", 
                "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (admin.isSelected()) {
            if (appController.authenticateAdmin(username, password)) {
                JOptionPane.showMessageDialog(this, "Welcome Admin!", 
                    "Login Successful", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                AdminView adminView = new AdminView(appController);
                adminView.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid admin credentials!", 
                    "Login Failed", JOptionPane.ERROR_MESSAGE);
                PS.setText("");
            }
        } else if (librarian.isSelected()) {
            Librarian lib = appController.authenticateLibrarian(username, password);
            if (lib != null) {
                JOptionPane.showMessageDialog(this, "Welcome " + lib.getName() + "!", 
                    "Login Successful", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                LibrarianView libView = new LibrarianView(appController, lib);
                libView.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid librarian credentials!", 
                    "Login Failed", JOptionPane.ERROR_MESSAGE);
                PS.setText("");
    }//GEN-LAST:event_logActionPerformed
        
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField PS;
    private javax.swing.JTextField UN;
    private javax.swing.JRadioButton admin;
    private javax.swing.ButtonGroup g;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JRadioButton librarian;
    private javax.swing.JButton log;
    // End of variables declaration//GEN-END:variables
}
