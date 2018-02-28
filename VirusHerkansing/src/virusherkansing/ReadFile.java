/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virusherkansing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Deze class zorgt ervoor dat het bestand wordt ingelezen, en er voor elke regel een virus
 * object wordt aangemaakt als dit van toepassing is. 
 * @author Jordii
 */
public class ReadFile {
    
    public VirusGUI virusGUI = new VirusGUI();
    public VirusLogica viruslogica = new VirusLogica();
    public VirusLogica virusLogica = new VirusLogica();
    public static ArrayList<String> testHosts = new ArrayList();
    String classificatie;
    String hostNameAndID;
    JComboBox Host1Dropdown;
    JComboBox Host2Dropdown;
    DefaultComboBoxModel model;
    HashMap virusMap;

    /**
     * Deze methode zorgt ervoor dat het bestandspad in het tekstvak komt te staan.
     * Ook wordt de methode readline aangeroepen, waarin elke regel tot een virus wordt gemaakt.
     * @param PathTextfield
     */    
    public void chooseFile(JTextField PathTextfield){       
        JFileChooser chooser = new JFileChooser();                          
        chooser.showOpenDialog(null);                                       
        File f  = chooser.getSelectedFile();             
        String filename = f.getAbsolutePath();          
        PathTextfield.setText(filename);  
        readLine(f, model);
    }
    
    /**
     * Deze methode zorgt ervoor dat, als een regel een geschikte regel is en geen ontbrekende
     * data bevat, de regel tot virus wordt gemaakt.
     * @param f
     * @param model
     */        
    public void readLine(File f, DefaultComboBoxModel model){
        int count = 0;
        String regel;
        try {        
        Scanner s = new Scanner(f);
        s.nextLine();
        while (s.hasNext()){        
                    String[] lineData = (String[]) s.nextLine().split("\\t", -1);
                    if (!"virus tax id".equals(lineData[0]) && !"".equals(lineData[7]) && !"".equals(lineData[0]) && !"".equals(lineData[1]) && !"".equals(lineData[8]) && !"".equals(lineData[2])) {
                            virusLogica.virusChecker(lineData, classificatie); 
                            virusLogica.hostChecker();
                    }
                }
        virusLogica.createAllHosts(); 
        ArrayList<String> hostsss = virusLogica.hosts;                

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Het bestand is niet gevonden.");
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Er ontbreekt een verwachte waarde.");
        } catch (IOException ex){
            JOptionPane.showMessageDialog(null, "Er is iets mis gegaan met het lezen van het bstand.");
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Er is iets mis met de inhoud van het bestand.");
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Er is iets mis gegaan.");
        }
        
    }
    

    
}
