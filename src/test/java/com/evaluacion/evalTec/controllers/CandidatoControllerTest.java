package com.evaluacion.evalTec.controllers;

import com.evaluacion.evalTec.models.entities.Candidato;
import com.evaluacion.evalTec.repository.CandidatoImplement;
import com.evaluacion.evalTec.services.CandidatoService;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServletRequest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = CandidatoController.class)
class CandidatoControllerTest {
    private final Logger logger = LoggerFactory.getLogger(CandidatoImplement.class);

    @MockBean
    private CandidatoService candidatoService;

    @InjectMocks
    private CandidatoController candidatoController;

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @BeforeEach
    private void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
    @Test
    void getCandidatos() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/candidatos")).andExpect(status().isOk()).andReturn();
        logger.info("ESTADO: "+mvcResult.getResponse().getStatus());
    }

    @Test
    void getCandidatosPorTecnologia() throws Exception {
        MvcResult mvcResult = mockMvc
                .perform(get("/api/candidatos/tecnologia/1"))
                .andExpect(status().isOk())
                .andReturn();
        logger.info("ESTADO: "+mvcResult.getResponse().getStatus());
    }

}