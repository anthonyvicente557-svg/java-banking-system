import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        int saldo = 100;
        int opcao;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Ver saldo");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("0 - Sair");

            try {
                opcao = teclado.nextInt();
            } catch (Exception e) {
                System.out.println("Digite apenas números!");
                teclado.next();
                opcao = -1;
            }

            if (opcao == 1) {
                mostrarSaldo(saldo);
            }

            else if (opcao == 2) {
                System.out.print("Digite o valor do depósito: ");
                int valor = teclado.nextInt();
                saldo = depositar(saldo, valor);
            }

            else if (opcao == 3) {
                System.out.print("Digite o valor do saque: ");
                int valor = teclado.nextInt();
                saldo = sacar(saldo, valor);
            }

        } while (opcao != 0);

        System.out.println("Sistema encerrado.");
    }

    public static void mostrarSaldo(int saldo) {
        System.out.println("Saldo atual: " + saldo);
    }

    public static int depositar(int saldo, int valor) {

        if (valor > 0) {
            saldo = saldo + valor;
            System.out.println("Depósito de " + valor + " realizado. Saldo atual: " + saldo);
        } else {
            System.out.println("Valor inválido.");
        }

        return saldo;
    }

    public static int sacar(int saldo, int valor) {

        if (valor <= 0) {
            System.out.println("Valor inválido.");
        }

        else if (saldo >= valor) {
            saldo = saldo - valor;
            System.out.println("Saque de " + valor + " realizado. Saldo atual: " + saldo);
        }

        else {
            System.out.println("Saldo insuficiente.");
        }

        return saldo;
    }
}