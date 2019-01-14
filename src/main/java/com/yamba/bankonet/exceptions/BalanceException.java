package com.yamba.bankonet.exceptions;

import com.yamba.bankonet.entities.Compte;

public abstract class BalanceException extends Exception{
    public Compte getC() {
        return c;
    }

    private Compte c;
    public BalanceException(String s, Compte c) {
        super(s);
        this.c = c;
    }
}
