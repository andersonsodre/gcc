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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public Procedimento getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(Procedimento procedimento) {
        this.procedimento = procedimento;
    }

    public String getCirurgiao() {
        return cirurgiao;
    }

    public void setCirurgiao(String cirurgiao) {
        this.cirurgiao = cirurgiao;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public StatusCirurgia getStatus() {
        return status;
    }

    public void setStatus(StatusCirurgia status) {
        this.status = status;
    }
}