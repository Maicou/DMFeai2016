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
public class Kunde {
    
    String queryVorname;
    String queryNachname;
    Holder<Integer> kid = new Holder();
    Holder<String> vorname = new Holder();
    Holder<String> nachname = new Holder();
    Holder<String> strasse = new Holder();
    Holder<String> plzStadt = new Holder();
    Holder<String> kundenart = new Holder();

    public Kunde(String queryNachname) {

        this.queryVorname = queryVorname;
        this.queryNachname = queryNachname;
        this.kid = kid;
        this.vorname=vorname;
        this.nachname=nachname;
        this.strasse=strasse;
        this.plzStadt=plzStadt;
        this.kundenart=kundenart;
        holeKunde(queryVorname, queryNachname, kid, vorname, nachname, strasse, plzStadt, kundenart);
    }

    public String getQueryVorname() {
        return queryVorname;
    }

    public String getQueryNachname() {
        return queryNachname;
    }

    public Holder<Integer> getKid() {
        return kid;
    }

    public Holder<String> getVorname() {
        return vorname;
    }

    public Holder<String> getNachname() {
        return nachname;
    }

    public Holder<String> getStrasse() {
        return strasse;
    }

    public Holder<String> getPlzStadt() {
        return plzStadt;
    }

    public Holder<String> getKundenart() {
        return kundenart;
    }

    private static void holeKunde(java.lang.String queryVorname, java.lang.String queryNachname, javax.xml.ws.Holder<java.lang.Integer> kid, javax.xml.ws.Holder<java.lang.String> vorname, javax.xml.ws.Holder<java.lang.String> nachname, javax.xml.ws.Holder<java.lang.String> strasse, javax.xml.ws.Holder<java.lang.String> plzStadt, javax.xml.ws.Holder<java.lang.String> kundenart) {
        ch.fhnw.wi.eai.mwb.MWBService service = new ch.fhnw.wi.eai.mwb.MWBService();
        ch.fhnw.wi.eai.mwb.MWB port = service.getMWBPort();
        port.holeKunde(queryVorname, queryNachname, kid, vorname, nachname, strasse, plzStadt, kundenart);
    }

//    private static java.util.List<java.lang.String> listeKundeNachname() {
//        ch.fhnw.wi.eai.mwb.MWBService service = new ch.fhnw.wi.eai.mwb.MWBService();
//        ch.fhnw.wi.eai.mwb.MWB port = service.getMWBPort();
//        return port.listeKundeNachname();
//    }

    @Override
    public String toString() {
        return "kid=" + kid.value + "\n" + "vorname=" + vorname.value + "\n" +"nachname=" + nachname.value + "\n" + "strasse=" + strasse.value + "\n" + "plzStadt=" + plzStadt.value + "\n" + "kundenart=" + kundenart.value + "\n" + "_________________________"+ "\n";
    }
    
    
    

}
