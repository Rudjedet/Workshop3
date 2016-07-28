/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.Artikel;
import entity.Bestelling;
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
public class ArtikelBean {
    
     private Artikel artikel;
     private Bestelling bestelling;
     //private List artikel;
     
     public ArtikelBean() {
         artikel = new Artikel();
         bestelling = new Bestelling();
     }

    public Artikel getArtikel() {
        return artikel;
    }

    public void setArtikel(Artikel artikel) {
        this.artikel = artikel;
    }

    public Bestelling getBestelling() {
        return bestelling;
    }

    public void setBestelling(Bestelling bestelling) {
        this.bestelling = bestelling;
    }
}
