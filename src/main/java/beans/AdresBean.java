/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.Adres;
import entity.AdresType;
import entity.Klant;
import entity.KlantAdres;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
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
    
    private Adres adres;
    private Klant klant;
    private List<Adres> adresGegevens;
    private KlantAdres klantAdres;
    
    @EJB
    private AdresFacade adFacade;
    @EJB
    private KlantFacade kFacade;
    @EJB
    private KlantAdresFacade kaFacade;
    
    public AdresBean() {
        adres = new Adres();
        klant = new Klant();
    }
    
    /*
    * CRUD methodes
    */
    public void leesAlleAdressen() {
        setAdresGegevens(adFacade.findAll());
    }

    /*
    * Getters & Setters
    */
    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public Klant getKlant() {
        return klant;
    }

    public void setKlant(Klant klant) {
        this.klant = klant;
    }

    public List<Adres> getAdresGegevens() {
        return adresGegevens;
    }

    public void setAdresGegevens(List<Adres> adressenLijst) {
        this.adresGegevens = adressenLijst;
    }

    public KlantAdres getKlantAdres() {
        return klantAdres;
    }

    public void setKlantAdres(KlantAdres klantAdres) {
        this.klantAdres = klantAdres;
    }
}
  

