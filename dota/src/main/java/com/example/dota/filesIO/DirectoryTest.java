package com.example.dota.filesIO;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class DirectoryTest {

    // criação de diretorio e arquivos dentro do diretorio
    public File newDirectory(){

        File directory = new File("D:\\fileDirectory");

        // criação do diretorio
        directory.mkdir();

        return directory;

    }

    public void rename(){
        // preparação do arquivo dentro do diretorio

        File directory = newDirectory();

        String path = directory.getAbsolutePath();

        File file = new File(path, "arquivoSemRenome.txt");

        try {
            //criacao do arquivo
            file.createNewFile();

            // preparação da renomeação do arquivo
            File renamedFile = new File(path, "renamed.txt");

            // renomeando o arquivo existente
            file.renameTo(renamedFile);

            // preparação da renomeação do diretorio
            File renamedDirectory = new File("D:\\fileDirectoryRenamed");

            // renomeando o diretorio
            directory.renameTo(renamedDirectory);

            // renomear arquivo criado
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
