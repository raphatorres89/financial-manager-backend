package br.com.raphaowl.financialmanager.api.v1.mapper;

import br.com.raphaowl.financialmanager.api.v1.dto.MovimentoDTO;
import br.com.raphaowl.financialmanager.documents.Movimento;
import br.com.raphaowl.financialmanager.enums.TipoMovimento;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MovimentoMapper {
    public static Movimento to(MovimentoDTO movimentoDTO) {
        return Movimento.builder()
                .isMedia(movimentoDTO.getIsMedia())
                .isPago(movimentoDTO.getIsPago())
                .nome(movimentoDTO.getNome())
                .parcela(movimentoDTO.getParcela())
                .tipo(TipoMovimento.valueOf(movimentoDTO.getTipo()))
                .vencimento(movimentoDTO.getVencimento() != null ? LocalDate.parse(movimentoDTO.getVencimento()) : null)
                .valor(BigDecimal.valueOf(movimentoDTO.getValor()))
                .build();
    }

    public static MovimentoDTO from(Movimento movimento) {
        return MovimentoDTO.builder()
                .id(movimento.getId())
                .isMedia(movimento.getIsMedia())
                .isPago(movimento.getIsPago())
                .nome(movimento.getNome())
                .parcela(movimento.getParcela())
                .tipo(movimento.getTipo().getNome())
                .vencimento(movimento.getVencimento() != null ? movimento.getVencimento().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) : null)
                .valor(movimento.getValor().doubleValue())
                .build();
    }

}
