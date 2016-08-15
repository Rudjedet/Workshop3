/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.Artikel;
import entity.BesteldArtikel;
import entity.Bestelling;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.persistence.OneToMany;
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
    
    private Bestelling dezeBestelling;
    private Artikel ditArtikel;
    private List<Bestelling> alleBestellingen;
    private List<BesteldArtikel> besteldeArtikelen;
    private Double totaalBedrag;
    
    @EJB
    private BestellingFacade bFacade;
    @EJB
    private BesteldArtikelFacade baFacade;
    
    public BestellingBean() {
        dezeBestelling = new Bestelling();
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
        bFacade.create(dezeBestelling);
        alleBestellingen.add(dezeBestelling);
    }
    
    public void voegArtikelToeAanBestelling(Artikel artikel) {
        BesteldArtikel bA = new BesteldArtikel();
        bA.setArtikel(artikel);
        bA.setBestelling(dezeBestelling);
        baFacade.create(bA);
        besteldeArtikelen.add(bA);
        dezeBestelling = new Bestelling();
    }
    
    public void verwijderUitBesteldeArtikelen(BesteldArtikel bar) {
        baFacade.remove(bar);
        setBesteldeArtikelen(baFacade.findBesteldeArtikelen(dezeBestelling.getBestellingId()));
    }
    
    public void verwijderArtikelUitBestelling(BesteldArtikel bestArtikel) {
        verwijderUitBesteldeArtikelen(bestArtikel);
    }
    
    public void leesAlleBestellingen() {
        setAlleBestellingen(bFacade.findAll());
    }
    
    public void editBestelling() {
        bFacade.edit(dezeBestelling);
        dezeBestelling = new Bestelling();
    }
    
    @OneToMany(mappedBy="klant", orphanRemoval=true)
    public void verwijderBestelling() {
        bFacade.remove(dezeBestelling);
        alleBestellingen.remove(dezeBestelling);
    }
    
    public void berekenTotaalBedrag() {
        List<BesteldArtikel> artikelenInDezeBestelling = getBesteldeArtikelen();
        double totaalBedrag = 0;
        
        for(BesteldArtikel bA : artikelenInDezeBestelling) {
            //totaalBedrag += bA.getBesteldArtikelId().getArtikelprijs() * bA.getAantal();
            //^cannot find getArtikelprijs methode???
        }
        
        setTotaalBedrag(totaalBedrag);
    }
    
    /*
    * Getters & Setters
    */
    public Bestelling getDezeBestelling() {
        return dezeBestelling;
    }

    public void setDezeBestelling(Bestelling dezeBestelling) {
        this.dezeBestelling = dezeBestelling;
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
