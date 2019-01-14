package com.yamba.bankonet.entities;

import com.yamba.bankonet.exceptions.BalanceException;
import javax.persistence.*;

@Entity
@Table(name = "compte_courant")//, schema = "bankonet", catalog = "")
//@PrimaryKeyJoinColumn(name = "numero")
public class CompteCourant extends Compte{
    @Basic
    @Column(name = "decouvert")
    private double decouvert;

    public double getDecouvert() {
        return decouvert;
    }
    public void setDecouvert(double decouvert) {
        this.decouvert = decouvert;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompteCourant cc = (CompteCourant) o;
        return numero.equals(cc.numero);
    }

    @Override
    public void debiter(double montant) throws BalanceException {

    }
}
