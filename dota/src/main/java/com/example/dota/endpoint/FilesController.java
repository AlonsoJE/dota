package com.example.dota.endpoint;

import com.example.dota.filesIO.DirectoryTest;
import com.example.dota.filesIO.FileTest;
import com.example.dota.filesIO.StreamTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/files")
public class FilesController {

    @Autowired
    FileTest textFile;

    @Autowired
    DirectoryTest directoryTest;

    @Autowired
    StreamTest streamTest;

    @GetMapping({"txtWrite","/txtWrite"})
    public void escreverArquivoBasico(@RequestBody String texto) throws IOException {
        textFile.write(texto);
    }

    @GetMapping({"txtWriteC","/txtWriteC"})
    public void escreverArquivoBasicoContinuado(@RequestBody String texto) throws IOException {
        textFile.writeContinues(texto);
    }

    @GetMapping({"newFile","/newFile"})
    public void newFile()  {
        textFile.newFile();
    }

    @GetMapping({"renameFile","/renameFile"})
    public void renameFile()  {
        directoryTest.rename();
    }

    @GetMapping({"inputStream","/inputStream"})
    public void inputStream()  {
        streamTest.inputStream();
    }

    @GetMapping({"inputBufferedStream","/inputBufferedStream"})
    public void inputBufferedStream()  {
        streamTest.inputBufferedStream();
    }

    @GetMapping({"outputStream","/outputStream"})
    public void outputStream()  {
        streamTest.outputStream();
    }

    @GetMapping({"outputBufferedStream","/outputBufferedStream"})
    public void outputBufferedStream()  {
        streamTest.outputBufferedStream();
    }


}
