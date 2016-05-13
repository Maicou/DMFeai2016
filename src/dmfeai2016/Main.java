/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmfeai2016;

import AF.AFdaten;
import AF.MatchingKundenAF;
import MWB.Kunde;
import MWB.Messung;
import Zielsystem.Matching;
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
        ArrayList<Kunde> AlleKunden = new ArrayList();
        ArrayList<Messung> AlleMessgeraete = new ArrayList();
        List<Integer> messIDs = new ArrayList();
        messIDs = listeMessID();
        for (int i = 1; i <= messIDs.size(); i++) {
            Messung Messgeraet = new Messung(i);
            AlleMessgeraete.add(Messgeraet);
        }
        List<Integer> messIdForCustomer = new ArrayList();
        for (int i = 1; i <= kundeNachname.size(); i++) {
            messIdForCustomer = listeMessIDForCustomer(i);
           // System.out.println("Messids für Customer "
             //       + // AlleKunden.get(i).getKid().value 
               //     i
                 //   + " " + messIdForCustomer);

        }

        for (int i = 0; i < kundeNachname.size(); i++) {
            Kunde KundeMWB = new Kunde(kundeNachname.get(i), AlleMessgeraete);

            String Name = KundeMWB.getVorname().value + " " + KundeMWB.getNachname().value;
            if (Name.contains("AG") || Name.contains("GmbH")) {
                continue;
            }

            AlleKunden.add(KundeMWB);

        }
        System.out.println("KUNDEN AUS MWB - - - - - - - - - - - - - - - -");
        System.out.println(AlleKunden.toString());
        // int numberOfCustomer = kundeNachname.size();

        System.out.println("Alle MessIDs " + messIDs);

        System.out.println("Anzahl Customer: " + kundeNachname.size());

        System.out.println("\nMESSUNGEN AUS MWB - - - - - - - - - - - - - - - -");
        System.out.println(AlleMessgeraete.toString());

        //Auslagerung csv Datenaufruf in AF package
        //AFdaten NewData = new AFdaten();
        MatchingKundenAF startMatching = new MatchingKundenAF();
        Matching Test = new Matching(AlleKunden, startMatching.KundenListeBereinigt);
        System.out.println(Test.NamenListeMWB.toString());
        System.out.println(Test.NamenListeAF.toString());

    }
}
