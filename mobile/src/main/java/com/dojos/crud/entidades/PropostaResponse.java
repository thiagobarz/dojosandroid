package com.dojos.crud.entidades;

import java.util.List;

/**
 * Created by thiagobarz on 28/04/2016.
 */
public class PropostaResponse {

    private List<Proposta> propostas;

    public List<Proposta> getPropostas() {
        return propostas;
    }

    public void setPropostas(List<Proposta> propostas) {
        this.propostas = propostas;
    }
}
