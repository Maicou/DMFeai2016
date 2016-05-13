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
    
    private static long id =1;
    private long fid;
    private String geraetetyp;
    private double wert;
    private String tarif;
    private String name;
    private String adresse;

    
    
    public Messpunkt(long id, long fid, String geraetetyp, double wert, String tarif, String name, String adresse) {
        this.id = id;
        this.fid = fid;
        this.geraetetyp = geraetetyp;
        this.wert = wert;
        this.tarif = tarif;
        this.name = name;
        this.adresse = adresse;
        
        id++;
        
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
    
}
