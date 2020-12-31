package com.example.dota.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "item")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, insertable = true, updatable = false)
    private Long id;

    @Column(name = "name_item",nullable = false, length = 100)
    @NotNull(message = "Nome não pode ser nulo!")
    @NotEmpty(message = "Nome não pode ser vazio!")
    @Size(min = 3, max = 100, message = "O 'nome' deve ter no mínimo {min} e no máximo {max} caracteres!")
    private String nameItem;

    @Column(name = "about", length = 100)
    private String about;

    @Column(name = "price", nullable = false)
    private BigDecimal price = BigDecimal.ZERO;

    @Column(name = "cooldown")
    private Double cooldown;

    @Column(name = "action_item", length = 100)
    private String actionItem;

    @Column(name = "move_speed")
    private Integer moveSpeed;

    @Column(name = "damage")
    private Integer damage;

    @Column(name = "inteligence")
    private Integer inteligence;

    @Column(name = "strenght")
    private Integer strenght;

    @Column(name = "agility")
    private Integer agility;

    @Column(name = "create_user",nullable = false, insertable = true, updatable = false, length = 100)
    private String createUser;

    @Column(name = "create_date", nullable = false, insertable = true, updatable = false)
    private LocalDate createDate;

    @Column(name = "update_user", nullable = true, insertable = false, updatable = true, length = 100)
    private String updateUser;

    @Column(name = "update_date", nullable = true, insertable = false, updatable = true)
    private LocalDate updateDate;

    @OneToMany(mappedBy = "itemEntity", targetEntity = ItemHero.class, fetch = FetchType.LAZY)
    private List<ItemHero> itemHeroes;

}
