/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Sonja
 */
@Entity
@Table(name = "besteld_artikel")
@NamedQueries({
    @NamedQuery(name = "BesteldArtikel.findAll", query = "SELECT b FROM BesteldArtikel b"),
    @NamedQuery(name = "BesteldArtikel.findByBesteldArtikelid", query = "SELECT b FROM BesteldArtikel b WHERE b.besteldArtikelPK.besteldArtikelid = :besteldArtikelid"),
    @NamedQuery(name = "BesteldArtikel.findByAantal", query = "SELECT b FROM BesteldArtikel b WHERE b.aantal = :aantal"),
    @NamedQuery(name = "BesteldArtikel.findByBestellingIdbestelling", query = "SELECT b FROM BesteldArtikel b WHERE b.besteldArtikelPK.bestellingIdbestelling = :bestellingIdbestelling"),
    @NamedQuery(name = "BesteldArtikel.findByArtikelIdartikel", query = "SELECT b FROM BesteldArtikel b WHERE b.besteldArtikelPK.artikelIdartikel = :artikelIdartikel")})
public class BesteldArtikel implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BesteldArtikelPK besteldArtikelPK;
    @Column(name = "aantal")
    private Integer aantal;
    @JoinColumn(name = "artikel_idartikel", referencedColumnName = "artikel_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Artikel artikel;
    @JoinColumn(name = "bestelling_idbestelling", referencedColumnName = "bestelling_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Bestelling bestelling;

    public BesteldArtikel() {
    }

    public BesteldArtikel(BesteldArtikelPK besteldArtikelPK) {
        this.besteldArtikelPK = besteldArtikelPK;
    }

    public BesteldArtikel(int besteldArtikelid, int bestellingIdbestelling, int artikelIdartikel) {
        this.besteldArtikelPK = new BesteldArtikelPK(besteldArtikelid, bestellingIdbestelling, artikelIdartikel);
    }

    public BesteldArtikelPK getBesteldArtikelPK() {
        return besteldArtikelPK;
    }

    public void setBesteldArtikelPK(BesteldArtikelPK besteldArtikelPK) {
        this.besteldArtikelPK = besteldArtikelPK;
    }

    public Integer getAantal() {
        return aantal;
    }

    public void setAantal(Integer aantal) {
        this.aantal = aantal;
    }

    public Artikel getArtikel() {
        return artikel;
    }

    public void setArtikel(Artikel artikel) {
        this.artikel = artikel;
    }

    public Bestelling getBestelling() {
        return bestelling;
    }

    public void setBestelling(Bestelling bestelling) {
        this.bestelling = bestelling;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (besteldArtikelPK != null ? besteldArtikelPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BesteldArtikel)) {
            return false;
        }
        BesteldArtikel other = (BesteldArtikel) object;
        if ((this.besteldArtikelPK == null && other.besteldArtikelPK != null) || (this.besteldArtikelPK != null && !this.besteldArtikelPK.equals(other.besteldArtikelPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.BesteldArtikel[ besteldArtikelPK=" + besteldArtikelPK + " ]";
    }
    
}
