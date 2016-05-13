/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Zielsystem;

import MWB.Kunde;
import MWB.Messung;
import java.util.ArrayList;

/**
 *
 * @author Marco Mancuso
 */
public class Matching {

    private ArrayList<MWB.Kunde> MWBKunden;
    private ArrayList<AF.Kunde> AFKunden;
    public ArrayList<Messpunkt> Messpunkte;

    public Matching(ArrayList<Kunde> MWBKunden, ArrayList<AF.Kunde> AFKunden) {
        this.MWBKunden = MWBKunden;
        this.AFKunden = AFKunden;
        kreiereFirmen();
        Messpunkte = erstelleMessungen();
        System.out.println(Messpunkte.toString());
    }

    public void kreiereFirmen() {
        Firma MWB = new Firma(1, "MWB", "Riggenbachstrasse 12", "4600", "Olten");
        Firma AF = new Firma(2, "AF", "Riggenbachstrasse 11", "4600", "Olten");
    }

    /**
     *
     * @return die NamenListen
     */
  

    public ArrayList<Messpunkt> erstelleMessungen() {
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

}
