/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AF;

import java.util.ArrayList;

/**
 *
 * @author Marco Mancuso
 */
public class MatchingKundenAF {

    public ArrayList<Kunde> getKundenListeBereinigt() {
        return KundenListeBereinigt;
    }

    public ArrayList<Kunde> KundenListeBereinigt = new ArrayList<Kunde>();

    public MatchingKundenAF() {

        AFdaten NewData = new AFdaten();
        KundenListeBereinigt = zusammenfuehren(NewData.getKundenListe());
        System.out.println(KundenListeBereinigt.toString());

    }

    private ArrayList<Kunde> zusammenfuehren(ArrayList<Kunde> KundenListe) {

        ArrayList<Kunde> KundenListeBereinigt = new ArrayList<Kunde>();
        double Wert = KundenListe.get(0).getWert();
        for (int i = 1; i < KundenListe.size(); i++) {

            if ((KundenListe.get(i).getVorname().equals(KundenListe.get(i - 1).getVorname()))
                    && (KundenListe.get(i).getNachname().equals(KundenListe.get(i - 1).getNachname()))) {
                Wert = Wert + KundenListe.get(i).getWert();

            } else if (KundenListe.get(i).getVorname() != KundenListe.get(i - 1).getVorname()) {
                Kunde neu = new Kunde(KundenListe.get(i - 1).getVorname(), KundenListe.get(i - 1).getNachname(),
                        KundenListe.get(i - 1).getMessgegenstand(), Wert, KundenListe.get(i - 1).getDatum(),
                        KundenListe.get(i - 1).getGerätetyp(), KundenListe.get(i - 1).getAusführung());
                KundenListeBereinigt.add(neu);
                Wert = KundenListe.get(i).getWert();
            }

        }

        return KundenListeBereinigt;
    }

}
