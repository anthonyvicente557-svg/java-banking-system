package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        Conta conta = new Conta(100); // saldo inicial
        int opcao;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Ver saldo");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Ver histórico");
            System.out.println("0 - Sair");

            try {
                opcao = teclado.nextInt();
            } catch (Exception e) {
                System.out.println("Digite apenas números!");
                teclado.next(); // limpa erro
                opcao = -1;
            }

            if (opcao == 1) {
                conta.mostrarSaldo();
            }

            else if (opcao == 2) {
                System.out.print("Digite o valor do depósito: ");
                int valor = teclado.nextInt();
                conta.depositar(valor);
            }

            else if (opcao == 3) {
                System.out.print("Digite o valor do saque: ");
                int valor = teclado.nextInt();
                conta.sacar(valor);
            }

            else if (opcao == 4) {
                conta.mostrarHistorico();
            }

        } while (opcao != 0);

        System.out.println("Sistema encerrado.");
        teclado.close();
    }
}