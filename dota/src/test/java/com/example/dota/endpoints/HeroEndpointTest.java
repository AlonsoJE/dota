package com.example.dota.endpoints;

import com.example.dota.endpoint.HeroController;
import com.example.dota.entity.HeroEntity;
import com.example.dota.enums.ClassTypeEnum;
import com.example.dota.enums.FigthTypeEnum;
import com.example.dota.service.HeroService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = HeroController.class)
public class HeroEndpointTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HeroService heroService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Should Find All")
    public void shouldFindAll() throws Exception {

        List<HeroEntity> list = new ArrayList<>();

        list.add(new HeroEntity(1L, "Meepo", "Meepo", "Meepo", FigthTypeEnum.MELEE, ClassTypeEnum.AGI, "zeck", "zeck", LocalDate.now(), LocalDate.now()));
        list.add(new HeroEntity(2L, "Ember Spirit", "Ember", "Xin", FigthTypeEnum.MELEE, ClassTypeEnum.AGI, "zeck", "zeck", LocalDate.now(), LocalDate.now()));

        Mockito.when(heroService.findAll()).thenReturn(list);

        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8090/"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("Should Save New Object")
    public void shouldSaveNewObject() throws Exception {

        HeroEntity heroEntity = (new HeroEntity(1L, "Meepo", "Meepo", "Meepo", FigthTypeEnum.MELEE, ClassTypeEnum.AGI, "zeck", "zeck", LocalDate.now(), LocalDate.now()));

        Mockito.when(heroService.post(heroEntity)).thenReturn(heroEntity);

        mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8090/")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(heroEntity)))
                .andExpect(MockMvcResultMatchers.status().isCreated());

    }

}
