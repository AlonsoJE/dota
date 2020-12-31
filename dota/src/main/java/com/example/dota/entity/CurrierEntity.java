package com.example.dota.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "currier")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class CurrierEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, insertable = true, updatable = false)
    private Long id;

    @Column(name = "name",nullable = false, length = 100)
    @NotNull(message = "Nome não pode ser nulo!")
    @NotEmpty(message = "Nome não pode ser vazio!")
    @Size(min = 3, max = 100, message = "O 'nome' deve ter no mínimo {min} e no máximo {max} caracteres!")
    private String name;

    @Column(name = "create_user",nullable = false, insertable = true, updatable = false, length = 100)
    private String createUser;

    @Column(name = "create_date", nullable = false, insertable = true, updatable = false)
    private LocalDate createDate;

    @Column(name = "update_user", nullable = true, insertable = false, updatable = true, length = 100)
    private String updateUser;

    @Column(name = "update_date", nullable = true, insertable = false, updatable = true)
    private LocalDate updateDate;

    @JsonIgnore
    @OneToOne(mappedBy = "currier",  cascade = CascadeType.ALL,targetEntity = HeroEntity.class, fetch = FetchType.LAZY)
    private HeroEntity hero;

}
