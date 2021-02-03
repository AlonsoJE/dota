package com.example.dota.fileJson;

import com.google.gson.Gson;
import lombok.Cleanup;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class GsonTest {

    Gson gson;

    public void readJson() {
        gson = new Gson();

        try {

             InputStream inputStream = new BufferedInputStream(new FileInputStream("D:\\fileJson\\fileJson.json"));

             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            JsonTestResource jsonTestResource = gson.fromJson(bufferedReader, JsonTestResource.class);

            System.out.println(jsonTestResource);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void writeJson(){
        List<String> lista = new ArrayList<>();
        lista.add("teste1");
        lista.add("teste2");

        CidadeResourceJson cidadeResourceJson = CidadeResourceJson.builder()
                .nome("Tanabi")
                .estado("Sao Paulo")
                .build();
        JsonTestResource jsonTestResource = JsonTestResource.builder()
                .cidade(cidadeResourceJson)
                .nome("Alonso")
                .idade(26)
                .lista(lista)
                .build();

        gson = new Gson();

        String json = gson.toJson(jsonTestResource);

        try {
            @Cleanup OutputStream outputStream = new FileOutputStream(new File("D:\\fileJson\\fileJsonWritter.json"));

            outputStream.write(json.getBytes());

            outputStream.flush();
            outputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
