import com.google.gson.Gson;

public class ConversaoJsonParaObjeto {

    public static void main(String[] args) {
        String jsonPessoa = "{\"nome\":\"Akira  \",\"idade\":27,\"cidade\":\"São Paulo\"}";

        Gson gson = new Gson();
        Pessoa pessoa = gson.fromJson(jsonPessoa, Pessoa.class);

        System.out.println("Objeto Pessoa: " + pessoa);
    }
}

