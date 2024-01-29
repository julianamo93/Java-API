import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ConsultaLivroGoogleBooks {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner read = new Scanner(System.in);
        System.out.println("Digite um título de livro para a busca: ");
        var tituloLivro = read.nextLine();

        String chave = "API_KEYAIzaSyD-KRFb-rgaIM6TmkwaA-wmqxGPNEytqsE";
        String endereco = "https://www.googleapis.com/books/v1/volumes?q=" + tituloLivro + "&key" + chave;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
    }
}