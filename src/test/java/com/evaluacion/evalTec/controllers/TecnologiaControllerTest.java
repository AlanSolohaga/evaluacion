package com.evaluacion.evalTec.controllers;

import com.evaluacion.evalTec.models.entities.Tecnologia;
import com.evaluacion.evalTec.repository.CandidatoImplement;
import com.evaluacion.evalTec.repository.TecnologiaRepository;
import com.evaluacion.evalTec.services.CandidatoService;
import com.evaluacion.evalTec.services.TecnologiaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Optional;

import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = TecnologiaController.class)
class TecnologiaControllerTest {

    private final Logger logger = LoggerFactory.getLogger(CandidatoImplement.class);

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private TecnologiaService tecnologiaService;
    @MockBean
    private TecnologiaRepository tecnologiaRepository;

    @InjectMocks
    private TecnologiaController tecnologiaController;

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @BeforeEach
    private void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    void getTecnologias() throws Exception{
        MvcResult mvcResult = mockMvc.perform(get("/api/tecnologias"))
                .andExpect(status().isOk()).andReturn();
        logger.info("ESTADO "+mvcResult.getResponse().getStatus());
    }

    @Test
    void findTecnologia() throws Exception{
        MvcResult mvcResult = mockMvc.perform(get("/api/tecnologias/1"))
                .andExpect(status().isOk()).andReturn();
        logger.info("ESTADO "+mvcResult.getResponse().getStatus());
    }

    @Test
    void registerTecnologia() throws Exception{
        Tecnologia tecnologia = new Tecnologia();
        tecnologia.setId(123456);
        tecnologia.setNombre("Tec prueba");
        tecnologia.setVersion(1.3);

        String json = mapper.writeValueAsString(tecnologia);

        mockMvc.perform(post("/api/tecnologias")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}