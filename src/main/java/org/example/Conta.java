package org.example;
import java.util.ArrayList;

public class Conta {
    private ArrayList<String> historico = new ArrayList<>();
    int saldo;

    public Conta(int saldoInicial) {
        saldo = saldoInicial;
    }

    public void mostrarSaldo() {
        System.out.println("Saldo atual: " + saldo);
    }

    public void depositar(int valor) {
        if (valor > 0) {
            saldo = saldo + valor;
            System.out.println("Depósito de " + valor + " realizado.");
            historico.add("Depósito de " + valor);
        } else {
            System.out.println("Valor inválido.");
        }
    }

    public void sacar(int valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido.");
        } else if (saldo >= valor) {
            saldo = saldo - valor;
            System.out.println("Saque de " + valor + " realizado.");
            historico.add("Saque de " + valor);
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public void mostrarHistorico() {
        System.out.println("\n--- HISTÓRICO ---");

        for (String item : historico) {
            System.out.println(item);
        }
    }
}
