/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MWB;

import java.util.ArrayList;
import java.util.List;
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
   
    List ListeMitZuteilung;
    ArrayList<Messung> ALLEMESSUNGEN;
    ArrayList<Messung> MessungenDesKunden = new ArrayList<Messung>();

    public Kunde(String queryNachname, ArrayList<Messung> messungen) {

        this.queryVorname = queryVorname;
        this.queryNachname = queryNachname;
        this.kid = kid;
        this.vorname=vorname;
        this.nachname=nachname;
        this.strasse=strasse;
        this.plzStadt=plzStadt;
        this.kundenart=kundenart;
        
       holeKunde(queryVorname, queryNachname, kid, vorname, nachname, strasse, plzStadt, kundenart);
       ListeMitZuteilung = listeMessIDForCustomer(this.kid.value);
       ALLEMESSUNGEN = messungen;
       
        for (int j = 0; j < ListeMitZuteilung.size(); j++) {
            for (int i = 0; i < ALLEMESSUNGEN.size(); i ++){
                if (ListeMitZuteilung.get(j)==(ALLEMESSUNGEN.get(i).messID.value)){
                    MessungenDesKunden.add(ALLEMESSUNGEN.get(i));
                }
            }
            
        }
       
       
       
    
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

    public ArrayList<Messung> getMessungenDesKunden() {
        return MessungenDesKunden;
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
        return "kid=" + kid.value + "\n" + "vorname=" + vorname.value + "\n" +"nachname=" + nachname.value + "\n" + "strasse=" + strasse.value + "\n" + "plzStadt=" + plzStadt.value + "\n" + "kundenart=" + kundenart.value + "\n" +"Meine Messungen = " + MessungenDesKunden.size() + "\n" + "_________________________"+ "\n";
    }

    private static java.util.List<java.lang.String> listeKundeNachname() {
        ch.fhnw.wi.eai.mwb.MWBService service = new ch.fhnw.wi.eai.mwb.MWBService();
        ch.fhnw.wi.eai.mwb.MWB port = service.getMWBPort();
        return port.listeKundeNachname();
    }

    private static java.util.List<java.lang.Integer> listeMessIDForCustomer(int queryKID) {
        ch.fhnw.wi.eai.mwb.MWBService service = new ch.fhnw.wi.eai.mwb.MWBService();
        ch.fhnw.wi.eai.mwb.MWB port = service.getMWBPort();
        return port.listeMessIDForCustomer(queryKID);
    }
    
    
    

}
