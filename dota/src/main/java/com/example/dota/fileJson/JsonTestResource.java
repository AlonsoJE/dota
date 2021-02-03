package com.example.dota.fileJson;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class JsonTestResource {

    private String nome;
    private int idade;
    private List<String> lista;
    private CidadeResourceJson cidade;



}
