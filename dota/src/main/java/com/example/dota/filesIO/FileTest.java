package com.example.dota.filesIO;

import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class FileTest {

//    FILE
    // classe mais básica para criação de arquivos
//    FILEREADER
    // criação e leitura de arquivos
//    BUFFEREDREADER
    // otimização para leitura de grandes arquivos em relação a fileReader
//    FILEWRITTER
    // escrita basica
//    BUFFEREDWRITTER
    // otimização em relação a fileWriter para leitura


    //FILE

    public void newFile(){
        //Insanciar novo arquivo
        File file = new File("D:\\testandoFile.txt");
        try {
            // Cria de fato o arquvo
            file.createNewFile();

            // Verifica a existencia do arquivo
            file.exists();

            // Caminho absoluto
            file.getAbsolutePath();

            // Verificar se é um diretorio
            file.isDirectory();

            // Verificar se é um arquivo oculto
            file.isHidden();

            // Verificar quando foi modificado pela ultima vez
            file.lastModified();

            // Excluir
            file.delete();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //FILE WRITTER

    // escrita de texto simples
    public void write(String text) {

        File file = new File("D:\\testandoFileWriter.txt");
        FileWriter fileWriter;

        // definir o arquivo
        // se não for passado o segundo parametro true, vai substituir o conteúdo do arquivo por completo.
        // também é possível passar um arquivo existente ao invés do nome
        try {
            fileWriter = new FileWriter(file);

            // escrever o arquivo com base em uma String
            fileWriter.write(text);

            // retira todas as sobras que ficaram
            fileWriter.flush();

            // encerrar o procedimento de escrita
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    // escrita de texto com append
    public void writeContinues(String text)  {

        File file = new File("D:\\perulito.txt");
        FileWriter fileWriter;

        // definir o arquivo
        // se for passado o segundo parametro true, vai escrever sem prejudicar o que havia no arquivo antes.
        try {
            fileWriter = new FileWriter(file, true);

            // escrever o arquivo com base em uma String
            fileWriter.write(text);

            // retira todas as sobras que ficaram
            fileWriter.flush();

            // encerrar o procedimento de escrita
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //FILEREADER

    // letirua de texto
    public void reader(String path) throws IOException {
        FileReader fileReader;

        fileReader = new FileReader(path);

        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String text = null;

        do {
            // le linha por linha
            text = bufferedReader.readLine();
            if (text != null) {
                System.out.println(text);
            }
        }while (text != null);
        // fecha a cadeia de leitura
        bufferedReader.close();
    }

}





