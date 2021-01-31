package br.com.raphaowl.financialmanager.api.v1.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MovimentoDTO {
    private String id;
    private String tipo;
    private String nome;
    private Double valor;
    private String vencimento;
    private String parcela;
    private Boolean isPago;
    private Boolean isMedia;
}
