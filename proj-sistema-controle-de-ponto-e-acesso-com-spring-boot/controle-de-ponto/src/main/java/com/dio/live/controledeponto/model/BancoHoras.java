package com.dio.live.controledeponto.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Audited
public class BancoHoras {

    @EmbeddedId
    private BancoHorasId id;

    private LocalDateTime dataTrabalhada;
    private BigDecimal quantidadeHoras;
    private BigDecimal saldoHoras;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Embeddable
    public class BancoHorasId implements Serializable {
        private Long idBancoHoras;
        private Long idMovimento;
        private Long idUsuario;
    }
}
