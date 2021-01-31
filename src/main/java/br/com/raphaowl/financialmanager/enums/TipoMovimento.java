package br.com.raphaowl.financialmanager.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoMovimento {
    RECEITA("RECEITA"),
    DESPESA("DESPESA");

    private String nome;

}
