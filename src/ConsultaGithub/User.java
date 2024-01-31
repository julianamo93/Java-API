package ConsultaGithub;

public class User {
    private String nomeUsuario;
    private String id;

    public User(UserName userName) {
        this.nomeUsuario = userName.login();
        this.id = String.valueOf(userName.id());
    }

    @Override
    public String toString() {
        return "Nome: " + nomeUsuario + "\nID: " + id;
    }
}
