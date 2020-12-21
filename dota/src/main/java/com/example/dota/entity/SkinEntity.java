package com.example.dota.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "skin")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class SkinEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, insertable = true, updatable = false)
    private Long id;

    @Column(name = "name", insertable = true, updatable = true, nullable = false, unique = true, length = 100)
    private String name;

    @Column(name = "price")
    private BigDecimal price = BigDecimal.ZERO;

    @Column(name = "style", nullable = false, unique = false, length = 100)
    private String style;

    @Column(name = "create_user",nullable = false, insertable = true, updatable = false, length = 100)
    private String createUser;

    @Column(name = "create_date", nullable = false, insertable = true, updatable = false)
    private LocalDate createDate;

    @Column(name = "update_user", nullable = true, insertable = false, updatable = true, length = 100)
    private String updateUser;

    @Column(name = "update_date", nullable = true, insertable = false, updatable = true)
    private LocalDate updateDate;

    @ManyToOne
    @JoinColumn(name = "hero_id")
    @JsonIgnoreProperties("skins")
    private HeroEntity hero;




}
