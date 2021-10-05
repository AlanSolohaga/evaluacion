package com.evaluacion.evalTec.utilidades;

public class Utils {
    public static final String CANDIDATO_POR_CATEGORIA = "SELECT candidatos.*, cantec.años FROM candidatos JOIN cantec ON candidatos.id = cantec.id_candidato JOIN tecnologias ON tecnologias.id = cantec.id_tecnologia WHERE tecnologias.nombre = ?";
}
