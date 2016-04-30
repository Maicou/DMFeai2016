/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AF;

/**
 *
 * @author Marco Mancuso
 */
public class Kunde {
    
    
    String ID;
    String Vorname;
    String Nachname;
    String Messgegenstand;
    String Wert;
    String Datum;
    String Gerätetyp;
    String Ausführung;

    public Kunde(AFKundenDaten TestDaten) {
        this.ID = TestDaten.ID;
        this.Vorname = TestDaten.Vorname;
        this.Nachname = TestDaten.Nachname;
        this.Messgegenstand = TestDaten.Messgegenstand;
        this.Wert = TestDaten.Wert;
        this.Datum = TestDaten.Datum;
        this.Gerätetyp = TestDaten.Gerätetyp;
        this.Ausführung = TestDaten.Ausführung;
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
        return "ID=" + ID+ "\n" + "Vorname=" + Vorname + "\n" + "Nachname=" + Nachname + "\n" + "Messgegenstand=" + Messgegenstand + "\n" + "Wert=" + Wert+ "\n" + "Datum=" + Datum + "\n"+ "Ger\u00e4tetyp=" + Gerätetyp+ "\n" + "Ausf\u00fchrung=" + Ausführung+ "\n" + "_________________________"+ "\n";
    }
    
    
    
    
    
    
}
