package br.com.programa.service;

import br.com.programa.exe.entidades.Endereco;
import com.google.gson.Gson;
import org.apache.http.client.fluent.Request;

public class ViaCepClient {

    public static Endereco buscarCep(String cep) throws Exception{
        String url = "https://viacep.com.br/ws/" + cep + "/json/";
        String jsonResponse = Request.Get(url)
                .connectTimeout(1000)
                .socketTimeout(1000)
                .execute()
                .returnContent()
                .asString();
        Gson gson = new Gson();
        return gson.fromJson(jsonResponse, Endereco.class);
    }
}
