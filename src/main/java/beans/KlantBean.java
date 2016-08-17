/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

//import entity.Adres;
import entity.Klant;
//import entity.KlantAdres;
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
    
    private Klant dezeKlant;
    private List<Klant> klantGegevens;
    //private Adres ditAdres;
    //private KlantAdres klad;
    //private List<KlantAdres> kladLijst;
    
    @EJB
    private KlantFacade kFacade;
    
    public KlantBean() {
        dezeKlant = new Klant();
    }
    
    @PostConstruct
    public void init() {
        klantGegevens = new ArrayList<>();
        leesAlleKlanten();
    }        
    
    /*
    * CRUD methodes
    */
    public String maakNieuweKlant() {
        kFacade.create(dezeKlant);
        klantGegevens.add(dezeKlant);
        return "registratieGeslaagd";
    }
    
    public void leesAlleKlanten() {
        setKlantGegevens(kFacade.findAll());
    }
    
    public void editKlant() {
        kFacade.edit(dezeKlant);
        dezeKlant = new Klant();
    }
    
    public String gaNaarEditKlantGegevens(Klant klant) {
        setDezeKlant(klant);
        return "editklant";
    }
    
    @OneToMany(mappedBy="adres, bestelling", orphanRemoval=true)
    public void verwijderKlant() {
        kFacade.remove(dezeKlant);
        //DONE: verwijder orphaned adressen en bestellingen - needs testing
    } 
    
    /*
    * Getters & Setters
    */
    public Klant getDezeKlant() {
        return dezeKlant;
    }

    public void setDezeKlant(Klant dezeKlant) {
        this.dezeKlant = dezeKlant;
    }

    public List<Klant> getKlantGegevens() {
        return klantGegevens;
    }

    public void setKlantGegevens(List<Klant> klantGegevens) {
        this.klantGegevens = klantGegevens;
    }
}
