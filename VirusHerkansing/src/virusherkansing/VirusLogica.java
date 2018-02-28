/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virusherkansing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Deze class bevat de meeste methoden, hier wordt de data verwerkt.
 * @author Jordii
 */
public class VirusLogica {

    /**
     * Declaratie en in meeste gevallen ook initialisatie van verschillende soorten variabelen
     * die worden gebruikt om de data op een zo goed mogelijke manier te verwerken.
     */
    
    public static ArrayList<Virus> virusList = new ArrayList<>();
    public ArrayList<Integer> virusIDs = new ArrayList<>();
    public static HashMap<String, ArrayList<Virus>> virusMap = new HashMap<>();
    public HashMap<String, ArrayList<Virus>> newVirusMap = new HashMap<>();
    public ArrayList<String> allHosts = new ArrayList<>();
    public static ArrayList<String> hosts = new ArrayList<>(); 
    public static String selectedHost1;
    
    int virusID;
    String soort;
    int hostID;
    ArrayList hostList;
    String korteClassificatie;
    String classificatie;
    String hostNameAndID;  

    /**
     * Deze methode deelt elk virus in in één van de 8 categorieën.
     * @param classificatie
     * @return 
     */    
    
    public String bepaalClassificatie(String classificatie){
        classificatie = classificatie.toLowerCase();
        if (classificatie.matches(".*ssdna.*")){
            korteClassificatie = "ssDNA";          
        } else if (classificatie.matches(".*ssrna.*")){
            korteClassificatie = "ssRNA";
        } else if (classificatie.matches(".*dsdna.*")){
            korteClassificatie = "dsDNA";
        } else if (classificatie.matches(".*dsrna")){
            korteClassificatie = "dsRNA";
        } else if (classificatie.matches(".*retro.*")){
            korteClassificatie = "Retro Viruses";
        } else if (classificatie.matches(".*satellite.*|.*virophage.*")){
            korteClassificatie = "Satellites & Virophages";
        } else if (classificatie.matches(".*viroid.*")){
            korteClassificatie = "Viroids";
        } else {
            korteClassificatie = "Other";
        }
        
        return korteClassificatie;
    }

    /**
     * Deze methode zorgt ervoor dat er wordt gekeken of een Virus al reeds bekend is.
     * Als dit het geval is, wordt via findVirus naar dit virus gezocht, en wordt de host
     * aan de hostList van dat virus toegevoegd.
     * Als dit niet het geval is, wordt het virus in z'n geheel aangemaakt.
     * @param lineData
     * @param korteClassificatie
     */
    
    public void virusChecker(String[] lineData, String korteClassificatie){
        virusID = Integer.parseInt(lineData[0]);
        hostID = Integer.parseInt(lineData[7]);
        hostNameAndID = (Integer.toString(hostID) + " (" + lineData[8] + ")");
        ArrayList hostList = new ArrayList();
        
        if (virusIDs.contains(virusID)){
            findVirus(virusID).getHostList().add(hostID);
        }
        else {
            soort = lineData[1];
            classificatie = lineData[2];
            classificatie = bepaalClassificatie(classificatie);
            hostList.add(hostID);
            virusIDs.add(virusID);
            Virus virus = new Virus(virusID, soort, hostList, classificatie);
            virusList.add(virus);         
        }      
    }

    /**
     * Deze methode zorgt ervoor dat er wordt gekeken of een host al reeds bekend is.
     * Als dit het geval is, wordt het virus toegevoegd aan de arraylist(virus) value van de 
     * hashmap. Als de host nog niet bekend is, wordt deze aangemaakt.
     */
    
    public void hostChecker(){
        hostList = findHostList(virusID);
        Virus virus = new Virus(virusID, soort, hostList, classificatie);
        if (virusMap.containsKey(hostNameAndID)){
            ArrayList correspondingViruses = virusMap.get(hostNameAndID);
            correspondingViruses.add(virus);
        }
        else {
            ArrayList correspondingViruses = new ArrayList<>();
            correspondingViruses.add(virus);
            virusMap.put(hostNameAndID, correspondingViruses);
        }
    }
    
    /**
     * Als een virus al bekend is, wordt er via deze methode gezocht waar in de virusList dit
     * virus staat. De host van het virus kan hier dan aan worden toegevoegd.
     * @param currentID
     * @return 
     */   
    
    public Virus findVirus(int currentID){
        Virus currentVirus = null;
        for (Virus v : virusList){
            if (currentID == v.getID()){
                currentVirus = v;
                break; 
            }
        }
           return currentVirus;
    }

    /**
     * Deze methode zorgt ervoor dat er in de methode hostChecker naar de juiste hostlist kan
     * worden gezocht. 
     * @param currentID
     * @return lijst met de huidige hostlist
     */    
    
    public ArrayList findHostList(int currentID){
        ArrayList currentHostList = null;
        for (Virus v: virusList){
            if (v.getID() == currentID){
                currentHostList = v.getHostList();
            }
        }        
        return currentHostList;
    }

    /**
     * In deze methode wordt een lijst met alle hosts geretourneerd zodat de hosts aan de 
     * combobox kunnen worden toegevoegd.
     * @return lijst met alle hosts
     */
    
    public ArrayList<String> createAllHosts(){      
        virusMap.keySet().stream().forEach((host) -> {
            hosts.add((String) host);
        });   
        
        newVirusMap = virusMap;
         
        return hosts;  
    }

    /**
     * De methodes createVirusList1 en createVirusList2 zorgen ervoor dat op basis van de
     * gekozen hosts van de gebruiker, de juiste viruslijsten worden gerourneerd, zodat deze
     * kunnen worden afgebeeld in de GUI.
     * @param newVirusMap
     * @param selectedHost1
     * @return lijsten met de virussen van de door gebruiker ingevulde hosts
     */
    
    public ArrayList createVirusList1(HashMap newVirusMap, String selectedHost1){
        ArrayList virusList1 = (ArrayList) virusMap.get(selectedHost1);

        return virusList1;
    }

    public ArrayList createVirusList2(HashMap newVirusMap, String selectedHost2){
        ArrayList virusList2 = (ArrayList) virusMap.get(selectedHost2);

        return virusList2;
    }  

    /**
     * Deze methode vergelijkt beide viruslijsten met elkaar retourneert een arraylist met
     * de overeenkomsten, zodat deze kan worden weergegeven in de GUI.
     * @param viruses1
     * @param viruses2
     * @return lijst met overeenkomsten
     */
    
    public ArrayList compareLists(ArrayList viruses1, ArrayList viruses2){
        ArrayList overeenkomst = new ArrayList();
        viruses1.stream().filter((virus) -> (viruses2.contains(virus))).forEach((virus) -> {
            overeenkomst.add(virus);
        });
        return overeenkomst;
    }

    /**
     * Deze methode sorteert virussen op basis van ID.
     * @param aList
     * @return lijst gesorteerd op basis van ID
     */
    
    public ArrayList sortedByID(ArrayList aList){
        Collections.sort(aList);
        
        return aList;
    }

    /**
     * De methodes fillIDList1&2 en fillIDovereenkomsten zorgen ervoor dat de lijsten wordt gevuld met de virussen van 
     * de gekozen hosts. Ook worden deze gesorteerd op basis van ID.
     * @param viruses1
     * @return lijsten met de IDs van door gebruiker gekozen hosts
     */
    
    public ArrayList<Integer> fillIDList1(ArrayList<Virus> viruses1){
        ArrayList<Integer> IDs = new ArrayList();
        viruses1.stream().map((virus) -> {
            IDs.add(virus.getID());
            return virus;
        }).forEach((_item) -> {
            Collections.sort(IDs);
        });
        return IDs;
    }
    
    public ArrayList<Integer> fillIDList2(ArrayList<Virus> viruses2){
        ArrayList<Integer> IDs = new ArrayList();
        viruses2.stream().map((virus) -> {
            IDs.add(virus.getID());
            return virus;
        }).forEach((_item) -> {
            Collections.sort(IDs);
        });
        return IDs;
    }
    
    public ArrayList<Integer> fillIDOvereenkomst(ArrayList<Virus> overeenkomstLijst){
        ArrayList<Integer> IDs = new ArrayList();
        overeenkomstLijst.stream().map((virus) -> {
            IDs.add(virus.getID());
            return virus;
        }).forEach((_item) -> {
            Collections.sort(IDs);
        });
        return IDs;
    }    
    

}
