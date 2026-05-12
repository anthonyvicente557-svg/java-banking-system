package org.example;

import java.util.ArrayList;

public class Conta {

    private String titular;
    private ArrayList<String> historico = new ArrayList<>();
    private int saldo;

    public Conta(String titular, int saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public void mostrarDadosConta() {
        System.out.println("Titular: " + titular);
        System.out.println("Saldo atual: " + saldo);
    }

    public void mostrarSaldo() {
        System.out.println("Saldo atual: " + saldo);
    }

    public void depositar(int valor) {
        if (valor > 0) {
            saldo += valor;
            historico.add("Depósito de " + valor);
            System.out.println("Depósito de " + valor + " realizado.");
        } else {
            System.out.println("Valor inválido.");
        }
    }

    public void sacar(int valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido.");
        } else if (saldo >= valor) {
            saldo -= valor;
            historico.add("Saque de " + valor);
            System.out.println("Saque de " + valor + " realizado.");
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public void mostrarHistorico() {
        System.out.println("\n--- HISTÓRICO ---");

        if (historico.isEmpty()) {
            System.out.println("Nenhuma movimentação.");
        } else {
            for (String item : historico) {
                System.out.println(item);
            }
        }
    }
}