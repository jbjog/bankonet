package com.yamba.bankonet.exceptions;

import com.yamba.bankonet.entities.Compte;

public class OverdrawnException extends BalanceException {
    public OverdrawnException(Compte c){
        super("Découvert autorisé dépassé!",c);
    }
}