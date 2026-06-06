package org.example;

import java.util.ArrayList;

public class Conta {

    private String titular;
    private ArrayList<Transacao> historico = new ArrayList<>();
    private double saldo;

    public Conta(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTitular() {
        return titular;
    }

    public boolean setTitular(String titular) {
        titular = titular.trim();

        if (titular.isEmpty()) {
            return false;
        }

        this.titular = titular;
            return true;
        }

    public void mostrarDadosConta() {
        System.out.println("Titular: " + titular);
        System.out.println("Saldo atual: " + saldo);
    }

    public void mostrarSaldo() {
        System.out.printf("Saldo atual: %.2f\n " + saldo);
        }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;

            Transacao transacao = new Transacao("Depósito", valor);
            historico.add(transacao);

            System.out.printf("Depósito de %.2f realizado. \n", valor);
        } else {
            System.out.println("Valor inválido.");
        }
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido.");
        } else if (saldo >= valor) {
            saldo -= valor;
            Transacao transacao = new Transacao("Saque", valor);
            historico.add(transacao);
            System.out.printf("Saque de %.2f realizado. \n", valor);
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public void mostrarHistorico() {
        System.out.println("\n--- HISTÓRICO ---");

        if (historico.isEmpty()) {
            System.out.println("Nenhuma movimentação.");
        } else {
            for (Transacao item : historico) {
                System.out.printf("%s de %2.2f em %s\n", item.getTipo(), item.getValor(), item.getData());
            }
        }
    }
}