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
    
     private Artikel ditArtikel;
     private List<Artikel> artikelLijst;
     
     @EJB
     private ArtikelFacade arFacade;
     
     public ArtikelBean() {
         ditArtikel = new Artikel();
     }

    @PostConstruct
    public void init() {
        artikelLijst = new ArrayList<>();
    }
     
    /*
    * CRUD methodes
    */ 
    public void maakNieuwArtikel() {
        arFacade.create(ditArtikel);
        artikelLijst.add(ditArtikel);
    } 
     
    public void leesAlleArtikelen() {
        setArtikelLijst(arFacade.findAll());
    }
    
    public void editArtikel() {
        arFacade.edit(ditArtikel);
        ditArtikel = new Artikel();
    }
    
    public String gaNaarEditArtikel(Artikel artikel) {
        setDitArtikel(artikel);
        return "editartikel";
    }
      
    public void verwijderArtikel() {
        arFacade.remove(ditArtikel);
        artikelLijst.remove(ditArtikel);
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
    
    public Artikel getDitArtikel() {
        return ditArtikel;
    }

    public void setDitArtikel(Artikel ditArtikel) {
        this.ditArtikel = ditArtikel;
    }
}
