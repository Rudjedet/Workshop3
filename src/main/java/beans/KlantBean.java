/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.Adres;
import entity.Klant;
import entity.KlantAdres;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.persistence.OneToMany;
import session.KlantFacade;

/**
 *
 * @author Sonja
 */

@Stateless
@Dependent
@Named
public class KlantBean implements Serializable {
    
    private Klant klant;
    private List<Klant> klantGegevens;
    private Adres adres;
    private KlantAdres klad;
    private List<KlantAdres> kladLijst;
    
    @EJB
    private KlantFacade kFacade;
    
    public KlantBean() {
        klant = new Klant();
    }
    
    @PostConstruct
    public void init() {
        klantGegevens = new ArrayList<>();
    }        
    
    /*
    * CRUD methodes
    */
    public void maakNieuweKlant() {
        kFacade.create(klant);
        klantGegevens.add(klant);
    }
    
    public void leesAlleKlanten() {
        setKlantGegevens(kFacade.findAll());
    }
    
    public void editKlant() {
        kFacade.edit(klant);
        klant = new Klant();
    }
    
    @OneToMany(mappedBy="adres, bestelling", orphanRemoval=true)
    public void verwijderKlant() {
        kFacade.remove(klant);
        //DONE: verwijder orphaned adressen en bestellingen - needs testing
    } 
    
    /*
    * Getters & Setters
    */
    public Klant getKlant() {
        return klant;
    }

    public void setKlant(Klant klant) {
        this.klant = klant;
    }

    public List<Klant> getKlantGegevens() {
        return klantGegevens;
    }

    public void setKlantGegevens(List<Klant> klantGegevens) {
        this.klantGegevens = klantGegevens;
    }
}
