package com.evaluacion.evalTec.models.enums;

public enum TipoDocumentoEnum {
    DNI("DNI"),
    LE("LE"),
    LC("LC");

    private final String string;

    TipoDocumentoEnum(final String string)
    {
        this.string = string;
    }

    public String obtener()
    {
        return string;
    }
}
