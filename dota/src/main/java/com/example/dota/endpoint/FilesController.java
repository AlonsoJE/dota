package com.example.dota.endpoint;

import com.example.dota.fileBase64.FileBase64Teste;
import com.example.dota.fileBase64.PersistindoBlobBase64;
import com.example.dota.fileExcel.FileExcelPOI;
import com.example.dota.fileInputOutputStream.StreamTest;
import com.example.dota.fileJson.GsonTest;
import com.example.dota.fileManipulacaoGeralDeArquivos.ManipulandoQualquerArquivo;
import com.example.dota.fileManipulacaoGeralDeArquivos.ManipulandoQualquerArquivoNIO;
import com.example.dota.fileXml.XstreamTest;
import com.example.dota.filesIO.DirectoryTest;
import com.example.dota.filesIO.FileTest;
import com.example.dota.filesNIO.FileNIOTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @Autowired
    FileExcelPOI fileExcelPOI;

    @Autowired
    GsonTest gsonTest;

    @Autowired
    XstreamTest xstreamTest;

    @Autowired
    ManipulandoQualquerArquivo manipulandoQualquerArquivo;

    @Autowired
    FileNIOTest fileNIOTest;

    @Autowired
    ManipulandoQualquerArquivoNIO manipulandoQualquerArquivoNIO;

    @Autowired
    FileBase64Teste fileBase64Teste;

    @Autowired
    PersistindoBlobBase64 persistindoBlobBase64;

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

    @GetMapping({"excelRead","/excelRead"})
    public void excelRead()  {
        fileExcelPOI.lerExcelExistenteComTipos();
    }

    @GetMapping({"excelWrite","/excelWrite"})
    public void excelWrite()  {
        fileExcelPOI.escreverExcel();
    }

    @GetMapping({"jsonRead","/jsonRead"})
    public void jsonlRead()  {
        gsonTest.readJson();
    }

    @GetMapping({"jsonWrite","/jsonWrite"})
    public void jsonWrite()  {
        gsonTest.writeJson();
    }

    @GetMapping({"xmlRead","/xmlRead"})
    public void xmlRead()  {
        xstreamTest.readXml();
    }

    @GetMapping({"xmlWrite","/xmlWrite"})
    public void xmlWrite()  {
        xstreamTest.writXml();
    }

    @GetMapping({"pdfTeste","/pdfTeste"})
    public void pdfTeste()  {
        manipulandoQualquerArquivo.receberArquivoDevolvendoArquivo();
    }

    @PostMapping({"jpgTeste","/jpgTeste"})
    public void jpgTeste(@RequestParam MultipartFile multipartFile)  {
        manipulandoQualquerArquivo.receberMultiPartFileDevolvendoArquivo(multipartFile);
    }

    @GetMapping({"nioCreateDirectory","/nioCreateDirectory"})
    public void nioCreateDirecotry()  {
        fileNIOTest.criandoDiretorio();
    }

    @GetMapping({"nioCreateFile","/nioCreateFile"})
    public void nioCreateFile()  {
        fileNIOTest.criandoArquivo();
    }

    @GetMapping({"nioCopyFile","/nioCopyFile"})
    public void nioCopyFile()  {
        fileNIOTest.copiarArquivo();
    }

    @GetMapping({"nioDeleteFile","/nioDeleteFile"})
    public void nioDeleteFile()  {
        fileNIOTest.deleteArquivo();
    }

    @GetMapping({"criadorNioTeste","/criadorNioTeste"})
    public void criadorNioTeste()  {
        manipulandoQualquerArquivoNIO.receberArquivoDevolvendoArquivo();
    }

    @PostMapping({"criadorNioTesteM","/criadorNioTesteM"})
    public void criadorNioTeste(@RequestParam MultipartFile multipartFile) {
        manipulandoQualquerArquivoNIO.receberMultiPartFileDevolvendoArquivo(multipartFile);
    }

    @PostMapping({"base64Test","/base64Test"})
    public void base64Test(@RequestParam MultipartFile multipartFile) {
        fileBase64Teste.fromBase64(multipartFile);
    }

    @PostMapping({"persistindoBlob","/persistindoBlob"})
    public void persistindoBlob(@RequestParam MultipartFile multipartFile) {
        persistindoBlobBase64.saveBlob(multipartFile);
    }

    @GetMapping({"findBlob","/findBlob"})
    public void findBlob() {
        persistindoBlobBase64.findBlob();
    }

}
