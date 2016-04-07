/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmfeai2016;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.ws.Holder;

/**
 *
 * @author marcomancuso
 */
public class Main {

    private static void holeKunde(java.lang.String queryVorname, java.lang.String queryNachname, javax.xml.ws.Holder<java.lang.Integer> kid, javax.xml.ws.Holder<java.lang.String> vorname, javax.xml.ws.Holder<java.lang.String> nachname, javax.xml.ws.Holder<java.lang.String> strasse, javax.xml.ws.Holder<java.lang.String> plzStadt, javax.xml.ws.Holder<java.lang.String> kundenart) {
        ch.fhnw.wi.eai.mwb.MWBService service = new ch.fhnw.wi.eai.mwb.MWBService();
        ch.fhnw.wi.eai.mwb.MWB port = service.getMWBPort();
        port.holeKunde(queryVorname, queryNachname, kid, vorname, nachname, strasse, plzStadt, kundenart);
    }

    private static void holeMessgeraet(int queryMessID, javax.xml.ws.Holder<java.lang.Integer> messID, javax.xml.ws.Holder<java.lang.Integer> kid, javax.xml.ws.Holder<java.lang.String> messgegenstand, javax.xml.ws.Holder<java.lang.Float> wert, javax.xml.ws.Holder<java.lang.String> ausfuehrung, javax.xml.ws.Holder<java.lang.String> tarifplan) {
        ch.fhnw.wi.eai.mwb.MWBService service = new ch.fhnw.wi.eai.mwb.MWBService();
        ch.fhnw.wi.eai.mwb.MWB port = service.getMWBPort();
        port.holeMessgeraet(queryMessID, messID, kid, messgegenstand, wert, ausfuehrung, tarifplan);
    }

    private static java.util.List<java.lang.String> listeKundeNachname() {
        ch.fhnw.wi.eai.mwb.MWBService service = new ch.fhnw.wi.eai.mwb.MWBService();
        ch.fhnw.wi.eai.mwb.MWB port = service.getMWBPort();
        return port.listeKundeNachname();
    }

    private static java.util.List<java.lang.Integer> listeMessID() {
        ch.fhnw.wi.eai.mwb.MWBService service = new ch.fhnw.wi.eai.mwb.MWBService();
        ch.fhnw.wi.eai.mwb.MWB port = service.getMWBPort();
        return port.listeMessID();
    }

    private static java.util.List<java.lang.Integer> listeMessIDForCustomer(int queryKID) {
        ch.fhnw.wi.eai.mwb.MWBService service = new ch.fhnw.wi.eai.mwb.MWBService();
        ch.fhnw.wi.eai.mwb.MWB port = service.getMWBPort();
        return port.listeMessIDForCustomer(queryKID);
    }

    private static void printKunde() {
        ch.fhnw.wi.eai.mwb.MWBService service = new ch.fhnw.wi.eai.mwb.MWBService();
        ch.fhnw.wi.eai.mwb.MWB port = service.getMWBPort();
        port.printKunde();
    }

    private static void printMessgeraete() {
        ch.fhnw.wi.eai.mwb.MWBService service = new ch.fhnw.wi.eai.mwb.MWBService();
        ch.fhnw.wi.eai.mwb.MWB port = service.getMWBPort();
        port.printMessgeraete();
    }

    public static void main(String[] args) {
        // holeKunde(queryVorname,queryNachname,kid,vorname,nachname,strasse,plzStadt,kundenart);
        List<String> kundeNachname = new ArrayList();
        kundeNachname = listeKundeNachname();
        System.out.println("Alle Customer Nachnamen " + kundeNachname);
        int numberOfCustomer = kundeNachname.size();

        List<Integer> messID = new ArrayList();
        messID = listeMessID();
        System.out.println("Alle MessIDs " + messID);

        System.out.println("Anzahl Customer: " + numberOfCustomer);

        List<Integer> messIdForCustomer = new ArrayList();
        for (int i = 1; i <= numberOfCustomer; i++) {
            messIdForCustomer = listeMessIDForCustomer(i);
            System.out.println("Messids für Customer " + i + " " + messIdForCustomer);
        }

        //Mueller ist hier ein Test-Query
        String queryVorname = null;
        String queryNachname = "Mueller";
        Holder<Integer> kid = new Holder();
        Holder<String> vorname = new Holder();
        Holder<String> nachname = new Holder();
        Holder<String> strasse = new Holder();
        Holder<String> plzStadt = new Holder();
        Holder<String> kundenart = new Holder();
        holeKunde(queryVorname, queryNachname, kid, vorname, nachname, strasse, plzStadt, kundenart);
        System.out.println(vorname.value);

        //MessID 1 ist hier ein Testquery
        int queryMessID = 1;
        Holder<Integer> messID2 = new Holder();
        Holder<Integer> kid2 = new Holder();
        Holder<String> messgegenstand = new Holder();
        Holder<Float> wert = new Holder();
        Holder<String> ausfuehrung = new Holder();
        Holder<String> tarifplan = new Holder();
        holeMessgeraet(queryMessID, messID2, kid, messgegenstand, wert, ausfuehrung, tarifplan);
        System.out.println(messgegenstand.value);

        //Diese zwei Methoden verstehe ich noch nicht was die sollen
        printKunde();
        printMessgeraete();

        //CSV Datei einlesen und splitten
        String csvFile = "./src/AF/Messung.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] messung = line.split(cvsSplitBy);
                int numOfColumns = messung.length;
                for (int i = 0; i < numOfColumns; i++) {
                    System.out.println(messung[i]);
                }
                System.out.println("\n");

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
