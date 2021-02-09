package com.example.dota.util;

import com.example.dota.fileBase64.FileBase64Teste;
import lombok.Cleanup;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.util.*;

public class ReportGenerator {

    @Autowired
    FileBase64Teste fileBase64Teste;

    public Map<String, Object> parameters(List<ParametersResource> p){

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("REPORT_LOCALE", new Locale("pt", "BR"));

        if(!p.isEmpty()) {
            p.stream().forEach((e) -> {
                parameters.put(e.getA(), e.getB());
            });
        }

        return parameters;
    }

    public String generateReport(String path, Map<String, Object> parameters, List<?> list, String format) throws IOException, JRException {

        String result = null;

        try {

            JRBeanCollectionDataSource collection = new JRBeanCollectionDataSource(list);

            InputStream inputStream = new BufferedInputStream(new FileInputStream(path));

            JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, parameters, collection);

            result = generateFormatReport(format, jasperPrint);

        } catch (FileNotFoundException e) {
            throw  new FileNotFoundException(e.getMessage());
        }
        return result;
    }

    public String generateFormatReport(String format, JasperPrint jasperPrint) throws JRException, IOException {

        String result = null;
        byte[] report;
        String html = "D:\\jasper\\htmlFiles\\report.html";
        String pdf = "D:\\jasper\\htmlFiles\\report.pdf";

        switch (format){
            case "html":
                JasperExportManager.exportReportToHtmlFile(jasperPrint, html);
                InputStream inputStream = new BufferedInputStream(new FileInputStream(html));

                byte[] buffer = new byte[inputStream.available()];

                inputStream.read(buffer);

                result = Base64.getEncoder().encodeToString(buffer);
                break;
            case "pdf":
                result = Base64.getEncoder().encodeToString(JasperExportManager.exportReportToPdf(jasperPrint));
                report = Base64.getDecoder().decode(result);
                @Cleanup OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(pdf));
                outputStream.write(report);
                outputStream.flush();
                outputStream.close();
                break;
        }
        return result;
    }

}
