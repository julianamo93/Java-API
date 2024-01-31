package ExercicioSenha;

import java.util.Scanner;

public class LeituraDeSenha {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        System.out.println("Digite sua senha: ");
        String senha = read.nextLine();

        try{
            validarSenha(senha);
            System.out.println("Senha válida. Acesso permitido");
        } catch (senhaInvalidaException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void validarSenha(String senha) {
        if (senha.length() < 8) {
            throw new senhaInvalidaException("A senha deve ter pelo menos 8 caracteres.");
        }
    }
}
