package com.yamba.bankonet.entities;

import com.yamba.bankonet.exceptions.BalanceException;
import javax.persistence.*;

@Entity
@Table(name = "compte_epargne")//, schema = "bankonet", catalog = "")
//@PrimaryKeyJoinColumn(name = "numero")
public class CompteEpargne extends Compte{
    @Basic
    @Column(name = "taux_interet")
    private double tauxInteret;

    public double getTauxInteret() {
        return tauxInteret;
    }
    public void setTauxInteret(double tauxInteret) {
        this.tauxInteret = tauxInteret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompteEpargne ce = (CompteEpargne) o;
        return numero.equals(ce.numero);
    }

    @Override
    public void debiter(double montant) throws BalanceException {

    }

}
