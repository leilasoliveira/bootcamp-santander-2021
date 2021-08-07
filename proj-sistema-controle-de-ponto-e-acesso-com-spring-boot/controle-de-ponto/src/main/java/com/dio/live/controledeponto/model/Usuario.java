package com.dio.live.controledeponto.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Audited
public class Usuario {

    @Id
    private Long id;
    private String nome;
    private BigDecimal tolerancia; // trabalha melhor ponto flutuante do que float ou double no Java
    private LocalDateTime inicioJornada;
    private LocalDateTime finalJornada;

    @ManyToOne
    private CategoriaUsuario categoriaUsuario;

    @ManyToOne
    private Empresa empresa;

    @ManyToOne
    private NivelAcesso nivelAcesso;

    @ManyToOne
    private JornadaTrabalho jornadaTrabalho;
}
