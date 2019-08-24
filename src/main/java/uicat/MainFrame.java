package uicat;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainFrame extends javax.swing.JFrame{

  private List<Cat> catsAll = new ArrayList<>();
  private List<Cat> catsToBay = new ArrayList<>();
  private CatTableModel catTableModelAll = new CatTableModel();
  private CatTableModel catTableModeltoBay = new CatTableModel();
  private final Gson gson = new GsonBuilder()
          .setPrettyPrinting()
          .create();
  private java.lang.reflect.Type typeOfHashMap = new TypeToken<List<Cat>>() {
  }.getType();

  /**
   * Creates new form MainFrame
   */
  public MainFrame() {
    initComponents();

    jTable1.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
      if (jTable1.getSelectedRow() > -1) {
        // print first column value from selected row
        jTextField6.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
        jTextField7.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
        jTextField8.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString());
        jTextField9.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString());
      }
    });
    //загрузим данные из файла
    try (JsonReader readerAll = new JsonReader(new FileReader("d:/catsAll.txt"))) {
      catsAll = gson.fromJson(readerAll, typeOfHashMap);
    } catch (IOException ex) {
      JOptionPane.showMessageDialog(rootPane, "Ошибка чтения файла.\n" + ex.getLocalizedMessage());
    }

    try (JsonReader readerToBay = new JsonReader(new FileReader("d:/catsToBay.txt"))) {
      catsToBay = gson.fromJson(readerToBay, typeOfHashMap);
    } catch (IOException ex) {
      JOptionPane.showMessageDialog(rootPane, "Ошибка чтения файла.\n" + ex.getLocalizedMessage());
    }

    catTableModelAll.setList(catsAll);
    jTable1.setModel(catTableModelAll);
    catTableModelAll.fireTableDataChanged();

    catTableModeltoBay.setList(catsToBay);
    jTable2.setModel(catTableModeltoBay);
    catTableModeltoBay.fireTableDataChanged();
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jTextField4 = new javax.swing.JTextField();
    jScrollPane1 = new javax.swing.JScrollPane();
    jTable1 = new javax.swing.JTable();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jLabel5 = new javax.swing.JLabel();
    jLabel6 = new javax.swing.JLabel();
    jTextField6 = new javax.swing.JTextField();
    jTextField7 = new javax.swing.JTextField();
    jTextField8 = new javax.swing.JTextField();
    jTextField9 = new javax.swing.JTextField();
    jButton1 = new javax.swing.JButton();
    jButton2 = new javax.swing.JButton();
    jButton3 = new javax.swing.JButton();
    jScrollPane3 = new javax.swing.JScrollPane();
    jTable2 = new javax.swing.JTable();
    jButton4 = new javax.swing.JButton();

    jTextField4.setText("jTextField4");

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    addWindowListener(new java.awt.event.WindowAdapter() {
      public void windowClosed(java.awt.event.WindowEvent evt) {
        formWindowClosed(evt);
      }
      public void windowClosing(java.awt.event.WindowEvent evt) {
        formWindowClosing(evt);
      }
    });

    jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
    ));
    jScrollPane1.setViewportView(jTable1);

    jLabel1.setText("Все котята");

    jLabel2.setText("Котята на продажу");

    jLabel3.setText("Кличка:");

    jLabel4.setText("Рост:");

    jLabel5.setText("Вес:");

    jLabel6.setText("Возраст:");

    jTextField9.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jTextField9ActionPerformed(evt);
      }
    });

    jButton1.setText("Добавить");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });

    jButton2.setText("Выставить на продажу");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton2ActionPerformed(evt);
      }
    });

    jButton3.setText("Продать");
    jButton3.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton3ActionPerformed(evt);
      }
    });

    jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                    {},
                    {},
                    {},
                    {}
            },
            new String [] {

            }
    ));
    jScrollPane3.setViewportView(jTable2);

    jButton4.setText("Изменить");
    jButton4.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton4ActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel4)
                                                    .addComponent(jLabel5))
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                            .addGap(83, 83, 83)
                                            .addComponent(jLabel2)
                                            .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel1)
                                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addContainerGap())
    );
    layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                                            .addComponent(jLabel2)
                                            .addGap(11, 11, 11)
                                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel3)
                                                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel4))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel5))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel6)
                                                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(30, 30, 30)
                                            .addComponent(jButton1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButton4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButton2)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButton3)
                                            .addGap(0, 0, Short.MAX_VALUE)))
                            .addContainerGap())
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_jTextField9ActionPerformed

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    // TODO add your handling code here:
    Cat cat = new Cat(new Date().getTime(),
            Float.parseFloat(jTextField7.getText()),
            Float.parseFloat(jTextField8.getText()),
            Integer.parseInt(jTextField9.getText()),
            jTextField6.getText());
    catsAll.add(cat);
    catTableModelAll.fireTableDataChanged();
  }//GEN-LAST:event_jButton1ActionPerformed

  private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
    // TODO add your handling code here:

  }//GEN-LAST:event_formWindowClosed

  private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    // TODO add your handling code here:
    try {
      System.out.println(gson.toJson(catsAll));
      try (Writer writer = new FileWriter("d:/catsAll.txt")) {
        gson.toJson(catsAll, writer);
      }
      try (Writer writer = new FileWriter("d:/catsToBay.txt")) {
        gson.toJson(catsToBay, writer);
      }
    } catch (IOException ex) {
      Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
  }//GEN-LAST:event_formWindowClosing

  private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    // TODO add your handling code here:
    if (!jTable1.getSelectionModel().isSelectionEmpty()) {
      Long l = (Long) jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 4);

      for (Cat cat2 : catsToBay) {
        if (cat2.getKey().equals(l)) {
          JOptionPane.showMessageDialog(rootPane, "Котенок уже выставлен на продажу.");
          return;
        }
      }

      catsAll.stream().filter((cat) -> (cat.getKey().equals(l))).forEachOrdered((cat) -> {
        if (cat.getAge() >= 2) {
          catsToBay.add(cat);
          catTableModeltoBay.fireTableDataChanged();
        } else {
          JOptionPane.showMessageDialog(rootPane, "Котенок еще слишком мал.");
        }
      });
    } else {
      JOptionPane.showMessageDialog(rootPane, "Сначала выберите строку из таблицы!");
    }
  }//GEN-LAST:event_jButton2ActionPerformed

  private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    // TODO add your handling code here:
    if (!jTable1.getSelectionModel().isSelectionEmpty()) {
      int selectedRow = jTable1.getSelectedRow();
      Long l = (Long) jTable1.getModel().getValueAt(selectedRow, 4);
      for (Cat cat : catsAll) {
        if (cat.getKey().equals(l)) {
          cat.setNickname(jTextField6.getText());
          cat.setHeight(Float.parseFloat(jTextField7.getText()));
          cat.setWeight(Float.parseFloat(jTextField8.getText()));
          cat.setAge(Integer.parseInt(jTextField9.getText()));
        }
      }
      for (Cat cat : catsToBay) {
        if (cat.getKey().equals(l)) {
          cat.setNickname(jTextField6.getText());
          cat.setHeight(Float.parseFloat(jTextField7.getText()));
          cat.setWeight(Float.parseFloat(jTextField8.getText()));
          cat.setAge(Integer.parseInt(jTextField9.getText()));
        }
      }

      catTableModelAll.fireTableDataChanged();
      catTableModeltoBay.fireTableDataChanged();

      jTable1.setRowSelectionInterval(selectedRow, selectedRow);
    } else {
      JOptionPane.showMessageDialog(rootPane, "Сначала выберите строку из таблицы!");
    }
  }//GEN-LAST:event_jButton4ActionPerformed

  private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    // TODO add your handling code here:
    if (!jTable2.getSelectionModel().isSelectionEmpty()) {
      Long l = (Long) jTable2.getModel().getValueAt(jTable2.getSelectedRow(), 4);

      Cat delCat = new Cat();
      for (Cat cat2 : catsToBay) {
        if (cat2.getKey().equals(l)) {
          delCat = cat2;
        }
      }

      catsToBay.remove(delCat);
      catsAll.remove(delCat);

      catTableModeltoBay.fireTableDataChanged();
      catTableModelAll.fireTableDataChanged();

      JOptionPane.showMessageDialog(rootPane, "Котенок " + delCat.getNickname() + " продан!");

    } else {
      JOptionPane.showMessageDialog(rootPane, "Сначала выберите строку из таблицы!");
    }
  }//GEN-LAST:event_jButton3ActionPerformed

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
      Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
    java.awt.EventQueue.invokeLater(() -> {
      new MainFrame().setVisible(true);
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton jButton1;
  private javax.swing.JButton jButton2;
  private javax.swing.JButton jButton3;
  private javax.swing.JButton jButton4;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane3;
  private javax.swing.JTable jTable1;
  private javax.swing.JTable jTable2;
  private javax.swing.JTextField jTextField4;
  private javax.swing.JTextField jTextField6;
  private javax.swing.JTextField jTextField7;
  private javax.swing.JTextField jTextField8;
  private javax.swing.JTextField jTextField9;
  // End of variables declaration//GEN-END:variables
}