package com.example.dota.files;

import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class TextFile {


    //ESCRITA

    // escrita de texto simples
    public void write(String text) throws IOException {

        FileWriter fileWriter;

        // definir o arquivo
        // se não for passado o segundo parametro true, vai substituir o conteúdo do arquivo por completo.
        fileWriter = new FileWriter("teste.txt");

        // escrever o arquivo com base em uma String
        fileWriter.write(text);

        // encerrar o procedimento de escrita
        fileWriter.close();

    }

    // escrita de texto sem sobreposição
    public void writeContinues(String text) throws IOException {

        FileWriter fileWriter;

        // definir o arquivo
        // se for passado o segundo parametro true, vai escrever sem prejudicar o que havia no arquivo antes.
        fileWriter = new FileWriter("teste.txt", true);

        // escrever o arquivo com base em uma String
        fileWriter.write(text);

        // encerrar o procedimento de escrita
        fileWriter.close();
    }

    //LEITURA

    // letirua de texto
    public void reader(String path) throws IOException {
        FileReader fileReader;

        fileReader = new FileReader(path);

        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String text;

        do {
            text = bufferedReader.readLine();
            if (text != null) {
                System.out.println(text);
            }
        }while (text != null);
    }

    public void deleteFile(File file){

        if(file.isFile()){
            file.delete();
        }else{
            File files[] = file.listFiles();
            int i = 0 ;
            while (i  < files.length){
                deleteFile(files[i]);
            }
        }
    }

    public void pathDeleteFil(String path){
        File file = new File(path);

        deleteFile(file);
    }
}





