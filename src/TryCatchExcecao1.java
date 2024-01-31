import java.util.Scanner;

public class TryCatchExcecao1 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        System.out.println("Informe o numerador: ");
        int a = read.nextInt();
        System.out.println("Informe o denominador: ");
        int b = read.nextInt();

        try {
            int resultado = a / b;
            System.out.println("Resultado da divisão: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("Erro: divisão por zero não permitida");
        }

    }
}
