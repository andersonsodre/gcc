package br.org.institutoacqua.gcc.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;



import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Getter
@Setter
@Table(name = "cirurgias")
public class Cirurgia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate data;

    private LocalTime horario;

    private String paciente;

    @ManyToOne
    @JoinColumn(name = "procedimento_id", nullable = false)
    private Procedimento procedimento;

    private String cirurgiao;

    private String sala;

    @Enumerated(EnumType.STRING)
    private StatusCirurgia status;

    // getters e setters
}