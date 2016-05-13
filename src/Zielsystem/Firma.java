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
public class Firma {
    private long fid;
    private String name;
    private String strasse;
    private String plz;
    private String stadt;

    public Firma(long fid, String name, String strasse, String plz, String stadt) {
        this.fid = fid;
        this.name = name;
        this.strasse = strasse;
        this.plz = plz;
        this.stadt = stadt;
    }

    public long getFid() {
        return fid;
    }

    public void setFid(long fid) {
        this.fid = fid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getStadt() {
        return stadt;
    }

    public void setStadt(String stadt) {
        this.stadt = stadt;
    }

    @Override
    public String toString() {
        return "| FID=" + fid + " | Name=" + name + " | Strasse=" + strasse + " | PLZ=" + plz + " | Stadt=" + stadt + " |";
    }

    
}
