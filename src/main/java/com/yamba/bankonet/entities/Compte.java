package com.yamba.bankonet.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yamba.bankonet.exceptions.BalanceException;
import com.yamba.bankonet.services.ICompteStat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity @Inheritance(strategy=InheritanceType.JOINED)
public abstract class Compte implements ICompteStat {
    @Id
    @Column(name = "numero")
    protected String numero;

    @Basic
    @Column(name = " intitule")
    protected String intitule;

    @Basic
    @Column(name = "solde")
    protected double solde;

    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_client")
    private Client client;


    @OneToMany(mappedBy = "compteDebite")
    @JsonIgnoreProperties({"compteDebite"})
    private List<Mouvement> debits = new ArrayList<>();
    public List<Mouvement> getDebits() {
        return debits;
    }
    public void setDebits(List<Mouvement> debits) {
        this.debits = debits;
    }


    @OneToMany(mappedBy = "compteCredite")
    @JsonIgnoreProperties({"compteCredite"})
    private List<Mouvement> credits = new ArrayList<>();

    public List<Mouvement> getCredits() {
        return credits;
    }
    public void setCredits(List<Mouvement> credits) {
        this.credits = credits;
    }

    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }


    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getIntitule() {
        return intitule;
    }
    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public double getSolde() {
        return solde;
    }
    public void setSolde(double solde) {
        this.solde = solde;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Compte compte = (Compte) o;
        return numero.equals(compte.numero);
    }

    public abstract void debiter(double montant) throws BalanceException;

}
