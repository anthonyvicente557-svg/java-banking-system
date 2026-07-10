package org.example;

import java.util.ArrayList;

public class Conta {

    private Cliente cliente;
    private ArrayList<Transacao> historico = new ArrayList<>();
    private double saldo;
    private static int proximoNumeroConta = 1001;
    private int numeroConta;

    public Conta(Cliente cliente, double saldoInicial) {
        this.cliente = cliente;
        this.saldo = saldoInicial;
        this.numeroConta = proximoNumeroConta;
        proximoNumeroConta++;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTitular() {
        return cliente.getNome();
    }

    public void mostrarDadosConta() {
        System.out.println("Conta: " + numeroConta);
        System.out.println("Titular: " + cliente.getNome());
        System.out.println("CPF: " + cliente.getCpf());
        System.out.println("Saldo atual: " + saldo);
    }

    public void mostrarSaldo() {
        System.out.printf("Saldo atual: %.2f\n ", saldo);
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