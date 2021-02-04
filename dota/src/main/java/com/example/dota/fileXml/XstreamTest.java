package com.example.dota.fileXml;

import com.example.dota.fileJson.CidadeResourceJson;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import lombok.Cleanup;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class XstreamTest {



    public void readXml() {
        try {
            InputStream inputStream = new BufferedInputStream(new FileInputStream(new File("D:\\fileXml\\filwXmlRead.xml")));

            XStream xStream = new XStream(new DomDriver());

            XmlTestResource xmlTestResource = (XmlTestResource)xStream.fromXML(inputStream);

            System.out.println(xmlTestResource);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void writXml(){

        List<String> lista = new ArrayList<>();
        lista.add("teste1");
        lista.add("teste2");

        CidadeResourceJson cidadeResourceJson = CidadeResourceJson.builder()
                .nome("Tanabi")
                .estado("Sao Paulo")
                .build();

        XmlTestResource xmlTestResource = XmlTestResource.builder()
                .cidade(cidadeResourceJson)
                .nome("Alonso")
                .idade(26)
                .lista(lista)
                .build();

        XStream xStream = new XStream(new DomDriver());

        try {
            @Cleanup OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(new File("D:\\fileXml\\filwXmlWritte.xml")));

            outputStream.write(xStream.toXML(xmlTestResource).getBytes());

            outputStream.flush();
            outputStream.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
