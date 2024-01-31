package ExercicioSenha;

public class senhaInvalidaException extends RuntimeException {

    public senhaInvalidaException(String mensagem) {
        super(mensagem);
    }
}
