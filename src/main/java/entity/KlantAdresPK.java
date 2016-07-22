/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Sonja
 */
@Embeddable
public class KlantAdresPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "klant_idklant")
    private int klantIdklant;
    @Basic(optional = false)
    @NotNull
    @Column(name = "adres_idadres")
    private int adresIdadres;

    public KlantAdresPK() {
    }

    public KlantAdresPK(int klantIdklant, int adresIdadres) {
        this.klantIdklant = klantIdklant;
        this.adresIdadres = adresIdadres;
    }

    public int getKlantIdklant() {
        return klantIdklant;
    }

    public void setKlantIdklant(int klantIdklant) {
        this.klantIdklant = klantIdklant;
    }

    public int getAdresIdadres() {
        return adresIdadres;
    }

    public void setAdresIdadres(int adresIdadres) {
        this.adresIdadres = adresIdadres;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) klantIdklant;
        hash += (int) adresIdadres;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KlantAdresPK)) {
            return false;
        }
        KlantAdresPK other = (KlantAdresPK) object;
        if (this.klantIdklant != other.klantIdklant) {
            return false;
        }
        if (this.adresIdadres != other.adresIdadres) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.KlantAdresPK[ klantIdklant=" + klantIdklant + ", adresIdadres=" + adresIdadres + " ]";
    }
    
}
