/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Zielsystem;

import MWB.Kunde;
import MWB.Messung;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marco Mancuso
 */
public class Matching {

    private ArrayList<MWB.Kunde> MWBKunden;
    private ArrayList<AF.Kunde> AFKunden;
    public ArrayList<Messpunkt> MesspunkteMWB;
    public ArrayList<Messpunkt> MesspunkteAF;
    public ArrayList<Firma> Firmen = new ArrayList<Firma>();

    public Matching(ArrayList<Kunde> MWBKunden, ArrayList<AF.Kunde> AFKunden) {
        this.MWBKunden = MWBKunden;
        this.AFKunden = AFKunden;
        kreiereFirmen();
        MesspunkteMWB = erstelleMessungenMWB();
        MesspunkteAF = erstelleMessungenAF();
        System.out.println(MesspunkteMWB.toString());
        System.out.println(MesspunkteAF.toString());
        
        try {
            printOut();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Matching.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void kreiereFirmen() {
        Firma MWB = new Firma(1, "MWB", "Riggenbachstrasse 12", "4600", "Olten");
        Firmen.add(MWB);
        Firma AF = new Firma(2, "AF", "Riggenbachstrasse 11", "4600", "Olten");
        Firmen.add(AF);
       
    }

    /**
     *
     * @return die NamenListen
     */
  

    public ArrayList<Messpunkt> erstelleMessungenMWB() {
        ArrayList<Messpunkt> ListeMitMessungen = new ArrayList<Messpunkt>();
        String Geraetetyp;
        String Name;
        String Adresse;
        ArrayList<Messung> Liste;

        for (MWB.Kunde Kunde : MWBKunden) {
            Liste = Kunde.getMessungenDesKunden();
            for (int i = 0; i < Liste.size(); i++) {
                if (Liste.get(i).getMessgegenstand().value.contentEquals("Wasser")) {
                    continue;
                }
                Geraetetyp = Liste.get(i).getAusfuehrung().value;
                Name = Kunde.getVorname().value + " " + Kunde.getNachname().value;
                Adresse = Kunde.getStrasse().value + " " + Kunde.getPlzStadt().value;
                Messpunkt messpunkt = new Messpunkt(1, Geraetetyp, Liste.get(i).getWert().value, Liste.get(i).getTarifplan().value, Name, Adresse);
                ListeMitMessungen.add(messpunkt);
            }
        }
        return ListeMitMessungen;
    }
    
    
    public ArrayList<Messpunkt> erstelleMessungenAF() {
        ArrayList<Messpunkt> ListeMitMessungen = new ArrayList<Messpunkt>();
        String Geraetetyp = "";
        String Name;
        String Adresse;
        String Tarif;
        double Wert;
        ArrayList<Messung> Liste;
        

        for (AF.Kunde Kunde : AFKunden) {
            
                if (Kunde.getMessgegenstand().contentEquals("Wasser")){
                    continue;
                }

               if(Kunde.getGerätetyp().charAt(2)=='D'){
                   Geraetetyp = "elektronisch";
               }else if(Kunde.getGerätetyp().charAt(2)=='M'){
                   Geraetetyp = "mechanisch";
               }
                Tarif = Kunde.getAusführung();
                Name = Kunde.getVorname() + " " + Kunde.getNachname();
                Adresse = " ";
                Wert = Kunde.getWert()/1000;
                Messpunkt messpunkt = new Messpunkt(2, Geraetetyp, Wert, Tarif, Name, Adresse);
                ListeMitMessungen.add(messpunkt);
            }
        
        return ListeMitMessungen;
    }
    
    
    
    private void printOut() throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter("src/Zielsystem/Ausgabe.txt", "UTF-8")) {

            writer.println("****************Messpunkte****************");
            writer.println("");

            for (int i = 0; i < MesspunkteMWB.size(); i++) {
                writer.println(MesspunkteMWB.get(i).toString());
            }
            for (int i = 0; i < MesspunkteAF.size(); i++) {
                writer.println(MesspunkteAF.get(i).toString());
            }
            writer.println("");
            writer.println("****************FIRMA****************");
            writer.println("");
            for (int i = 0; i < Firmen.size(); i++) {
                writer.println(Firmen.get(i).toString());
            }
            writer.println("");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Matching.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
    
}
