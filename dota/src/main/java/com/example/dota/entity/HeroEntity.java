package com.example.dota.entity;

import com.example.dota.enums.ClassTypeEnum;
import com.example.dota.enums.FigthTypeEnum;
import com.fasterxml.jackson.annotation.*;
import lombok.*;
import org.apache.tomcat.jni.Local;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "heroes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class HeroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, insertable = true, updatable = false)
    private Long id;

    @Column(name = "name_hero", nullable = false, length = 100)
    private String nameHero;

    @Column(name = "nickname_hero", nullable = false)
    private String nickNameHero;

    @Column(name = "real_name", nullable = false)
    private String realName;

    @Column(name = "figth_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private FigthTypeEnum figthTypeEnum;

    @Column(name = "class_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private ClassTypeEnum classTypeEnum;

    @Column(name = "create_user", nullable = false, insertable = true, updatable = false)
    private String createUser;

    @Column(name = "update_user", insertable = false, updatable = true)
    private String updateUser;

    @Column(name = "create_date", insertable = true,updatable = false)
    private LocalDate createDate;

    @Column(name = "update_date", insertable = false, updatable = true)
    private LocalDate updateDate;

    @OneToOne()
    @JoinColumn(name = "currier_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_CURRIER_HERO"))
    @JsonBackReference
    private CurrierEntity currier;

    @OneToMany(mappedBy = "hero", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<SkinEntity> skins;

    @ManyToMany
    @JoinTable(name = "hero_item", uniqueConstraints = @UniqueConstraint(columnNames = {"hero_id","item_id"}),joinColumns = @JoinColumn(name = "hero_id"), inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<ItemEntity> item;


}
