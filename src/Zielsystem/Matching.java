/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Zielsystem;

import MWB.Kunde;
import java.util.ArrayList;

/**
 *
 * @author Marco Mancuso
 */
public class Matching {

    private ArrayList<MWB.Kunde> MWBKunden;
    private ArrayList<AF.Kunde> AFKunden;
    public ArrayList<String> NamenListeMWB;
    public ArrayList<String> NamenListeAF;

    public Matching(ArrayList<Kunde> MWBKunden, ArrayList<AF.Kunde> AFKunden) {
        this.MWBKunden = MWBKunden;
        this.AFKunden = AFKunden;
        kreiereFirmen();
        NamenListeMWB = namenMWB();
        NamenListeAF = namenAF();
    }

    public void kreiereFirmen() {
        Firma MWB = new Firma(1, "MWB", "Riggenbachstrasse 12", "4600", "Olten");
        Firma AF = new Firma(2, "AF", "Riggenbachstrasse 11", "4600", "Olten");
    }

    /**
     * 
     * @return die NamenListen 
     */
    public ArrayList<String> namenMWB() {
        ArrayList<String> Namenliste = new ArrayList<String>();
        String Name;
        for (Kunde kunde : MWBKunden) {
            Name = kunde.getVorname().value + " " + kunde.getNachname().value;
            Namenliste.add(Name);
        }
        return Namenliste;
    }
    public ArrayList<String> namenAF() {
        ArrayList<String> Namenliste = new ArrayList<String>();
        String Name;
        for (AF.Kunde kunde : AFKunden) {
            Name = kunde.getVorname() + " " + kunde.getNachname();
            Namenliste.add(Name);
        }

        return Namenliste;
    }
    
    
    
    
    

}
