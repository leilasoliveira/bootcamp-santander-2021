package com.dio.live.controledeponto.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Audited
public class Calendario {

    @Id
    private Long id;
    private String descricao;
    private LocalDateTime dataEspecial;

    @ManyToOne
    private TipoData tipoData;
}
