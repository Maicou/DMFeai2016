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
public class AFKundenDaten {

    String ID;
    String Vorname;
    String Nachname1;
    String Nachname2;
    String Nachname;
    String Messgegenstand;
    String Wert;
    String Datum;
    String Gerätetyp;
    String Ausführung;

    public AFKundenDaten(ArrayList<String> Liste) {
      

        if(Liste.size()< 8){
           
        } else if(Liste.size() == 8){

        this.ID = Liste.get(0);
        this.Vorname = Liste.get(1);
        this.Nachname1 = Liste.get(2);
       
        this.Nachname = Nachname1;
        this.Messgegenstand = Liste.get(3);
        this.Wert = Liste.get(4);
        this.Datum = Liste.get(5);
        this.Gerätetyp = Liste.get(6);
        this.Ausführung = Liste.get(7);
            
        } else if(Liste.size()>8){

        this.ID = Liste.get(0);
        this.Vorname = Liste.get(1);
        this.Nachname1 = Liste.get(2);
        this.Nachname2 = Liste.get(3);
        this.Nachname = Nachname1 +" " + Nachname2;
        this.Messgegenstand = Liste.get(4);
        this.Wert = Liste.get(5);
        this.Datum = Liste.get(6);
        this.Gerätetyp = Liste.get(7);
        this.Ausführung = Liste.get(8);
        }

    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getVorname() {
        return Vorname;
    }

    public void setVorname(String Vorname) {
        this.Vorname = Vorname;
    }

    public String getNachname1() {
        return Nachname1;
    }

    public void setNachname1(String Nachname1) {
        this.Nachname1 = Nachname1;
    }

    public String getNachname2() {
        return Nachname2;
    }

    public void setNachname2(String Nachname2) {
        this.Nachname2 = Nachname2;
    }

    public String getNachname() {
        return Nachname;
    }

    public void setNachname(String Nachname) {
        this.Nachname = Nachname;
    }

    public String getMessgegenstand() {
        return Messgegenstand;
    }

    public void setMessgegenstand(String Messgegenstand) {
        this.Messgegenstand = Messgegenstand;
    }

    public String getWert() {
        return Wert;
    }

    public void setWert(String Wert) {
        this.Wert = Wert;
    }

    public String getDatum() {
        return Datum;
    }

    public void setDatum(String Datum) {
        this.Datum = Datum;
    }

    public String getGerätetyp() {
        return Gerätetyp;
    }

    public void setGerätetyp(String Gerätetyp) {
        this.Gerätetyp = Gerätetyp;
    }

    public String getAusführung() {
        return Ausführung;
    }

    public void setAusführung(String Ausführung) {
        this.Ausführung = Ausführung;
    }

    @Override
    public String toString() {
        return "AFKundenDaten{" + "ID=" + ID + ", Vorname=" + Vorname + ", Nachname1=" + Nachname1 + ", Nachname2=" + Nachname2 + ", Nachname=" + Nachname + ", Messgegenstand=" + Messgegenstand + ", Wert=" + Wert + ", Datum=" + Datum + ", Ger\u00e4tetyp=" + Gerätetyp + ", Ausf\u00fchrung=" + Ausführung + '}';
    }

  

}
