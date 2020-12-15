package com.example.dota.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

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
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name_item", nullable = false)
    private String nameItem;

    @Column(name = "about")
    private String about;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "cooldown")
    private String cooldown;

    @Column(name = "action_item")
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

    @Column(name = "create_user",nullable = false, insertable = true, updatable = false)
    private String createUser;

    @Column(name = "create_date", nullable = false, insertable = true, updatable = false)
    private LocalDate createDate;

    @Column(name = "update_user", nullable = true, insertable = false, updatable = true)
    private String updateUser;

    @Column(name = "update_date", nullable = true, insertable = false, updatable = true)
    private LocalDate updateDate;

}
