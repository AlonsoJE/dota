package com.example.dota.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "item_hero")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ItemHero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "create_user",nullable = false, insertable = true, updatable = false, length = 100)
    private String createUser;

    @Column(name = "create_date", nullable = false, insertable = true, updatable = false)
    private LocalDate createDate;

    @Column(name = "update_user", nullable = true, insertable = false, updatable = true, length = 100)
    private String updateUser;

    @Column(name = "update_date", nullable = true, insertable = false, updatable = true)
    private LocalDate updateDate;

    @ManyToOne(targetEntity = HeroEntity.class)
    @JoinColumn(name = "hero_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_HERO_ITEMHERO"))
    @JsonBackReference
    private HeroEntity heroEntity;

    @ManyToOne(targetEntity = ItemEntity.class)
    @JoinColumn(name = "item_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_ITEM_ITEMHERO"))
    @JsonBackReference
    private ItemEntity itemEntity;
}
