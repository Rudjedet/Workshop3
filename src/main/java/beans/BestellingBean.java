/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.BesteldArtikel;
import entity.Bestelling;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import session.BesteldArtikelFacade;
import session.BestellingFacade;

/**
 *
 * @author Sonja
 */

@Stateless
@Dependent
@Named
public class BestellingBean {
    
    private Bestelling bestelling;
    private List<Bestelling> alleBestellingen;
    private List<BesteldArtikel> besteldeArtikelen;
    private Double totaalBedrag;
    
    @EJB
    private BestellingFacade bFacade;
    @EJB
    private BesteldArtikelFacade baFacade;
    
    public BestellingBean() {
        bestelling = new Bestelling();
        totaalBedrag = new Double(0);
    }
    
    @PostConstruct
    public void init() {
        alleBestellingen = new ArrayList<>();
    }    
    
    /*
    * CRUD methodes
    */
    public void maakNieuweBestelling() {
        bFacade.create(bestelling);
        //TODO: voeg artikelen toe aan bestelling
        alleBestellingen.add(bestelling);
    }
    
    public void leesAlleBestellingen() {
        setAlleBestellingen(bFacade.findAll());
    }
    
    public void editBestelling() {
        //TODO: voeg artikelen toe 
        //TODO: verwijder artikelen
        bFacade.edit(bestelling);
        bestelling = new Bestelling();
    }
    
    public void verwijderBestelling() {
        bFacade.remove(bestelling);
    }
    
    //TODO: public void verwijderArtikelUitBestelling() {
    
    //TODO: public void 

    /*
    * Getters & Setters
    */
    public Bestelling getBestelling() {
        return bestelling;
    }

    public void setBestelling(Bestelling bestelling) {
        this.bestelling = bestelling;
    }

    public List<Bestelling> getAlleBestellingen() {
        return alleBestellingen;
    }

    public void setAlleBestellingen(List<Bestelling> alleBestellingen) {
        this.alleBestellingen = alleBestellingen;
    }

    public List<BesteldArtikel> getBesteldeArtikelen() {
        return besteldeArtikelen;
    }

    public void setBesteldeArtikelen(List<BesteldArtikel> besteldeArtikelen) {
        this.besteldeArtikelen = besteldeArtikelen;
    }

    public Double getTotaalBedrag() {
        return totaalBedrag;
    }

    public void setTotaalBedrag(Double totaalBedrag) {
        this.totaalBedrag = totaalBedrag;
    }
}
