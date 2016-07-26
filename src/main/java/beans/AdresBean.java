/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.Adres;
import entity.AdresType;
import entity.Klant;
import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

/**
 *
 * @author Sonja
 */

@Stateless
@Dependent
@Named
public class AdresBean {
    
    private Adres adres;
    private AdresType adresType;
    private Klant klant;
    
    public AdresBean() {
        adres = new Adres();
        adresType = new AdresType();
        klant = new Klant();
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public AdresType getAdresType() {
        return adresType;
    }

    public void setAdresType(AdresType adresType) {
        this.adresType = adresType;
    }

    public Klant getKlant() {
        return klant;
    }

    public void setKlant(Klant klant) {
        this.klant = klant;
    }
}
  

