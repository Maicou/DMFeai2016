/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Zielsystem;

/**
 *
 * @author Faruk
 */
public class Messpunkt {
    
    private static long MID =1;
    private long fid;
    private String geraetetyp;
    private double wert;
    private String tarif;
    private String name;
    private String adresse;
    private long id;

    
    
    public Messpunkt(long fid, String geraetetyp, double wert, String tarif, String name, String adresse) {
        this.id = MID;
        this.fid = fid;
        this.geraetetyp = geraetetyp;
        this.wert = wert;
        this.tarif = tarif;
        this.name = name;
        this.adresse = adresse;
        
        MID++;
        
    }

    public long getId() {
        return MID;
    }

    public void setId(long id) {
        this.MID = id;
    }

    public long getFid() {
        return fid;
    }

    public void setFid(long fid) {
        this.fid = fid;
    }

    public String getGeraetetyp() {
        return geraetetyp;
    }

    public void setGeraetetyp(String geraetetyp) {
        this.geraetetyp = geraetetyp;
    }

    public double getWert() {
        return wert;
    }

    public void setWert(double wert) {
        this.wert = wert;
    }

    public String getTarif() {
        return tarif;
    }

    public void setTarif(String tarif) {
        this.tarif = tarif;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "| ID="+id+ " | FID=" + fid + " | Gerätetyp=" + geraetetyp + " | Wert=" + wert + " | Tarif=" + tarif + " | Name=" + name + " | Adresse=" + adresse + " |";
    }
    
    
    
    
}
