package com.example.bancong.conta.domain;

import java.math.BigDecimal;

public class Conta {

    private final Long numeroConta;
    private BigDecimal saldo;

    public Conta(Long numeroConta, BigDecimal saldo) {
        this.numeroConta = numeroConta;
        this.saldo = saldo;
    }

    public void debitar(BigDecimal valor) {
        if (this.saldo.compareTo(valor) < 0) {
            throw new IllegalStateException("Saldo insuficiente");
        }
        this.saldo = this.saldo.subtract(valor);
    }

    public Long getNumeroConta() {
        return numeroConta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

}
