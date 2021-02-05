package com.example.dota.fileManipulacaoGeralDeArquivos;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;


@Service
public class ManipulandoQualquerArquivoNIO {

    public void receberArquivoDevolvendoArquivo(){
        Path path = Paths.get("D:\\fileNioTestes\\filePdf.pdf");
        Path pathSaida = Paths.get("D:\\fileNioTestes\\filePdfCopiado.pdf");

        if(Files.exists(path)){
            try {
                Files.copy(path, pathSaida);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void receberMultiPartFileDevolvendoArquivo(MultipartFile multipartFile){
        Path path = Paths.get("D:\\fileNioTestes\\".concat(LocalDate.now().toString()).concat(multipartFile.getOriginalFilename()));

        if(Files.notExists(path)){
            try {
                multipartFile.transferTo(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
