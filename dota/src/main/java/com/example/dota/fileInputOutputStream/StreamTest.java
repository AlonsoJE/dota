package com.example.dota.fileInputOutputStream;

import lombok.Cleanup;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class StreamTest {

    //INPUTSTREAM

    // leitura de bytes
    //FileInputSream -> Leitura de arquivos
    //BufferedInputStream -> Leitura de arquivo da memória ao invés do arquivo fisico
    //ObjectInputStream -> Trabalha em arquivo

    // permite ler qualquer arquivo retornando dados em byte por byte
    public void inputStream(){
        try {
            @Cleanup  InputStream inputStream = new FileInputStream("D:\\inputstream\\inputStream.txt");

            int data = inputStream.read();

            do {
                if(data != -1) {
                    System.out.println( data);
                }
                data = inputStream.read();
            }while (data != -1);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // permite ler qualquer arquivo em blocos de bytes
    public void inputBufferedStream(){
        try {
            @Cleanup  InputStream inputStream = new BufferedInputStream(new FileInputStream("D:\\inputstream\\inputBufferedStream.txt"));

            int data = inputStream.read();

            do {
                if(data != -1) {
                    System.out.println(data);
                }
                data = inputStream.read();
            }while (data != -1);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //OUTPUTSTEAM

    // escrita de bytes
        public void outputStream(){
            try {

                File path = new File("D:\\outputstream");

                path.mkdir();

                File file = new File(path,"\\outputStream.txt");

                file.createNewFile();

                @Cleanup OutputStream outputStream = new FileOutputStream(file.getAbsolutePath());

                String pirulito = "ABCDE";

                // escreve utiilizando bytes
                outputStream.write(pirulito.getBytes());

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        public void outputBufferedStream(){
            try {
                File path = new File("D:\\outputBufferedStream");

                path.mkdir();

               File file = new File(path.getAbsolutePath().concat("\\outputStream.txt"));

                file.createNewFile();

                @Cleanup OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file.getAbsolutePath()));

                byte[] pirulito = new byte[] {'A','B', 'D', 'E'};

                outputStream.write(pirulito);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    //FileOutputSream -> Escrita de arquivos
    //FilerOutputStream -> Escrita de arquivo em memória ao invés do fisico
    //ObjectOutputStream -> Trabalha em arquivo

}
