package com.yamba.bankonet.exceptions;

import com.yamba.bankonet.entities.Compte;

public class NegativeBalanceException extends BalanceException {
    public NegativeBalanceException(Compte c){
        super("Solde Négatif!",c);
    }
}
