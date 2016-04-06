/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MWB;

/**
 *
 * @author marcomancuso
 */
public class ServiceLocator {

    private static ServiceLocator serviceLocator;

    private ServiceLocator() {
    }    

    public static ServiceLocator getServiceLocator() {
        if (serviceLocator == null) {
            serviceLocator = new ServiceLocator();
        }

        return serviceLocator;
    }
//Methoden aus WSDL

    /**
     *
     */
    public void HoleListeKunden(){
        listeKundeNachname();
    }
    
    
    private static void holeKunde(java.lang.String queryVorname, java.lang.String queryNachname, javax.xml.ws.Holder<java.lang.Integer> kid, javax.xml.ws.Holder<java.lang.String> vorname, javax.xml.ws.Holder<java.lang.String> nachname, javax.xml.ws.Holder<java.lang.String> strasse, javax.xml.ws.Holder<java.lang.String> plzStadt, javax.xml.ws.Holder<java.lang.String> kundenart) {
        ch.fhnw.wi.eai.mwb.MWBService service = new ch.fhnw.wi.eai.mwb.MWBService();
        ch.fhnw.wi.eai.mwb.MWB port = service.getMWBPort();
        port.holeKunde(queryVorname, queryNachname, kid, vorname, nachname, strasse, plzStadt, kundenart);
    }

    private static java.util.List<java.lang.String> listeKundeNachname() {
        ch.fhnw.wi.eai.mwb.MWBService service = new ch.fhnw.wi.eai.mwb.MWBService();
        ch.fhnw.wi.eai.mwb.MWB port = service.getMWBPort();
        return port.listeKundeNachname();
    }

    
    
    
    
    
    
    
    
    
}
