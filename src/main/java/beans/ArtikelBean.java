/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.Artikel;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import session.ArtikelFacade;

/**
 *
 * @author Sonja
 */

@Stateless
@Dependent
@Named
public class ArtikelBean {
    
     private Artikel artikel;
     private List<Artikel> artikelGegevens;
     @EJB
     private ArtikelFacade arFacade;
     
     public ArtikelBean() {
         artikel = new Artikel();
     }

    /*
    * CRUD methodes
    */ 
    public void leesAlleArtikelen() {
        setArtikelGegevens(arFacade.findAll());
    }
    
    //TODO: public void voegArtikelToe() {}
    
    //TODO: public void verwijderArtikel() {}
    
    //TODO: public void editArtikel() {} 
     
    /*
    * Getters & Setters
    */    
    public List<Artikel> getArtikelGegevens() {
        return artikelGegevens;
    }

    public void setArtikelGegevens(List<Artikel> artikelGegevens) {
        this.artikelGegevens = artikelGegevens;
    }
    
    public Artikel getArtikel() {
        return artikel;
    }

    public void setArtikel(Artikel artikel) {
        this.artikel = artikel;
    }
}
