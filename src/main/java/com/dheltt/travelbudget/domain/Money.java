package com.dheltt.travelbudget.domain;

import lombok.Builder;

import java.math.BigDecimal;
import java.util.Objects;
/*
 *
 * Value object representing a monetary amount a currency.
 *
 * Design decisions:
 * Immutable
 * Self-validating
 * Technology-independent (pure domain model)
 * */
public class Money {
    /*
    * BigDecimal is used instead of double
    * to avoid floating-point precision issues.
    * Financial calculations must be deterministic.
    * */
    private final BigDecimal amount;

    /*
    * ISO currency code (e.g. "USD","MXN" "EUR").
    * keeping it as String for simplicity.
    * */
    private final String currency;

    /*
    * Constructor enforcing domain invariants.
    *
    * Invariants:
    * -Amount cannot be null
    * -currency cannot be null or blank
    * -Amount cannot be negative
    * */
    public Money(BigDecimal amount,String currency){
        if(amount == null){
            throw new IllegalArgumentException("Amount cannot be null");
        }

        if(currency == null){
            throw new IllegalArgumentException("Currency cannot be null or blank");
        }

        if(amount.compareTo(BigDecimal.ZERO) <0){
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        this.amount = amount;
        this.currency = currency;

    }
    /*
     * getter-style methods without setters.
     * teh objects is immutable by design.
     * */

    public BigDecimal amount(){
        return amount;
    }

    public String currency(){
        return currency;
    }

    public Money add(Money other){
        if(!this.currency.equals(other.currency)){
            throw new IllegalArgumentException("Cannot add different currencies");
        }
        return new Money(this.amount.add(other.amount),this.currency);
    }
    //Value Objects are equal by value, not by identity.
    @Override
    public boolean equals(Object o){
        if (this ==o) return true;
        if(!(o instanceof Money money)) return false;

        return amount.equals(money.amount)&& currency.equals(money.currency);
    }

    //hasCode must be consistent with equals.
    @Override
    public int hashCode(){
        return Objects.hash(amount,currency);
    }
    /**
     * Human-readable represetation.
     * Useful for logs and debugging.
     */
    @Override
    public String toString(){
        return amount+""+currency;
    }
}
