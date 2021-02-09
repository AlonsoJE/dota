package com.example.dota.endpoint;

import com.example.dota.exception.BadRequestException;
import com.example.dota.filter.HeroFilter;
import com.example.dota.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reports")
public class ReportsController {

    @Autowired
    private ReportService service;

    @GetMapping({"heroreport","/heroreport"})
    public ResponseEntity<?> htmlReportHero(@RequestBody HeroFilter filter) throws Exception {
        verifyFilter(filter);

        return  ResponseEntity.status(HttpStatus.OK).header(HttpHeaders.CONTENT_TYPE, "application/html").body(service.reportHero(filter));

    }


    private void verifyFilter(@RequestBody HeroFilter filter) {
        if(filter == null || filter.equals(null)){
            throw  new BadRequestException();
        }
    }

}
