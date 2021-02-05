package com.example.dota.resource;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class BlobBase64Resource {

    private Long id;
    private byte[] arquivo;

}
