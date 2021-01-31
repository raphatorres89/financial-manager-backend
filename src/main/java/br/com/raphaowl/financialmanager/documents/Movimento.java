package br.com.raphaowl.financialmanager.documents;

import br.com.raphaowl.financialmanager.enums.TipoMovimento;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;

@Document(collection = "movimentos")
@Data
@Builder
public class Movimento {
    @Id
    private String id;
    private TipoMovimento tipo;
    private String nome;
    private BigDecimal valor;
    private LocalDate vencimento;
    private String parcela;
    private Boolean isPago;
    private Boolean isMedia;

}
