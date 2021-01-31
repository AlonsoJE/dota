package com.example.dota.endpoint;

import com.example.dota.files.TextFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/files")
public class FilesController {

    @Autowired
    TextFile textFile;

    @GetMapping({"txtWrite","/txtWrite"})
    public void escreverArquivoBasico(@RequestBody String texto) throws IOException {
        textFile.write(texto);
    }

    @GetMapping({"txtWriteC","/txtWriteC"})
    public void escreverArquivoBasicoContinuado(@RequestBody String texto) throws IOException {
        textFile.writeContinues(texto);
    }

    // nao funcionando ainda
//    @GetMapping({"txtReader","/txtReader"})
//    public void lerArquivoBasico(@RequestBody String path) throws IOException {
//        textFile.reader(path);
//    }
//
//    @GetMapping({"txtDelete","/txtDelete"})
//    public void deleteFile(File file) throws IOException {
//        textFile.deleteFile(file);
//    }



}
