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
public class AFMatchingKunden {

    public ArrayList<AFKunde> getKundenListeBereinigt() {
        return KundenListeBereinigt;
    }

    public ArrayList<AFKunde> KundenListeBereinigt = new ArrayList<AFKunde>();

    public AFMatchingKunden() {

        AFRohdaten NewData = new AFRohdaten();
        KundenListeBereinigt = zusammenfuehren(NewData.getKundenListe());
        System.out.println(KundenListeBereinigt.toString());

    }

    private ArrayList<AFKunde> zusammenfuehren(ArrayList<AFKunde> KundenListe) {

        ArrayList<AFKunde> KundenListeBereinigt = new ArrayList<AFKunde>();
        double Wert = KundenListe.get(0).getWert();
        for (int i = 1; i < KundenListe.size(); i++) {

            if ((KundenListe.get(i).getVorname().equals(KundenListe.get(i - 1).getVorname()))
                    && (KundenListe.get(i).getNachname().equals(KundenListe.get(i - 1).getNachname()))) {
                Wert = Wert + KundenListe.get(i).getWert();

            } else if (KundenListe.get(i).getVorname() != KundenListe.get(i - 1).getVorname()) {
                AFKunde neu = new AFKunde(KundenListe.get(i - 1).getVorname(), KundenListe.get(i - 1).getNachname(),
                        KundenListe.get(i - 1).getMessgegenstand(), Wert, KundenListe.get(i - 1).getDatum(),
                        KundenListe.get(i - 1).getGerätetyp(), KundenListe.get(i - 1).getAusführung());
                KundenListeBereinigt.add(neu);
                Wert = KundenListe.get(i).getWert();
            }

        }

        return KundenListeBereinigt;
    }

}
