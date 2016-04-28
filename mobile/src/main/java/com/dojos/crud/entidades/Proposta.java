package com.dojos.crud.entidades;

/**
 * Created by thiagobarz on 26/04/2016.
 */
public class Proposta {

    private String codigo;
    private String segurado;
    private String franquia;
    private String status;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getSegurado() {
        return segurado;
    }

    public void setSegurado(String segurado) {
        this.segurado = segurado;
    }

    public String getFranquia() {
        return franquia;
    }

    public void setFranquia(String franquia) {
        this.franquia = franquia;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
