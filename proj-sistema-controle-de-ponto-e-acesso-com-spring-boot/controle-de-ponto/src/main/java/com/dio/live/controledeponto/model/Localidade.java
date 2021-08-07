package com.dio.live.controledeponto.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Audited
public class Localidade {
    @Id
    private Long id;
    private String descricao;

    @ManyToOne
    private NivelAcesso nivelAcesso;
}
