package com.example.dota.fileManipulacaoGeralDeArquivos;

import lombok.Cleanup;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Service
public class ManipulandoQualquerArquivo {

    public void receberArquivoDevolvendoArquivo(){

        try {
            InputStream inputStream = new BufferedInputStream(new FileInputStream("D:\\filePdf\\filePdf.pdf"));

            byte[] buffer = new byte[inputStream.available()];

            inputStream.read(buffer);

            @Cleanup OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(new File("D:\\filePdf\\filePdfGerado.pdf")));

            outputStream.write(buffer);

            outputStream.flush();
            outputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }public void receberMultiPartFileDevolvendoArquivo(MultipartFile multipartFile){

        try {

            @Cleanup OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(new File("D:\\fileImage\\fileJpgRegerado.jpg")));

            outputStream.write(multipartFile.getBytes());

            outputStream.flush();
            outputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
