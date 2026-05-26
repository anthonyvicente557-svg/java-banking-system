package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        // Cria a conta com titular e saldo inicial
        Conta conta = new Conta("Anthony", 100);

        double opcao;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Ver saldo");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Ver histórico");
            System.out.println("5 - Ver dados da conta");
            System.out.println("6 - Alterar titular");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            // Lê a opção do menu com proteção contra letras
            try {
                opcao = teclado.nextDouble();
            } catch (Exception e) {
                System.out.println("Digite apenas números!");
                teclado.next(); // limpa o valor inválido
                opcao = -1;
            }

            if (opcao == 1) {
                conta.mostrarSaldo();
            }

            else if (opcao == 2) {
                System.out.print("Digite o valor do depósito: ");
                double valor = lerValor(teclado);
                conta.depositar(valor);
            }

            else if (opcao == 3) {
                System.out.print("Digite o valor do saque: ");
                double valor = lerValor(teclado);
                conta.sacar(valor);
            }

            else if (opcao == 4) {
                conta.mostrarHistorico();
            }

            else if (opcao == 5) {
                conta.mostrarDadosConta();
            }

            else if (opcao == 6) {
                teclado.nextLine();
                System.out.println("Digite o novo titular: ");
                String novoTitular = teclado.nextLine();

                if (conta.setTitular(novoTitular)) {
                    System.out.println("Titular alterado com sucesso!");
                } else {
                    System.out.println("Nome inválido.");
                }
            }

            else if (opcao == 0) {
                System.out.println("Sistema encerrado.");
            }

            else {
                System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        teclado.close();
    }

    public static double lerValor(Scanner teclado) {
        String entrada = teclado.next();

        if (!entrada.matches("\\d+(,\\d{1,2})?")) {
            System.out.println("Digite um valor válido com no máximo 2 casas decimas. ");
            return -1;
        }
        entrada = entrada.replace(",", ".");
        return Double.parseDouble(entrada);
    }
}