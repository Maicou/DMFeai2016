/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Zielsystem;

import MWB.MWBKunde;
import MWB.MWBMessung;
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
public class ZielSysMatching {

    private ArrayList<MWB.MWBKunde> MWBKunden;
    private ArrayList<AF.AFKunde> AFKunden;
    public ArrayList<ZielSysMesspunkt> MesspunkteMWB;
    public ArrayList<ZielSysMesspunkt> MesspunkteAF;
    public ArrayList<ZielSysFirma> Firmen = new ArrayList<ZielSysFirma>();

    public ZielSysMatching(ArrayList<MWBKunde> MWBKunden, ArrayList<AF.AFKunde> AFKunden) {
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
            Logger.getLogger(ZielSysMatching.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void kreiereFirmen() {
        ZielSysFirma MWB = new ZielSysFirma(1, "MWB", "Riggenbachstrasse 12", "4600", "Olten");
        Firmen.add(MWB);
        ZielSysFirma AF = new ZielSysFirma(2, "AF", "Riggenbachstrasse 11", "4600", "Olten");
        Firmen.add(AF);

    }

    /**
     *
     * @return die NamenListen
     */
    public ArrayList<ZielSysMesspunkt> erstelleMessungenMWB() {
        ArrayList<ZielSysMesspunkt> ListeMitMessungen = new ArrayList<ZielSysMesspunkt>();
        String Geraetetyp;
        String Name;
        String Adresse;
        ArrayList<MWBMessung> Liste;

        for (MWB.MWBKunde Kunde : MWBKunden) {
            Liste = Kunde.getMessungenDesKunden();
            for (int i = 0; i < Liste.size(); i++) {
                if (Liste.get(i).getMessgegenstand().value.contentEquals("Wasser")) {
                    continue;
                }
                Geraetetyp = Liste.get(i).getAusfuehrung().value;
                Name = Kunde.getVorname().value + " " + Kunde.getNachname().value;
                Adresse = Kunde.getStrasse().value + " " + Kunde.getPlzStadt().value;
                ZielSysMesspunkt messpunkt = new ZielSysMesspunkt(1, Geraetetyp, Liste.get(i).getWert().value, Liste.get(i).getTarifplan().value, Name, Adresse);
                ListeMitMessungen.add(messpunkt);
            }
        }
        return ListeMitMessungen;
    }

    public ArrayList<ZielSysMesspunkt> erstelleMessungenAF() {
        ArrayList<ZielSysMesspunkt> ListeMitMessungen = new ArrayList<ZielSysMesspunkt>();
        String Geraetetyp = "";
        String Name;
        String Adresse;
        String Tarif;
        double Wert;
        ArrayList<MWBMessung> Liste;

        for (AF.AFKunde Kunde : AFKunden) {

            if (Kunde.getMessgegenstand().contentEquals("Wasser")) {
                continue;
            }

            if (Kunde.getGerätetyp().charAt(2) == 'D') {
                Geraetetyp = "elektronisch";
            } else if (Kunde.getGerätetyp().charAt(2) == 'M') {
                Geraetetyp = "mechanisch";
            }
            Tarif = Kunde.getAusführung();
            Name = Kunde.getVorname() + " " + Kunde.getNachname();
            Adresse = " ";
            Wert = Kunde.getWert() / 1000;
            ZielSysMesspunkt messpunkt = new ZielSysMesspunkt(2, Geraetetyp, Wert, Tarif, Name, Adresse);
            ListeMitMessungen.add(messpunkt);
        }

        return ListeMitMessungen;
    }

    private void printOut() throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter("src/Zielsystem/ZielSysAusgabe.txt", "UTF-8")) {

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
            Logger.getLogger(ZielSysMatching.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
