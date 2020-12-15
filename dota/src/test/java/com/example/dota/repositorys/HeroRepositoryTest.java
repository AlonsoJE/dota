package com.example.dota.repositorys;

import com.example.dota.entity.HeroEntity;
import com.example.dota.enums.ClassTypeEnum;
import com.example.dota.enums.FigthTypeEnum;
import com.example.dota.repository.HeroRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
public class HeroRepositoryTest {

    @MockBean
    private HeroRepository heroRepository;

    @Test
    @DisplayName("Should Persist When Create")
    public void shouldPersistWhenCreate(){
        HeroEntity heroEntity = new HeroEntity(1L, "Meepo", "Meepo", "Meepo", FigthTypeEnum.MELEE, ClassTypeEnum.AGI, "zeck", "zeck", LocalDate.now(), LocalDate.now());

        this.heroRepository.save(heroEntity);

        Assertions.assertEquals(1L, heroEntity.getId());

    }

    @Test
    @DisplayName("Should Remove When Delete")
    public void shouldRemoveWhenDelete(){
        HeroEntity heroEntity = new HeroEntity(1L, "Meepo", "Meepo", "Meepo", FigthTypeEnum.MELEE, ClassTypeEnum.AGI, "zeck", "zeck", LocalDate.now(), LocalDate.now());

        this.heroRepository.save(heroEntity);
        this.heroRepository.delete(heroEntity);

        Assertions.assertEquals("","");
    }


}
