/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.Klant;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
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
    
    //TODO: public void verwijderKlant() {}
    //TODO: public void editKlant() {}
    
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
