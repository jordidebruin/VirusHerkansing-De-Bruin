/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virusherkansing;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

/**
 *
 * @author Jordii
 * Deze class zorgt ervoor dat de andere classes en processen in gang worden gezet wanneer
 * er een bestand wordt geopend, en wanneer er op de 'show' knop wordt gedrukt.
 * Date: 28 - 02 - 2018
 * 
 */
public class VirusGUI extends javax.swing.JFrame {

    /**
     * Instance van de class viruslogica wordt aangemaakt om de methodes aan te roepen, en
     * enkele variabelen worden gedeclareerd.
     */
    
    VirusLogica viruslogica = new VirusLogica();
    File f;
    String hostNameAndID;
    HashMap virusMap;
    ArrayList<String> ALLHOSTS = new ArrayList();

    /**
     * De host die de gebruiker kiest.
     */
    public static String selectedHost1;

    /**
     * Creates new form VirusGUI
     */
    public VirusGUI() {
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

        SortChoices = new javax.swing.ButtonGroup();
        PathTextfield = new javax.swing.JTextField();
        SearchButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        ClassificationDropdown = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        Host1Dropdown = new javax.swing.JComboBox<>();
        Host2Dropdown = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        VirusList1 = new javax.swing.JList<>();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        VirusList2 = new javax.swing.JList<>();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        OvereenkomstList = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PathTextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PathTextfieldActionPerformed(evt);
            }
        });

        SearchButton.setText("Search");
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Select file:");

        ClassificationDropdown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "ssDNA", "ssRNA", "dsDNA", "dsRNA", "Satellites & Virophages", "Viroids", "Other" }));
        ClassificationDropdown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClassificationDropdownActionPerformed(evt);
            }
        });

        jLabel2.setText("Viral Classification:");

        jLabel3.setText("Host 1:");

        jLabel4.setText("Host 2:");

        SortChoices.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("ID");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        SortChoices.add(jRadioButton2);
        jRadioButton2.setText("Number of hosts");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        SortChoices.add(jRadioButton3);
        jRadioButton3.setText("Viral Classification");

        jLabel5.setText("Sort on:");

        jLabel6.setText("Virus List 1:");

        jScrollPane1.setViewportView(VirusList1);

        jLabel7.setText("Virus List 2:");

        jScrollPane2.setViewportView(VirusList2);

        jLabel8.setText("Common viruses:");

        jScrollPane3.setViewportView(OvereenkomstList);

        jButton1.setText("Show!");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addComponent(Host1Dropdown, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(50, 50, 50)
                            .addComponent(jLabel4)
                            .addGap(18, 18, 18)
                            .addComponent(Host2Dropdown, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(35, 35, 35)
                                    .addComponent(jRadioButton1)
                                    .addGap(18, 18, 18)
                                    .addComponent(jRadioButton2))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(90, 90, 90)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jRadioButton3)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton1)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(jLabel1)
                                .addGap(32, 32, 32))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(PathTextfield)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(SearchButton))
                            .addComponent(ClassificationDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(85, 85, 85))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(222, 222, 222)))
                .addContainerGap(119, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PathTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchButton)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ClassificationDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Host1Dropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Host2Dropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    /**
     * Wanneer er op de zoekknop wordt gedrukt, wordt het gekozen bestand ingelezen.
     * Wanneer dit juist is gedaan, wordt de GUI gevuld met de data die in de methodes van 
     * viruslogica verkregen zijn.
     */    
    
    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
       ReadFile readfile = new ReadFile();
       readfile.chooseFile(PathTextfield);
       ArrayList<String> allHosts = viruslogica.createAllHosts();
       DefaultComboBoxModel model = (DefaultComboBoxModel)Host1Dropdown.getModel();
       DefaultComboBoxModel model2 = (DefaultComboBoxModel)Host2Dropdown.getModel();
       model.removeAllElements(); 
       model2.removeAllElements();
       ALLHOSTS = viruslogica.hosts;
       
       ALLHOSTS.stream().map((host) -> {
           model.addElement(host);
            return host;
        }).forEach((host) -> {
            model2.addElement(host);
        });
  
    }//GEN-LAST:event_SearchButtonActionPerformed

    private void PathTextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PathTextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PathTextfieldActionPerformed

    private void ClassificationDropdownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClassificationDropdownActionPerformed
  
    }//GEN-LAST:event_ClassificationDropdownActionPerformed

    /**
     * Deze methode zorgt ervoor dat de juiste virus ID's worden getoond in de lijsten. 
     * Dit wordt geüpdate als er vaker op de knop wordt geklikt.
     */    
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        final DefaultListModel model1 = new DefaultListModel();
        final DefaultListModel model2 = new DefaultListModel();
        final DefaultListModel modelX = new DefaultListModel();         
        String selectedHost1 = Host1Dropdown.getSelectedItem().toString();
        ArrayList<Virus> viruses1 = viruslogica.createVirusList1(virusMap, selectedHost1);
        String selectedHost2 = Host2Dropdown.getSelectedItem().toString();
        ArrayList<Virus> viruses2 = viruslogica.createVirusList2(virusMap, selectedHost2); 
        ArrayList<Virus> overeenkomstLijst = viruslogica.compareLists(viruses1, viruses2);        
        ArrayList<Integer> IDviruses1 = viruslogica.fillIDList1(viruses1);
        ArrayList<Integer> IDviruses2 = viruslogica.fillIDList2(viruses2);
        ArrayList<Integer> IDovereenkomstLijst = viruslogica.fillIDOvereenkomst(overeenkomstLijst);
        
        idToGUI(IDviruses1, IDviruses2, IDovereenkomstLijst, model1, model2, modelX);
        
        
    }//GEN-LAST:event_jButton1ActionPerformed


    

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VirusGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new VirusGUI().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ClassificationDropdown;
    private javax.swing.JComboBox<String> Host1Dropdown;
    private javax.swing.JComboBox<String> Host2Dropdown;
    private javax.swing.JList<String> OvereenkomstList;
    private javax.swing.JTextField PathTextfield;
    private javax.swing.JButton SearchButton;
    private javax.swing.ButtonGroup SortChoices;
    private javax.swing.JList<String> VirusList1;
    private javax.swing.JList<String> VirusList2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
   
    /**
     * Deze methode zorgt ervoor dat de ID's in de lijsten worden toegevoegd aan het
     * bijbehorende model. Hierdoor wordt het zichtbaar in de GUI.
     */
    
    private void idToGUI(ArrayList<Integer> IDviruses1, ArrayList<Integer> IDviruses2, ArrayList<Integer> IDovereenkomstLijst, DefaultListModel model1, DefaultListModel model2, DefaultListModel modelX) {
        IDviruses1.stream().forEach((ID) -> {
            model1.addElement(ID);
        });
        
        IDviruses2.stream().forEach((ID) -> {
            model2.addElement(ID);
        });
        
        IDovereenkomstLijst.stream().forEach((ID) -> {
            modelX.addElement(ID);
        });
        
        VirusList1.setModel(model1);
        VirusList2.setModel(model2);
        OvereenkomstList.setModel(modelX);  
    }

 




}

