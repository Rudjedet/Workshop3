/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.Adres;
import entity.Klant;
import entity.KlantAdres;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.persistence.OneToMany;
import session.AdresFacade;
import session.KlantAdresFacade;
import session.KlantFacade;

/**
 *
 * @author Sonja
 */

@Stateless
@Dependent
@Named
public class AdresBean {
    
    private Adres ditAdres;
    private Klant dezeKlant;
    private List<Adres> adresGegevens;
    private KlantAdres klantAdres;
    private List<KlantAdres> klantadressen;
    
    @EJB
    private AdresFacade adFacade;
    @EJB
    private KlantFacade kFacade;
    @EJB
    private KlantAdresFacade kaFacade;
    
    public AdresBean() {
        ditAdres = new Adres();
        dezeKlant = new Klant();
    }
    
    @PostConstruct
    public void init() {
        adresGegevens = new ArrayList<>();
        leesAlleAdressen();
    }
    /*
    * CRUD methodes
    */
    public String maakNieuwAdres() {
        adFacade.create(ditAdres);
        adresGegevens.add(ditAdres);
        return "registratieGeslaagd";
    }
    
    public void voegAdresToeAanKlant(Adres adres) {
        KlantAdres kA = new KlantAdres();
        kA.setAdres(adres);
        kA.setKlant(dezeKlant);
        kaFacade.create(kA);
        klantadressen.add(kA);
        ditAdres = new Adres();
    }
    
    public void leesAlleAdressen() {
        setAdresGegevens(adFacade.findAll());
    }
    
    public void editAdres() {
        adFacade.edit(ditAdres);
        ditAdres = new Adres();
    }
    
    public String gaNaarEditAdresGegevens(Adres adres) {
        setDitAdres(adres);
        return "editadres";
    }
    
    @OneToMany(mappedBy="klant", orphanRemoval=true)
    public void verwijderAdres() {
        adFacade.remove(ditAdres);
        adresGegevens.remove(ditAdres);
        //DONE: verwijdert van gekoppelde dezeKlant met orphanRemoval - needs testing
    }

    /*
    * Getters & Setters
    */
    public Adres getDitAdres() {
        return ditAdres;
    }

    public void setDitAdres(Adres ditAdres) {
        this.ditAdres = ditAdres;
    }

    public Klant getDezeKlant() {
        return dezeKlant;
    }

    public void setDezeKlant(Klant dezeKlant) {
        this.dezeKlant = dezeKlant;
    }

    public List<Adres> getAdresGegevens() {
        return adresGegevens;
    }

    public void setAdresGegevens(List<Adres> adresGegevens) {
        this.adresGegevens = adresGegevens;
    }

    public KlantAdres getKlantAdres() {
        return klantAdres;
    }

    public void setKlantAdres(KlantAdres klantAdres) {
        this.klantAdres = klantAdres;
    }

    public List<KlantAdres> getKlantadressen() {
        return klantadressen;
    }

    public void setKlantadressen(List<KlantAdres> klantadressen) {
        this.klantadressen = klantadressen;
    }
}
  

