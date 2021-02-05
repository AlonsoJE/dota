package com.example.dota.fileBase64;

import lombok.Cleanup;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;

@Service
public class FileBase64Teste {

    // Gerando base 64
    public String toBase64(MultipartFile multipartFile){

        try {

            String encoded = Base64.getEncoder().encodeToString(multipartFile.getBytes());

            return  encoded;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Gerando algo a partir de base 64
    public void fromBase64(MultipartFile multipartFile){

        String encoded = toBase64(multipartFile);

        byte[] decoded = Base64.getDecoder().decode(encoded);

        try {
            @Cleanup OutputStream outputStream = new FileOutputStream(new File("D:\\fileBase64\\filePdfRegerado.pdf"));
            outputStream.write(decoded);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
