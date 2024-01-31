package ConsultaGithub;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ConsultaGithub {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner read = new Scanner(System.in);
        System.out.println("Digite o nome do usuário para busca: ");
        String nomeUsuario = read.nextLine();

        String endereco = "https://api.github.com/users/" + nomeUsuario;

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .header("Accept", "application/vnd.github.v3+json")
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 404) {
                throw new ErroConsultaGithubException("Usuário não encontrado no GitHub.");
            }
            String json = response.body();
            System.out.println(json);

            Gson gson = new GsonBuilder().create();
            UserName userName = gson.fromJson(json, UserName.class);
            System.out.println("\nUsuário GitHub: " + userName);
            User user = new User(userName);
            System.out.println("\nUsuário: " + user);

        } catch (IOException | InterruptedException e) {
            System.out.println("Houve um erro na consulta da API do GitHub.");
            e.printStackTrace();
        } catch (ErroConsultaGithubException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("\nConsulta finalizada!");

        }
    }
}

