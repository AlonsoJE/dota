package com.example.dota.fileBase64;

import com.example.dota.entity.BlobBase64Entity;
import com.example.dota.repository.BloblBase64Repository;
import lombok.Cleanup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;

@Service
public class PersistindoBlobBase64 {

    @Autowired
    FileBase64Teste fileBase64Teste;

    @Autowired
    BloblBase64Repository repository;

    public void saveBlob(MultipartFile multipartFile){

        byte[] encoded = new byte[0];

        try {
            encoded = Base64.getEncoder().encode(multipartFile.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        BlobBase64Entity entity = BlobBase64Entity.builder()
                .arquivo(encoded)
                .build();
        repository.save(entity);
    }

    public void findBlob(){

        byte[] find = Base64.getDecoder().decode(repository.findById(1L).get().getArquivo());

        try {
            @Cleanup OutputStream outputStream = new FileOutputStream(new File("D:\\fileBase64\\pegoDoBanco.pdf"));
            outputStream.write(find);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
