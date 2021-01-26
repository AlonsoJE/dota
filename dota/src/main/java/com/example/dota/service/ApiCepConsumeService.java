package com.example.dota.service;

import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@Service
public class ApiCepConsumeService {

    @Value("${var.url.viacep}")
    private String viacep;

    @Value("${var.util.jsonFormat}")
    private String json;

    public Object apiViaCep(String cep) throws IOException {
        try {
//            //USANDO HTTPURLCONNETION E GSON
//
            //url de acesso setando os parametros
            URL url = new URL(viacep.concat(cep).concat("/").concat(json));
//
//            // estabelecimento de conexão com HttpURLConnection
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//
//            // leitura e captura de dados com BuffReader
//            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//
//            // cast de buffer para string
//            String text = reader.lines().collect(Collectors.joining());
//
//            // cast de string para json
//            String result = new Gson().toJson(text);
//
//            // removendo sujeira que o Gson deixou no retorno
//            result = result.replace("\\", "");


            //USANDO OKHTTPCLIENT
//            // estabelecimento de conexão com OkHttpClient
            OkHttpClient client = new OkHttpClient();

            //CASO A REQUISIÇÃO TENHA CORPO
//            RequestBody body = RequestBody.create("application/json", MediaType.parse(""));

            Request request = new Request.Builder().url(url).get().addHeader("Accept", "application/json").build();
//
            Response response = client.newCall(request).execute();

            return response.body().string();

        } catch (MalformedURLException e) {
            e.printStackTrace();
            return  null;
        }
    }

}
