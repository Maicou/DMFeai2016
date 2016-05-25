/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmfeai2016;

import AF.AFMatchingKunden;
import MWB.MWBKunde;
import MWB.MWBMessung;
import Zielsystem.ZielSysMatching;
import java.util.ArrayList;
import java.util.List;

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

    public static void main(String[] args) {
        List<String> kundeNachname = new ArrayList();
        kundeNachname = listeKundeNachname();
        ArrayList<MWBKunde> AlleKunden = new ArrayList();
        ArrayList<MWBMessung> AlleMessgeraete = new ArrayList();
        List<Integer> messIDs = new ArrayList();
        messIDs = listeMessID();
        for (int i = 1; i <= messIDs.size(); i++) {
            MWBMessung Messgeraet = new MWBMessung(i);
            AlleMessgeraete.add(Messgeraet);
        }
        List<Integer> messIdForCustomer = new ArrayList();
        for (int i = 1; i <= kundeNachname.size(); i++) {
            messIdForCustomer = listeMessIDForCustomer(i);

        }

        for (int i = 0; i < kundeNachname.size(); i++) {
            MWBKunde KundeMWB = new MWBKunde(kundeNachname.get(i), AlleMessgeraete);

            String Name = KundeMWB.getVorname().value + " " + KundeMWB.getNachname().value;
            if (Name.contains("AG") || Name.contains("GmbH")) {
                continue;
            }

            AlleKunden.add(KundeMWB);
        }
        System.out.println("KUNDEN AUS MWB - - - - - - - - - - - - - - - -");
        System.out.println(AlleKunden.toString());
        System.out.println("\nMESSUNGEN AUS MWB - - - - - - - - - - - - - - - -");
        System.out.println(AlleMessgeraete.toString());
        AFMatchingKunden startMatching = new AFMatchingKunden();
        ZielSysMatching Test = new ZielSysMatching(AlleKunden, startMatching.getKundenListeBereinigt());

    }
}
