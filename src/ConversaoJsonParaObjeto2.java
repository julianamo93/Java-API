import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ConversaoJsonParaObjeto2 {
    public static void main(String[] args) {
        String jsonPessoa = "{\"nome\":\"Akira \",\"idade\":27,\"cidade\":\"São Paulo\"}";

        Gson gson = new GsonBuilder().setLenient().create();
        Pessoa pessoa = gson.fromJson(jsonPessoa, Pessoa.class);

        System.out.println("Objeto Pessoa: " + pessoa);
    }
}