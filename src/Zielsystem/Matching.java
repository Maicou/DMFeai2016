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

    public Matching(ArrayList<Kunde> MWBKunden, ArrayList<AF.Kunde> AFKunden) {
        this.MWBKunden = MWBKunden;
        this.AFKunden = AFKunden;
        kreiereFirmen();
    }

    
    
    
    public void kreiereFirmen(){
    Firma MWB = new Firma(1, "MWB", "Riggenbachstrasse 12", "4600", "Olten");
    Firma AF = new Firma(2, "AF", "Riggenbachstrasse 11", "4600", "Olten");
    }
    
    
    
}
