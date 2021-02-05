package com.example.dota.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "BLOBBASE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class BlobBase64Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, insertable = true, updatable = false)
    private Long id;

    @Lob
    @Column(name = "arquivo")
    private byte[] arquivo;

}
