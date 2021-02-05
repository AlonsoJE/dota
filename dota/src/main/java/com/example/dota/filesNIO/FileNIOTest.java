package com.example.dota.filesNIO;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileNIOTest {

    // Pega um arquivo a partir de um caminho
//    Path p1 = Paths.get("");
//    File f1 = new File("");

//    // da para transformar path em file e file em path
//    File fp = p1.toFile();
//    Path pf = f1.toPath();

    Path path = Paths.get("D:\\fileNIO");
    Path arquivo = Paths.get("D:\\fileNIO\\File.txt");
    Path copiado = Paths.get("D:\\fileNIO\\FileCopiado.txt");

    // Criando diretorio
    public void criandoDiretorio(){


        try {

            if(Files.notExists(path)){
                // para um diretorio
//            Files.createDirectory(path);

                Files.createDirectories(path);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void criandoArquivo(){

        try {
            Files.createFile(arquivo);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void copiarArquivo(){

        try {
            Files.copy(arquivo, copiado);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void deleteArquivo(){

        try {
            Files.delete(copiado);
            Files.deleteIfExists(arquivo);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
