package com.yamba.bankonet.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class Mouvement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "montant")
    private double montant;

    @ManyToOne
    @JoinColumn(name = "numero_compte_debite")
    @JsonIgnoreProperties({"debits","credits","client"})
    private Compte compteDebite;

    @ManyToOne
    @JoinColumn(name = "numero_compte_credite")
    @JsonIgnoreProperties({"debits","credits","client"})
    private Compte compteCredite;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public double getMontant() {
        return montant;
    }
    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Compte getCompteDebite() {
        return compteDebite;
    }
    public void setCompteDebite(Compte compteDebite) {
        this.compteDebite = compteDebite;
    }

    public Compte getCompteCredite() {
        return compteCredite;
    }
    public void setCompteCredite(Compte compteCredite) {
        this.compteCredite = compteCredite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mouvement mouvement = (Mouvement) o;
        return id == mouvement.id;
    }
}
