package View;
import Controller.AppController;
import Model.Book;
import Model.IssuedBook;
import Model.Librarian;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ReturnBookView extends javax.swing.JFrame {
 private AppController appController;
    private Librarian currentLibrarian;    
      public ReturnBookView(AppController appController, Librarian librarian) {
        this.appController = appController;
        this.currentLibrarian = librarian;
        initComponents();
        initializeFields();
        loadIssuedBooks();
        setLocationRelativeTo(null);
        setTitle("Return Book");
    }
      private void initializeFields() {
    LID.setText(currentLibrarian.getLibrarianId());
    LID.setEditable(false);
    LNA.setText(currentLibrarian.getName());
    LNA.setEditable(false);
    LocalDate today = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    RD.setText(today.format(formatter));
    RD.setEditable(false);
}
     
      private void loadIssuedBooks() {
    DefaultTableModel model = (DefaultTableModel) table.getModel();
    model.setRowCount(0);
    
    List<IssuedBook> issuedBooks = appController.getBookController().getAllIssuedBooks();
    
    for (IssuedBook ib : issuedBooks) {
        model.addRow(new Object[]{
            ib.getBookNumber(),
            ib.getBookName(),
            ib.getLibrarianId(),
            ib.getLibrarianName(),
            ib.getIssueDate(),
            ib.getReturnDate()
        });
    }
}
      private void clearFields() {
    BNU.setText("");
    BNA.setText("");
    ISD.setText("");
    RD.setText("");
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        BNU = new javax.swing.JTextField();
        BNA = new javax.swing.JTextField();
        LID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        LNA = new javax.swing.JTextField();
        RD = new javax.swing.JTextField();
        Return = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        ISD = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        c = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("BookNumber:");

        jLabel2.setText("BookName:");

        jLabel3.setText("LibrarianId:");

        jLabel4.setText("LibrarianName:");

        jLabel5.setText("ReturnDate:");

        Return.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Return.setForeground(new java.awt.Color(0, 0, 255));
        Return.setText("ReturnBook");
        Return.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReturnActionPerformed(evt);
            }
        });

        jLabel6.setText("IssueDate:");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "BookNumber", "BookName", "LibrarianId", "LibrarianName", "IssueDate"
            }
        ));
        jScrollPane1.setViewportView(table);

        c.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        c.setForeground(new java.awt.Color(0, 0, 255));
        c.setText("Close");
        c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 694, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BNU, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                            .addComponent(BNA)
                            .addComponent(LID))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(LNA, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(c, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(35, 35, 35)
                                        .addComponent(Return))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(150, 150, 150)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel6)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(ISD, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(RD, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(BNU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(LNA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(BNA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(ISD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(LID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(RD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Return)
                    .addComponent(c))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnActionPerformed
          String bookNumber = BNU.getText().trim();
    String librarianId = LID.getText().trim();

    if (bookNumber.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter Book Number!", 
            "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Find the issued book record
    List<IssuedBook> issuedBooks = appController.getBookController().getAllIssuedBooks();
    IssuedBook targetBook = null;
    
    for (IssuedBook ib : issuedBooks) {
        if (ib.getBookNumber().equals(bookNumber) && 
            ib.getLibrarianId().equals(librarianId)) {
            targetBook = ib;
            break;
        }
    }

    if (targetBook == null) {
        JOptionPane.showMessageDialog(this, 
            "No issued record found for this book and librarian!", 
            "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    BNA.setText(targetBook.getBookName());
    ISD.setText(targetBook.getIssueDate().toString());
    

    int confirm = JOptionPane.showConfirmDialog(this, 
        "Return book '" + targetBook.getBookName() + "'?", 
        "Confirm Return", 
        JOptionPane.YES_NO_OPTION);
    
   if (confirm == JOptionPane.YES_OPTION) {
    LocalDate returnDate = LocalDate.now();

    // show it in the text field
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    RD.setText(returnDate.format(formatter));

    if (appController.getBookController().returnBook(bookNumber, librarianId, returnDate)) {
        JOptionPane.showMessageDialog(this, "Book returned successfully!", 
            "Success", JOptionPane.INFORMATION_MESSAGE);

        loadIssuedBooks();
        clearFields();   // careful: clearFields() currently clears RD too
    } else {
        JOptionPane.showMessageDialog(this, "Failed to return book!", 
            "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    }//GEN-LAST:event_ReturnActionPerformed

    private void cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cActionPerformed
   this.dispose();
    }//GEN-LAST:event_cActionPerformed

    public static void main(String args[]) {
       java.awt.EventQueue.invokeLater(() -> {
        AppController controller = new AppController();
        Librarian dummyLib = new Librarian("L001", "user", "pass", "Test User", "test@email.com", "1234567890");
        new ReturnBookView(controller, dummyLib).setVisible(true);
    });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BNA;
    private javax.swing.JTextField BNU;
    private javax.swing.JTextField ISD;
    private javax.swing.JTextField LID;
    private javax.swing.JTextField LNA;
    private javax.swing.JTextField RD;
    private javax.swing.JButton Return;
    private javax.swing.JButton c;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
