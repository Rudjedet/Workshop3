/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.Artikel;
import entity.Bestelling;
import entity.Factuur;
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
public class BestellingBean {
    
    private Bestelling bestelling;
    private Artikel artikel;
    private Factuur factuur;
    private Klant klant;
    
    public BestellingBean() {
        bestelling = new Bestelling();
        artikel = new Artikel();
        factuur = new Factuur();
        klant = new Klant();
    }

    public Bestelling getBestelling() {
        return bestelling;
    }

    public void setBestelling(Bestelling bestelling) {
        this.bestelling = bestelling;
    }

    public Artikel getArtikel() {
        return artikel;
    }

    public void setArtikel(Artikel artikel) {
        this.artikel = artikel;
    }

    public Factuur getFactuur() {
        return factuur;
    }

    public void setFactuur(Factuur factuur) {
        this.factuur = factuur;
    }
}
