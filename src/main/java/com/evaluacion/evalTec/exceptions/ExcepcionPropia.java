package com.evaluacion.evalTec.exceptions;

public class ExcepcionPropia extends Exception{

    public String dontExist(){
        return "No se encontrĂ³ coincidencias";
    }

    public String datosIncompletos(){
        return "No se ingresaron todos los campos requeridos";
    }
}
