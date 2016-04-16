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
public class Maessgeraet {
    
        int queryMessID;
        Holder<Integer> messID2 = new Holder();
        Holder<Integer> kid2 = new Holder();
        Holder<String> messgegenstand = new Holder();
        Holder<Float> wert = new Holder();
        Holder<String> ausfuehrung = new Holder();
        Holder<String> tarifplan = new Holder();

    public Maessgeraet() {
        
        this.queryMessID = queryMessID;
        holeMessgeraet(queryMessID, messID2, kid2, messgegenstand, wert, ausfuehrung, tarifplan);
        
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
        return messID2;
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
        return "Maessgeraet{" + "queryMessID=" + queryMessID + ", messID2=" + messID2.value + ", kid2=" + kid2.value + ", messgegenstand=" + messgegenstand.value + ", wert=" + wert.value + ", ausfuehrung=" + ausfuehrung.value + ", tarifplan=" + tarifplan.value + '}';
    }
        
        
    
    
    
}
