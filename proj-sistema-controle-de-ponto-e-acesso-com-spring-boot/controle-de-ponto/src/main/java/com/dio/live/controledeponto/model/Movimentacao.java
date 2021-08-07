package com.dio.live.controledeponto.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Audited
public class Movimentacao {

    @EmbeddedId
    private MovimentacaoId id;
    private LocalDateTime dataEntrada;
    private LocalDateTime dataSaida;
    private BigDecimal periodoPermanencia;

    @ManyToOne
    private Ocorrencia ocorrencia;

    @ManyToOne
    private Calendario dataEspecial;

    // Serializable: transforma em bytes para trafegar dados para depois transformar novamente em objeto
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Embeddable
    public class MovimentacaoId implements Serializable {
        private Long idMovimento;
        private Long idUsuario;
    }
}
