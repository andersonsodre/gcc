package br.org.institutoacqua.gcc.model;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "procedimentos")
public class Procedimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String grupo;

    @Column(name = "sub_grupo", nullable = false)
    private String subGrupo;

    @Column(name = "forma_organizacao", nullable = false)
    private String formaOrganizacao;

    @Column(nullable = false, unique = true)
    private String codigo;

    @Column(nullable = false)
    private String nome;

    // Construtores
    public Procedimento() {
    }

    public Procedimento(String grupo, String subGrupo, String formaOrganizacao, String codigo, String nome) {
        this.grupo = grupo;
        this.subGrupo = subGrupo;
        this.formaOrganizacao = formaOrganizacao;
        this.codigo = codigo;
        this.nome = nome;
    }


}