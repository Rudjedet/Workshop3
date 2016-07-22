/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
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
@Table(name = "klant_adres")
@NamedQueries({
    @NamedQuery(name = "KlantAdres.findAll", query = "SELECT k FROM KlantAdres k"),
    @NamedQuery(name = "KlantAdres.findByKlantIdklant", query = "SELECT k FROM KlantAdres k WHERE k.klantAdresPK.klantIdklant = :klantIdklant"),
    @NamedQuery(name = "KlantAdres.findByAdresIdadres", query = "SELECT k FROM KlantAdres k WHERE k.klantAdresPK.adresIdadres = :adresIdadres")})
public class KlantAdres implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected KlantAdresPK klantAdresPK;
    @JoinColumn(name = "adres_idadres", referencedColumnName = "adres_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Adres adres;
    @JoinColumn(name = "adrestype_idadrestype", referencedColumnName = "adrestype_id")
    @ManyToOne(optional = false)
    private AdresType adrestypeIdadrestype;
    @JoinColumn(name = "klant_idklant", referencedColumnName = "klant_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Klant klant;

    public KlantAdres() {
    }

    public KlantAdres(KlantAdresPK klantAdresPK) {
        this.klantAdresPK = klantAdresPK;
    }

    public KlantAdres(int klantIdklant, int adresIdadres) {
        this.klantAdresPK = new KlantAdresPK(klantIdklant, adresIdadres);
    }

    public KlantAdresPK getKlantAdresPK() {
        return klantAdresPK;
    }

    public void setKlantAdresPK(KlantAdresPK klantAdresPK) {
        this.klantAdresPK = klantAdresPK;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public AdresType getAdrestypeIdadrestype() {
        return adrestypeIdadrestype;
    }

    public void setAdrestypeIdadrestype(AdresType adrestypeIdadrestype) {
        this.adrestypeIdadrestype = adrestypeIdadrestype;
    }

    public Klant getKlant() {
        return klant;
    }

    public void setKlant(Klant klant) {
        this.klant = klant;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (klantAdresPK != null ? klantAdresPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KlantAdres)) {
            return false;
        }
        KlantAdres other = (KlantAdres) object;
        if ((this.klantAdresPK == null && other.klantAdresPK != null) || (this.klantAdresPK != null && !this.klantAdresPK.equals(other.klantAdresPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.KlantAdres[ klantAdresPK=" + klantAdresPK + " ]";
    }
    
}
