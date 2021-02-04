package com.example.dota.fileXml;


import com.example.dota.fileJson.CidadeResourceJson;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class XmlTestResource {

    private String nome;
    private int idade;
    private List<String> lista;
    private CidadeResourceJson cidade;

}
