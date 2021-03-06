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
public class AFKunde {

    private static long Number = 0;
    long ID;
    String Vorname;
    String Nachname;
    String Messgegenstand;
    double Wert;
    String Datum;
    String Gerätetyp;
    String Preisplan;

    public AFKunde(AFKundenDaten TestDaten) {

        this.ID = Number;
        Number++;
        this.Vorname = TestDaten.Vorname;
        this.Nachname = TestDaten.Nachname;
        this.Messgegenstand = TestDaten.Messgegenstand;
        this.Wert = Double.parseDouble(TestDaten.Wert);
        this.Datum = TestDaten.Datum;
        this.Gerätetyp = TestDaten.Gerätetyp;
        this.Preisplan = TestDaten.Ausführung;
    }

    public AFKunde(String Vorname, String Nachname, String Messgegenstand, double Wert, String Datum, String Gerätetyp, String Ausführung) {
        this.ID = Number;
        Number++;
        this.Vorname = Vorname;
        this.Nachname = Nachname;
        this.Messgegenstand = Messgegenstand;
        this.Wert = Wert;
        this.Datum = Datum;
        this.Gerätetyp = Gerätetyp;
        this.Preisplan = Ausführung;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
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

    public Double getWert() {
        return Wert;
    }

    public void setWert(Double Wert) {
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
        return Preisplan;
    }

    public void setAusführung(String Ausführung) {
        this.Preisplan = Ausführung;
    }

    @Override
    public String toString() {
        return "Vorname=" + Vorname + "\n" + "Nachname=" + Nachname + "\n" + "Messgegenstand=" + Messgegenstand + "\n" + "Wert=" + Wert + "\n" + "Datum=" + Datum + "\n" + "Ger\u00e4tetyp=" + Gerätetyp + "\n" + "Preisplan=" + Preisplan + "\n" + "_________________________" + "\n";
    }

}
