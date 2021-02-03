package com.example.dota.fileExcel;

import lombok.Cleanup;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class FileExcelPOI {

    // Para lidar com um arquivo excel, é necessário ter um modelo do mesmo para fazer seu mapeamento!
    // É mais fácil ler um excel tendo um resource com construtor BUILDER! Ou anotação @Builder do Lombok!

    List<ExcelTesteResource> excelTesteResourceList;

    // Ler um arquivo excel e montar um objeto ou uma lista do meu objeto, ja com os tipos predefinidos e prontos pra uso.
    public void lerExcelExistenteComTipos(){

        try {

            excelTesteResourceList = new ArrayList<>();

            // recuperando o arquivo
            @Cleanup InputStream file = new BufferedInputStream(new FileInputStream("D:\\fileExcel\\excelTeste.xlsx"));

            // recuperando os dados em excel
            Workbook workbook = new XSSFWorkbook(file);

//            //pegar a folha por index
            Sheet sheet = workbook.getSheetAt(0);

            // pegar linhas
            Iterator<Row> rowIterator = sheet.rowIterator();

            // pular o cabeçalho
            rowIterator.next();

            while (rowIterator.hasNext()){
                Row row = rowIterator.next();

                // criar o armazenador de celulas
                Iterator<Cell> cellIterator = row.cellIterator();

                ExcelTesteResource excelTesteResource = new ExcelTesteResource();

                while (cellIterator.hasNext()){

                    // pegar celula a celula individualmente
                    Cell cell = cellIterator.next();

                    // fazer o que quiser com a celula
                    switch (cell.getColumnIndex()){
                        case 0:
                            excelTesteResource.setData(cell.getDateCellValue().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                            break;
                        case 1:
                            excelTesteResource.setName(cell.getStringCellValue());
                            break;
                        case 2:
                            excelTesteResource.setValor(new BigDecimal(String.valueOf(cell.getNumericCellValue())).setScale(2));
                            break;
                        case 3:
                            excelTesteResource.setStatus(cell.getStringCellValue());
                            break;
                        case 4:
                            excelTesteResource.setParcela((int) cell.getNumericCellValue());
                            break;
                        case 5:
                            excelTesteResource.setTotal(new BigDecimal(String.valueOf(cell.getNumericCellValue())));
                    }
                }
                excelTesteResourceList.add(excelTesteResource);
            }

            excelTesteResourceList.stream().forEach((e) ->{
                System.out.println(e);
            });

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void escreverExcel(){

        Workbook workbook = new XSSFWorkbook();

        Sheet sheet = workbook.createSheet("FolhaTeste");

        List<ExcelTesteResource> excelTesteResources = new ArrayList<>();

        excelTesteResources.add(new ExcelTesteResource(LocalDate.now(), "Zeck", new BigDecimal("33.20"), "ABERTO", 3, new BigDecimal("99.80")));
        excelTesteResources.add(new ExcelTesteResource(LocalDate.now(), "Zeck", new BigDecimal("33.20"), "ABERTO", 3, new BigDecimal("99.80")));
        excelTesteResources.add(new ExcelTesteResource(LocalDate.now(), "Zeck", new BigDecimal("33.20"), "ABERTO", 3, new BigDecimal("99.80")));
        excelTesteResources.add(new ExcelTesteResource(LocalDate.now(), "Zeck", new BigDecimal("33.20"), "ABERTO", 3, new BigDecimal("99.80")));
        excelTesteResources.add(new ExcelTesteResource(LocalDate.now(), "Zeck", new BigDecimal("33.20"), "ABERTO", 3, new BigDecimal("99.80")));

        AtomicInteger rowCount = new AtomicInteger();

        excelTesteResources.stream().forEach((e)->{
            Row row = sheet.createRow(rowCount.getAndIncrement());
            int cellCount = 0;
            Cell cellData = row.createCell(cellCount++);
            cellData.setCellValue(e.getData());
            Cell cellName = row.createCell(cellCount++);
            cellName.setCellValue(e.getName());
            Cell cellValue = row.createCell(cellCount++);
            cellValue.setCellValue(e.getValor().toString());
            Cell cellStatus = row.createCell(cellCount++);
            cellStatus.setCellValue(e.getStatus());
            Cell cellParcela = row.createCell(cellCount++);
            cellParcela.setCellValue(e.getParcela());
            Cell cellTotal = row.createCell(cellCount++);
            cellTotal.setCellValue(e.getTotal().toString());
        });

        try {
            @Cleanup FileOutputStream fileOutputStream = new FileOutputStream(new File("D:\\fileExcel\\excelEscritoTeste.xlsx"));

            workbook.write(fileOutputStream);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

