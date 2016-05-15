/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MWB;

import javax.xml.ws.Holder;

/**
 *
 * @author marcomancuso
 */
public class Messung {

    int queryMessID;
    Holder<Integer> messID = new Holder();
    Holder<Integer> kid2 = new Holder();
    Holder<String> messgegenstand = new Holder();
    Holder<Float> wert = new Holder();
    Holder<String> ausfuehrung = new Holder();
    Holder<String> tarifplan = new Holder();

    public Messung(int queryMessID) {

        this.queryMessID = queryMessID;
        this.messID = messID;
        this.kid2 = kid2;
        this.messgegenstand = messgegenstand;
        this.wert = wert;
        this.ausfuehrung = ausfuehrung;
        this.tarifplan = tarifplan;
        holeMessgeraet(queryMessID, messID, kid2, messgegenstand, wert, ausfuehrung, tarifplan);

    }

    private static void holeMessgeraet(int queryMessID, javax.xml.ws.Holder<java.lang.Integer> messID, javax.xml.ws.Holder<java.lang.Integer> kid, javax.xml.ws.Holder<java.lang.String> messgegenstand, javax.xml.ws.Holder<java.lang.Float> wert, javax.xml.ws.Holder<java.lang.String> ausfuehrung, javax.xml.ws.Holder<java.lang.String> tarifplan) {
        ch.fhnw.wi.eai.mwb.MWBService service = new ch.fhnw.wi.eai.mwb.MWBService();
        ch.fhnw.wi.eai.mwb.MWB port = service.getMWBPort();
        port.holeMessgeraet(queryMessID, messID, kid, messgegenstand, wert, ausfuehrung, tarifplan);
    }

    public int getQueryMessID() {
        return queryMessID;
    }

    public Holder<Integer> getMessID2() {
        return messID;
    }

    public Holder<Integer> getKid2() {
        return kid2;
    }

    public Holder<String> getMessgegenstand() {
        return messgegenstand;
    }

    public Holder<Float> getWert() {
        return wert;
    }

    public Holder<String> getAusfuehrung() {
        return ausfuehrung;
    }

    public Holder<String> getTarifplan() {
        return tarifplan;
    }

    @Override
    public String toString() {
        return "messID=" + messID.value + "\n" + "kid2=" + kid2.value + "\n" + "messgegenstand=" + messgegenstand.value + "\n" + "wert=" + wert.value + "\n" + "ausfuehrung=" + ausfuehrung.value + "\n" + "tarifplan=" + tarifplan.value + "\n" + "_________________________" + "\n";
    }

}
