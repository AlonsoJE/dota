package com.example.dota.entity;

import com.example.dota.enums.ClassTypeEnum;
import com.example.dota.enums.FigthTypeEnum;
import lombok.*;
import org.apache.tomcat.jni.Local;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

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
    @Column(name = "id")
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

    @Column(name = "update_user", nullable = false, insertable = false, updatable = true)
    private String updateUser;

    @Column(name = "create_date", insertable = true,updatable = false)
    private LocalDate createDate;

    @Column(name = "update_date", insertable = false, updatable = true)
    private LocalDate updateDate;


}
