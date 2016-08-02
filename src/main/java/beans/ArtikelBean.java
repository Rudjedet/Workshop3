/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.Artikel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
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
     private List<Artikel> artikelLijst;
     @EJB
     private ArtikelFacade arFacade;
     
     public ArtikelBean() {
         artikel = new Artikel();
     }

    @PostConstruct
    public void init() {
        artikelLijst = new ArrayList<>();
    }
     
    /*
    * CRUD methodes
    */ 
    public void maakNieuwArtikel() {
        arFacade.create(artikel);
        artikelLijst.add(artikel);
    } 
     
    public void leesAlleArtikelen() {
        setArtikelLijst(arFacade.findAll());
    }
    
    public void editArtikel() {
        arFacade.edit(artikel);
        artikel = new Artikel();
    }
      
    public void verwijderArtikel() {
        arFacade.remove(artikel);
        artikelLijst.remove(artikel);
    }
     
    /*
    * Getters & Setters
    */    
    public List<Artikel> getArtikelLijst() {
        return artikelLijst;
    }

    public void setArtikelLijst(List<Artikel> artikelLijst) {
        this.artikelLijst = artikelLijst;
    }
    
    public Artikel getArtikel() {
        return artikel;
    }

    public void setArtikel(Artikel artikel) {
        this.artikel = artikel;
    }
}
