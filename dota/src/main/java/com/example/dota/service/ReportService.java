package com.example.dota.service;

import com.example.dota.filter.HeroFilter;
import com.example.dota.resource.HeroResource;
import com.example.dota.util.ParametersResource;
import com.example.dota.util.ReportGenerator;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReportService {

    @Autowired
    HeroService service;

    ReportGenerator generator;

    List<ParametersResource> parametersResource;
    public String reportHero(HeroFilter filter) throws IOException, JRException {

        String path = "D:\\projetos\\java\\reports\\exemplo.jasper";

        generator = new ReportGenerator();

        parametersResource = new ArrayList<>();

        List<HeroResource> heroResources = (List<HeroResource>) service.findByFilter(filter);

        return generator.generateReport(path, generator.parameters(parametersResource), heroResources, "html");

    }

}
