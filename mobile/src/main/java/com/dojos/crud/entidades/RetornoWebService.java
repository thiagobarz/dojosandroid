package com.dojos.crud.entidades;

/**
 * Created by thiagobarz on 31/03/2016.
 */
public class RetornoWebService {
    private boolean retornoWs;
    private String mensagemRetorno;
    private Object retorno;

    public boolean isRetornoWs() {
        return retornoWs;
    }

    public void setRetornoWs(boolean retornoWs) {
        this.retornoWs = retornoWs;
    }

    public String getMensagemRetorno() {
        return mensagemRetorno;
    }

    public void setMensagemRetorno(String mensagemRetorno) {
        this.mensagemRetorno = mensagemRetorno;
    }

    public Object getRetorno() {
        return retorno;
    }

    public void setRetorno(Object retorno) {
        this.retorno = retorno;
    }
}
