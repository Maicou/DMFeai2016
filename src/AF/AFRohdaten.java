/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AF;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marco Mancuso
 */
public class AFRohdaten {

    ArrayList<AFKunde> KundenListe = new ArrayList<AFKunde>();

    public ArrayList<AFKunde> getKundenListe() {
        return KundenListe;
    }

    public AFRohdaten() {

        try {
            String csvFile = "./src/AF/Messung.csv";
            BufferedReader br = null;
            String Words = "";

            String StringSplitBy = ",";
            String space = " ";
            ArrayList<String> CleanedList = new ArrayList<String>();

            br = new BufferedReader(new FileReader(csvFile));
            while ((Words = br.readLine()) != null) {

                String[] messung = Words.split(StringSplitBy);
                String[] SeparatedStrings;
                int numOfStrings = messung.length;
                for (int i = 0; i < numOfStrings; i++) {

                    SeparatedStrings = messung[i].split(space);

                    for (int j = 0; j < SeparatedStrings.length; j++) {

                        CleanedList.add(SeparatedStrings[j]);
                    }

                }

                AFKundenDaten TestDaten = new AFKundenDaten(CleanedList);
                if (TestDaten.ID == null) {

                } else {
                    AFKunde Kunde = new AFKunde(TestDaten);
                    KundenListe.add(Kunde);

                }
                CleanedList.removeAll(CleanedList);

            }
            AFKunde Ende = new AFKunde("Ende", "der", "Kunden", -1, null, null, null);
            KundenListe.add(Ende);
            System.out.println("KUNDEN AUS AF - - - - - - - - - - - - - - - -");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(AFRohdaten.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AFRohdaten.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
